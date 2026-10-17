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
import android.os.Handler
import android.os.IBinder
import android.os.Looper
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
    private var mediaSession: MediaSessionCompat? = null
    private var lastLocation: Location? = null
    private var distanceMeters = 0.0
    private var startedAt = 0L
    private val pending = ArrayDeque<String>()
    private var speaking = false

    private val tick = object : Runnable {
        override fun run() {
            if (!engine.running) {
                return
            }
            val elapsed = System.currentTimeMillis() - startedAt
            val distance = if (lastLocation == null) null else distanceMeters
            engine.onTick(elapsed, distance).forEach { speak(it) }
            handler.postDelayed(this, TICK_MILLIS)
        }
    }

    override fun onCreate() {
        super.onCreate()
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
        speak(engine.start(kind))
        listenForLocation()
        handler.post(tick)
        refreshPlaybackState()
    }

    private fun stopSession() {
        if (!engine.running) {
            return
        }
        handler.removeCallbacks(tick)
        getSystemService(LocationManager::class.java).removeUpdates(this)
        speak(engine.stop())
        refreshPlaybackState()
    }

    private fun speak(line: String) {
        pending.add(line)
        if (ttsReady && !speaking) {
            speakNext()
        }
    }

    private fun speakNext() {
        val line = pending.removeFirstOrNull()
        if (line == null) {
            speaking = false
            return
        }
        speaking = true
        tts?.speak(line, TextToSpeech.QUEUE_ADD, null, line)
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

    private fun notification(): Notification {
        val open = PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java),
            PendingIntent.FLAG_IMMUTABLE,
        )
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.notification_title))
            .setContentText(getString(R.string.notification_text))
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(open)
            .setOngoing(true)
            .build()
    }

    companion object {
        const val ACTION_START_INTERVAL = "app.runningcoach.START_INTERVAL"
        const val ACTION_START_STEADY = "app.runningcoach.START_STEADY"
        const val ACTION_STOP = "app.runningcoach.STOP"
        const val ACTION_MEDIA = "app.runningcoach.MEDIA"
        private const val CHANNEL_ID = "coach"
        private const val NOTIFICATION_ID = 1
        private const val TICK_MILLIS = 1_000L
    }
}
