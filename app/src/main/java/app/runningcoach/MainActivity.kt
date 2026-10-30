package app.runningcoach

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.LocationManager
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    private lateinit var sessionStatus: TextView
    private lateinit var statTime: TextView
    private lateinit var statPace: TextView
    private lateinit var statDistance: TextView
    private lateinit var locationWarning: TextView
    private lateinit var coachSheet: View
    private lateinit var coachOrb: CoachOrbView
    private lateinit var coachPhase: TextView
    private lateinit var coachSpeakPopup: View
    private lateinit var coachLive: TextView
    private lateinit var coachPopupTime: TextView
    private var speakPulse: ObjectAnimator? = null
    private lateinit var viewRun: View
    private lateinit var viewHistory: View
    private lateinit var viewReport: View
    private lateinit var viewProfile: View
    private lateinit var historyList: LinearLayout
    private lateinit var historyEmpty: View
    private lateinit var tabRun: Button
    private lateinit var tabHistory: Button
    private lateinit var tabProfile: Button
    private lateinit var history: SessionHistory
    private var shownView: Int = R.id.viewRun

    private val permissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions(),
    ) {
        refreshLocationWarning()
    }

    private val sessionReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action != CoachService.ACTION_SESSION_STATE) {
                return
            }
            val running = intent.getBooleanExtra(CoachService.EXTRA_RUNNING, false)
            applyCoachSheet(intent)
            if (running) {
                val kind = intent.getStringExtra(CoachService.EXTRA_KIND)
                sessionStatus.setText(
                    if (kind == SessionKind.STEADY.name) R.string.session_steady else R.string.session_interval,
                )
                applyStats(intent)
                return
            }
            val current = intent.getStringExtra(CoachService.EXTRA_LINE_CURRENT).orEmpty()
            if (current.isNotEmpty()) {
                sessionStatus.setText(R.string.session_finished)
                applyStats(intent)
                return
            }
            sessionStatus.setText(R.string.session_idle)
            statTime.setText(R.string.stat_idle_time)
            statPace.setText(R.string.stat_idle_pace)
            statDistance.setText(R.string.stat_idle_distance)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        history = SessionHistory(this)
        sessionStatus = findViewById(R.id.sessionStatus)
        statTime = findViewById(R.id.statTime)
        statPace = findViewById(R.id.statPace)
        statDistance = findViewById(R.id.statDistance)
        locationWarning = findViewById(R.id.locationWarning)
        coachSheet = findViewById(R.id.coachSheet)
        coachOrb = findViewById(R.id.coachOrb)
        coachPhase = findViewById(R.id.coachPhase)
        coachSpeakPopup = findViewById(R.id.coachSpeakPopup)
        coachLive = findViewById(R.id.coachLive)
        coachPopupTime = findViewById(R.id.coachPopupTime)
        viewRun = findViewById(R.id.viewRun)
        viewHistory = findViewById(R.id.viewHistory)
        viewReport = findViewById(R.id.viewReport)
        viewProfile = findViewById(R.id.viewProfile)
        historyList = findViewById(R.id.historyList)
        historyEmpty = findViewById(R.id.historyEmpty)
        tabRun = findViewById(R.id.tabRun)
        tabHistory = findViewById(R.id.tabHistory)
        tabProfile = findViewById(R.id.tabProfile)

        askForPermissions()
        refreshLocationWarning()
        findViewById<Button>(R.id.historyStart).setOnClickListener { showView(R.id.viewRun) }

        findViewById<Button>(R.id.startInterval).setOnClickListener {
            send(CoachService.ACTION_START_INTERVAL)
        }
        findViewById<Button>(R.id.startSteady).setOnClickListener {
            send(CoachService.ACTION_START_STEADY)
        }
        findViewById<Button>(R.id.stopSession).setOnClickListener {
            send(CoachService.ACTION_STOP)
        }
        findViewById<Button>(R.id.ask).setOnClickListener {
            val question = findViewById<EditText>(R.id.question).text.toString()
            send(CoachService.ACTION_ASK, question)
        }
        tabRun.setOnClickListener { showView(R.id.viewRun) }
        tabHistory.setOnClickListener { showView(R.id.viewHistory) }
        tabProfile.setOnClickListener { showView(R.id.viewProfile) }
        findViewById<Button>(R.id.profileSave).setOnClickListener {
            history.displayName = findViewById<EditText>(R.id.profileName).text.toString().trim()
        }
        findViewById<Button>(R.id.voiceSlower).setOnClickListener { setSpeechRate(0.8f) }
        findViewById<Button>(R.id.voiceNormal).setOnClickListener { setSpeechRate(1.0f) }
        findViewById<Button>(R.id.voiceFaster).setOnClickListener { setSpeechRate(1.2f) }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    when (shownView) {
                        R.id.viewReport -> showView(R.id.viewHistory)
                        R.id.viewHistory, R.id.viewProfile -> showView(R.id.viewRun)
                        else -> {
                            isEnabled = false
                            onBackPressedDispatcher.onBackPressed()
                            isEnabled = true
                        }
                    }
                }
            },
        )
        showView(R.id.viewRun)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(CoachService.ACTION_SESSION_STATE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(
                sessionReceiver,
                filter,
                CoachService.SESSION_STATE_PERMISSION,
                null,
                RECEIVER_NOT_EXPORTED,
            )
        } else {
            @Suppress("DEPRECATION")
            registerReceiver(sessionReceiver, filter, CoachService.SESSION_STATE_PERMISSION, null)
        }
    }

    override fun onStop() {
        unregisterReceiver(sessionReceiver)
        super.onStop()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                send(CoachService.ACTION_START_INTERVAL)
                return true
            }
            KeyEvent.KEYCODE_VOLUME_UP -> {
                send(CoachService.ACTION_START_STEADY)
                return true
            }
            KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, KeyEvent.KEYCODE_HEADSETHOOK -> {
                send(CoachService.ACTION_MEDIA)
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun showView(id: Int) {
        shownView = id
        viewRun.visibility = if (id == R.id.viewRun) View.VISIBLE else View.GONE
        viewHistory.visibility = if (id == R.id.viewHistory) View.VISIBLE else View.GONE
        viewReport.visibility = if (id == R.id.viewReport) View.VISIBLE else View.GONE
        viewProfile.visibility = if (id == R.id.viewProfile) View.VISIBLE else View.GONE
        val active = ContextCompat.getColor(this, R.color.accent_default)
        val idle = ContextCompat.getColor(this, R.color.text_muted)
        tabRun.setTextColor(if (id == R.id.viewRun) active else idle)
        tabHistory.setTextColor(if (id == R.id.viewHistory || id == R.id.viewReport) active else idle)
        tabProfile.setTextColor(if (id == R.id.viewProfile) active else idle)
        if (id == R.id.viewHistory) {
            bindHistory()
        }
        if (id == R.id.viewProfile) {
            bindProfile()
        }
    }

    private fun bindHistory() {
        val records = history.sessions()
        historyList.removeAllViews()
        historyEmpty.visibility = if (records.isEmpty()) View.VISIBLE else View.GONE
        val inflater = LayoutInflater.from(this)
        val gap = resources.getDimensionPixelSize(R.dimen.spacing_8)
        for (record in records) {
            val row = inflater.inflate(R.layout.view_history_row, historyList, false)
            row.findViewById<TextView>(R.id.rowStamp).text = record.stamp()
            row.findViewById<TextView>(R.id.rowKind).setText(
                if (record.kind == SessionKind.STEADY) R.string.kind_steady else R.string.kind_interval,
            )
            row.findViewById<TextView>(R.id.rowTime).text = SessionEngine.displayTime(record.elapsedMillis)
            row.findViewById<TextView>(R.id.rowDistance).text = SessionEngine.displayDistance(record.distanceMeters)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            params.topMargin = gap
            row.layoutParams = params
            row.setOnClickListener { openReport(record) }
            historyList.addView(row)
        }
    }

    private fun openReport(record: RunRecord) {
        findViewById<TextView>(R.id.reportStamp).text = record.stamp()
        findViewById<TextView>(R.id.reportKind).setText(
            if (record.kind == SessionKind.STEADY) R.string.kind_steady else R.string.kind_interval,
        )
        findViewById<TextView>(R.id.reportTime).text = SessionEngine.displayTime(record.elapsedMillis)
        findViewById<TextView>(R.id.reportPace).text =
            SessionEngine.displayPace(record.elapsedMillis, record.distanceMeters)
        findViewById<TextView>(R.id.reportDistance).text = SessionEngine.displayDistance(record.distanceMeters)
        findViewById<TextView>(R.id.reportSummary).text = record.summary
        showView(R.id.viewReport)
    }

    private fun bindProfile() {
        findViewById<EditText>(R.id.profileName).setText(history.displayName)
        val records = history.sessions()
        val metres = records.mapNotNull { it.distanceMeters }.sum()
        findViewById<TextView>(R.id.profileTotals).text = getString(
            R.string.profile_totals,
            records.size,
            SessionEngine.displayDistance(if (metres > 0.0) metres else null),
        )
    }

    private fun setSpeechRate(rate: Float) {
        history.speechRate = rate
    }

    private fun applyStats(intent: Intent) {
        val time = intent.getStringExtra(CoachService.EXTRA_STAT_TIME)
        statTime.text = time
        coachPopupTime.text = time
        statPace.text = intent.getStringExtra(CoachService.EXTRA_STAT_PACE)
        statDistance.text = intent.getStringExtra(CoachService.EXTRA_STAT_DISTANCE)
    }

    private fun applyCoachSheet(intent: Intent) {
        when (intent.getStringExtra(CoachService.EXTRA_PHASE)) {
            CoachService.PHASE_SPEAK -> {
                showCoachSheet()
                coachOrb.listening = false
                coachPhase.setText(R.string.coach_speaking)
                val live = intent.getStringExtra(CoachService.EXTRA_LINE_VISIBLE).orEmpty()
                if (live.isNotEmpty()) {
                    coachLive.text = live
                }
                showSpeakPopup()
            }
            CoachService.PHASE_LISTEN -> {
                hideSpeakPopup()
                showCoachSheet()
                coachOrb.listening = true
                coachPhase.setText(R.string.coach_listening)
            }
            else -> {
                hideSpeakPopup()
                coachSheet.animate().cancel()
                coachSheet.visibility = View.GONE
            }
        }
    }

    private fun showSpeakPopup() {
        if (coachSpeakPopup.visibility == View.VISIBLE) {
            return
        }
        coachSpeakPopup.visibility = View.VISIBLE
        if (!ValueAnimator.areAnimatorsEnabled()) {
            coachSpeakPopup.alpha = 1f
            coachSpeakPopup.scaleX = 1f
            coachSpeakPopup.scaleY = 1f
            return
        }
        coachSpeakPopup.alpha = 0f
        coachSpeakPopup.scaleX = 0.86f
        coachSpeakPopup.scaleY = 0.86f
        coachSpeakPopup.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(180)
            .withEndAction { startSpeakPulse() }
            .start()
    }

    private fun hideSpeakPopup() {
        speakPulse?.cancel()
        speakPulse = null
        coachSpeakPopup.animate().cancel()
        coachSpeakPopup.visibility = View.GONE
        coachSpeakPopup.alpha = 1f
        coachSpeakPopup.scaleX = 1f
        coachSpeakPopup.scaleY = 1f
    }

    private fun startSpeakPulse() {
        if (coachSpeakPopup.visibility != View.VISIBLE) {
            return
        }
        speakPulse?.cancel()
        if (!ValueAnimator.areAnimatorsEnabled()) {
            return
        }
        speakPulse = ObjectAnimator.ofPropertyValuesHolder(
            coachSpeakPopup,
            PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 1.03f),
            PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 1.03f),
        ).apply {
            duration = 700
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
    }

    private fun showCoachSheet() {
        if (coachSheet.visibility == View.VISIBLE) {
            return
        }
        coachSheet.visibility = View.VISIBLE
        if (!ValueAnimator.areAnimatorsEnabled()) {
            coachSheet.scaleX = 1f
            coachSheet.scaleY = 1f
            return
        }
        coachSheet.scaleX = 0.72f
        coachSheet.scaleY = 0.72f
        coachSheet.animate().scaleX(1f).scaleY(1f).setDuration(180).start()
    }

    private fun refreshLocationWarning() {
        val fine = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED
        val manager = getSystemService(LocationManager::class.java)
        val enabled = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        locationWarning.visibility = if (fine && enabled) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    private fun askForPermissions() {
        val required = mutableListOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            required += Manifest.permission.POST_NOTIFICATIONS
        }
        val needed = required.filter {
            ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }
        if (needed.isNotEmpty()) {
            permissions.launch(needed.toTypedArray())
        }
    }

    private fun send(action: String, question: String? = null) {
        val intent = Intent(this, CoachService::class.java).setAction(action)
        if (question != null) {
            intent.putExtra(CoachService.EXTRA_QUESTION, question)
        }
        ContextCompat.startForegroundService(this, intent)
    }
}
