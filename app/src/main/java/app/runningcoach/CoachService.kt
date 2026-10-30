package app.runningcoach

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.media.session.MediaButtonReceiver
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import java.util.Locale

class CoachService : Service(), TextToSpeech.OnInitListener, LocationListener {
    private val engine = SessionEngine()
    private val handler = Handler(Looper.getMainLooper())
    private var tts: TextToSpeech? = null
    private var ttsReady = false
    private var recognizer: SpeechRecognizer? = null
    private var mediaSession: MediaSessionCompat? = null
    private var lastLocation: Location? = null
    private var distanceMeters = 0.0
    private var startedAt = 0L
    private val pending = ArrayDeque<String>()
    private var speaking = false
    private var previousLineIsQuestion = false
    private var listening = false
    private var spokenVisible = ""
    private var revealGeneration = 0
    private lateinit var history: SessionHistory

    private val tick = object : Runnable {
        override fun run() {
            if (!engine.running) {
                return
            }
            val elapsed = System.currentTimeMillis() - startedAt
            val distance = if (lastLocation == null) null else distanceMeters
            engine.onTick(elapsed, distance).forEach { speak(it) }
            publishSessionState()
            handler.postDelayed(this, TICK_MILLIS)
        }
    }

    override fun onCreate() {
        super.onCreate()
        history = SessionHistory(this)
        createChannel()
        tts = TextToSpeech(this, this)
        mediaSession = MediaSessionCompat(this, "RunningCoach").apply {
            setCallback(object : MediaSessionCompat.Callback() {
                override fun onPlay() {
                    startSession(SessionKind.INTERVAL)
                }

                override fun onPause() {
                    stopSession()
                }

                override fun onStop() {
                    stopSession()
                }
            })
            isActive = true
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startInForeground()
        when (intent?.action) {
            ACTION_START_INTERVAL -> startSession(SessionKind.INTERVAL)
            ACTION_START_STEADY -> startSession(SessionKind.STEADY)
            ACTION_STOP -> stopSession()
            ACTION_MEDIA -> if (engine.running) stopSession() else startSession(SessionKind.INTERVAL)
            ACTION_ASK -> intent.getStringExtra(EXTRA_QUESTION)?.let { ask(it) }
            Intent.ACTION_MEDIA_BUTTON -> MediaButtonReceiver.handleIntent(mediaSession, intent)
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onInit(status: Int) {
        if (status != TextToSpeech.SUCCESS) {
            return
        }
        tts?.language = Locale.ENGLISH
        tts?.setSpeechRate(history.speechRate)
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {}

            override fun onDone(utteranceId: String?) {
                handler.post { speakNext() }
            }

            @Deprecated("Deprecated in Java")
            override fun onError(utteranceId: String?) {
                handler.post { speakNext() }
            }
        })
        ttsReady = true
        speakNext()
    }

    override fun onLocationChanged(location: Location) {
        val previous = lastLocation
        if (previous != null) {
            distanceMeters += previous.distanceTo(location)
        }
        lastLocation = location
    }

    override fun onDestroy() {
        handler.removeCallbacks(tick)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getSystemService(LocationManager::class.java).removeUpdates(this)
        }
        recognizer?.destroy()
        mediaSession?.release()
        tts?.shutdown()
        super.onDestroy()
    }

    private fun startSession(kind: SessionKind) {
        if (engine.running) {
            return
        }
        distanceMeters = 0.0
        lastLocation = null
        startedAt = System.currentTimeMillis()
        tts?.setSpeechRate(history.speechRate)
        spokenVisible = ""
        speak(engine.start(kind))
        listenForLocation()
        listenForSpeech()
        handler.post(tick)
        refreshPlaybackState()
    }

    private fun stopSession() {
        if (!engine.running) {
            return
        }
        handler.removeCallbacks(tick)
        recognizer?.stopListening()
        listening = false
        getSystemService(LocationManager::class.java).removeUpdates(this)
        val summary = engine.summaryPhrase()
        val keep = engine.shouldKeepRecord()
        val record = RunRecord(
            atMillis = System.currentTimeMillis(),
            kind = engine.kind,
            elapsedMillis = engine.elapsedMillis,
            distanceMeters = engine.distanceMeters,
            summary = summary,
        )
        speak(engine.stop())
        speak(summary)
        if (keep) {
            history.add(record)
        }
        refreshPlaybackState()
    }

