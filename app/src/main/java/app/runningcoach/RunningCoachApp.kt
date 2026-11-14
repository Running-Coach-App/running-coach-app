package app.runningcoach

import android.app.Application

class RunningCoachApp : Application() {
    override fun onCreate() {
        super.onCreate()
        installCrashHandler()
        Thread { TelemetryUpload.runOnce(this) }.start()
    }

    fun installCrashHandler() {
        val previous = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, error ->
            if (SessionHistory(this).telemetryEnabled) {
                DiagnosticLog.recordUncaught(this, thread, error)
                TelemetryUpload.runOnce(this)
            }
            previous?.uncaughtException(thread, error)
        }
    }
}