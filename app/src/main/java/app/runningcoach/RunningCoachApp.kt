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
            // Recording a crash must never replace reporting it, and whether a runner
            // keeps usage data must never decide whether a crash is fatal. Both were
            // true before: a throw inside this block skipped the handler below it, and
            // that accident was the only thing keeping the app alive.
            try {
                if (SessionHistory(this).telemetryEnabled) {
                    DiagnosticLog.recordUncaught(this, thread, error)
                    TelemetryUpload.runOnce(this)
                }
            } catch (_: Throwable) {
                // Nothing to do with it: the handler below is what matters.
            }
            previous?.uncaughtException(thread, error)
        }
    }
}