    private fun ask(question: String) {
        val text = question.lowercase()
        if (!engine.running && (text.contains("steady") || text.contains("easy"))) {
            startSession(SessionKind.STEADY)
            return
        }
        if (!engine.running && text.contains("start")) {
            startSession(SessionKind.INTERVAL)
            return
        }
        if (engine.running && text.contains("stop")) {
            stopSession()
            return
        }
        previousLineIsQuestion = true
        engine.remember(question)
        speak(engine.answer(question))
    }

    private fun speak(line: String) {
        engine.remember(line)
        pending.add(line)
        publishSessionState()
        previousLineIsQuestion = false
        if (ttsReady && !speaking) {
            speakNext()
        }
    }

    private fun speakNext() {
        val line = pending.removeFirstOrNull()
        if (line == null) {
            revealGeneration++
            speaking = false
            if (engine.running) {
                listening = true
            }
            publishSessionState()
            return
        }
        speaking = true
        listening = false
        startReveal(line)
        tts?.speak(line, TextToSpeech.QUEUE_ADD, null, line)
    }

    private fun startReveal(line: String) {
        revealGeneration++
        val generation = revealGeneration
        val words = line.trim().split(WORD_BREAK).filter { it.isNotEmpty() }
        if (words.isEmpty()) {
            spokenVisible = line
            publishSessionState()
            return
        }
        spokenVisible = words.first()
        publishSessionState()
        words.forEachIndexed { index, _ ->
            if (index == 0) {
                return@forEachIndexed
            }
            handler.postDelayed({
                if (generation != revealGeneration) {
                    return@postDelayed
                }
                spokenVisible = words.take(index + 1).joinToString(" ")
                publishSessionState()
            }, index * WORD_MILLIS)
        }
    }

