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
            // CampusTelemetryUpload is a Kotlin object, so runOnce belongs to its
            // singleton. Invoking it with a null receiver throws NullPointerException,
            // which is not a ReflectiveOperationException and so escaped this block.
            val singleton = target.getField("INSTANCE").get(null)
            target.getDeclaredMethod("runOnce", Context::class.java).invoke(singleton, context)
        } catch (_: Throwable) {
            // Debug source not on the classpath, or the upload failed. Either way this
            // is an optional extra for the team's own phones: it must never be the
            // reason a runner's app stops.
        }
    }
}