package app.runningcoach

import android.content.Context

/** Debug builds may upload when usage data is on and a campus URL was baked in at build time. */
object TelemetryUpload {
    fun runOnce(context: Context) {
        if (!BuildConfig.DEBUG) {
            return
        }
        try {
            val target = Class.forName("app.runningcoach.CampusTelemetryUpload")
            target.getDeclaredMethod("runOnce", Context::class.java).invoke(null, context)
        } catch (_: ReflectiveOperationException) {
            // Debug source not on the classpath.
        }
    }
}