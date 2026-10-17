package app.runningcoach

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val permissions = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions(),
    ) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        askForPermissions()

        findViewById<Button>(R.id.startInterval).setOnClickListener {
            send(CoachService.ACTION_START_INTERVAL)
        }
        findViewById<Button>(R.id.startSteady).setOnClickListener {
            send(CoachService.ACTION_START_STEADY)
        }
        findViewById<Button>(R.id.stopSession).setOnClickListener {
            send(CoachService.ACTION_STOP)
        }
        findViewById<TextView>(R.id.pocketNote).text = getString(R.string.pocket_note)
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

    private fun askForPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            permissions.launch(arrayOf(Manifest.permission.POST_NOTIFICATIONS))
        }
    }

    private fun send(action: String) {
        val intent = Intent(this, CoachService::class.java).setAction(action)
        ContextCompat.startForegroundService(this, intent)
    }
}