    private fun listenForLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        val manager = getSystemService(LocationManager::class.java)
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return
        }
        val provider = LocationManager.GPS_PROVIDER
        manager.requestLocationUpdates(provider, TICK_MILLIS, 0f, this, Looper.getMainLooper())
    }

    private fun listenForSpeech() {
        if (!SpeechRecognizer.isRecognitionAvailable(this)) {
            return
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        if (recognizer == null) {
            recognizer = SpeechRecognizer.createSpeechRecognizer(this).also { it.setRecognitionListener(listener) }
        }
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, false)
        }
        recognizer?.startListening(intent)
        if (engine.running && !speaking) {
            listening = true
            publishSessionState()
        }
    }

    private val listener = object : RecognitionListener {
        override fun onResults(results: Bundle?) {
            val said = results
                ?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                ?.firstOrNull()
            if (said != null) {
                ask(said)
            }
            if (engine.running) {
                listenForSpeech()
            }
        }

        override fun onError(error: Int) {
            if (engine.running) {
                handler.postDelayed({ listenForSpeech() }, TICK_MILLIS)
            }
        }

        override fun onReadyForSpeech(params: Bundle?) {
            if (engine.running && !speaking) {
                listening = true
                publishSessionState()
            }
        }

        override fun onBeginningOfSpeech() {
            if (engine.running && !speaking) {
                listening = true
                publishSessionState()
            }
        }
        override fun onRmsChanged(rmsdB: Float) {}
        override fun onBufferReceived(buffer: ByteArray?) {}
        override fun onEndOfSpeech() {}
        override fun onPartialResults(partialResults: Bundle?) {}
        override fun onEvent(eventType: Int, params: Bundle?) {}
    }

    private fun refreshPlaybackState() {
        val state = if (engine.running) PlaybackStateCompat.STATE_PLAYING else PlaybackStateCompat.STATE_STOPPED
        val actions = PlaybackStateCompat.ACTION_PLAY or
            PlaybackStateCompat.ACTION_PAUSE or
            PlaybackStateCompat.ACTION_STOP or
            PlaybackStateCompat.ACTION_PLAY_PAUSE
        mediaSession?.setPlaybackState(
            PlaybackStateCompat.Builder().setActions(actions).setState(state, 0, 1f).build(),
        )
    }

    private fun startInForeground() {
        val notice = notification()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                NOTIFICATION_ID,
                notice,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION or ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK,
            )
        } else {
            startForeground(NOTIFICATION_ID, notice)
        }
    }

    private fun createChannel() {
        val channel = NotificationChannel(CHANNEL_ID, "Running coach", NotificationManager.IMPORTANCE_LOW)
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }

    private fun publishSessionState() {
        val intent = Intent(ACTION_SESSION_STATE).setPackage(packageName)
        intent.putExtra(EXTRA_RUNNING, engine.running)
        intent.putExtra(EXTRA_KIND, engine.kind.name)
        val stats = engine.statsForDisplay()
        intent.putExtra(EXTRA_STAT_TIME, stats[0])
        intent.putExtra(EXTRA_STAT_PACE, stats[1])
        intent.putExtra(EXTRA_STAT_DISTANCE, stats[2])
        val spoken = engine.lastLines
        intent.putExtra(EXTRA_LINE_CURRENT, spoken.lastOrNull() ?: "")
        intent.putExtra(EXTRA_LINE_PREVIOUS, spoken.getOrNull(spoken.size - 2) ?: "")
        intent.putExtra(EXTRA_LINE_IS_QUESTION, previousLineIsQuestion)
        intent.putExtra(EXTRA_LINE_VISIBLE, spokenVisible)
        intent.putExtra(
            EXTRA_PHASE,
            when {
                speaking || pending.isNotEmpty() -> PHASE_SPEAK
                listening -> PHASE_LISTEN
                else -> PHASE_IDLE
            },
        )
        sendBroadcast(intent, SESSION_STATE_PERMISSION)
        val notice = if (engine.running) {
            notification(lines = stats)
        } else {
            notification()
        }
        getSystemService(NotificationManager::class.java).notify(NOTIFICATION_ID, notice)
    }

    private fun notification(lines: List<String>? = null): Notification {
        val open = PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE,
        )
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.notification_title))
            .setContentText(
                if (lines == null) {
                    getString(R.string.notification_text)
                } else {
                    lines.joinToString(" ")
                },
            )
            .setSmallIcon(R.drawable.ic_notification)
            .setColor(ContextCompat.getColor(this, R.color.accent_default))
            .setContentIntent(open)
            .setOngoing(true)
            .build()
    }

    companion object {
        const val ACTION_START_INTERVAL = "app.runningcoach.START_INTERVAL"
        const val ACTION_START_STEADY = "app.runningcoach.START_STEADY"
        const val ACTION_STOP = "app.runningcoach.STOP"
        const val ACTION_MEDIA = "app.runningcoach.MEDIA"
        const val ACTION_ASK = "app.runningcoach.ASK"
        const val ACTION_SESSION_STATE = "app.runningcoach.SESSION_STATE"
        const val SESSION_STATE_PERMISSION = "app.runningcoach.SESSION_STATE"
        const val EXTRA_QUESTION = "question"
        const val EXTRA_RUNNING = "running"
        const val EXTRA_KIND = "kind"
        const val EXTRA_STAT_TIME = "stat_time"
        const val EXTRA_STAT_PACE = "stat_pace"
        const val EXTRA_STAT_DISTANCE = "stat_distance"
        const val EXTRA_LINE_CURRENT = "line_current"
        const val EXTRA_LINE_PREVIOUS = "line_previous"
        const val EXTRA_LINE_IS_QUESTION = "line_is_question"
        const val EXTRA_LINE_VISIBLE = "line_visible"
        const val EXTRA_PHASE = "phase"
        const val PHASE_IDLE = "idle"
        const val PHASE_LISTEN = "listen"
        const val PHASE_SPEAK = "speak"
        private const val CHANNEL_ID = "coach"
        private const val NOTIFICATION_ID = 1
        private const val TICK_MILLIS = 1_000L
        private const val WORD_MILLIS = 170L
        private val WORD_BREAK = Regex("\\s+")
    }
}
