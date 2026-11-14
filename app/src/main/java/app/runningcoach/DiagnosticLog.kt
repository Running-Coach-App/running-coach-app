package app.runningcoach

import android.content.Context
import android.os.Build
import java.io.File

/**
 * Crash and stability records without runner identity or spoken text. Written only when
 * usage data is on; uploaded with [TelemetryUpload] when a campus URL is configured.
 */
object DiagnosticLog {
    private const val FILE_NAME = "diagnostics.jsonl"
    private const val MAX_STACK = 15
    private const val MAX_MESSAGE = 200

    fun recordUncaught(context: Context, thread: Thread, error: Throwable) {
        if (!SessionHistory(context).telemetryEnabled) {
            return
        }
        append(context.filesDir, buildRecord(thread.name, error, context))
    }

    internal fun buildRecord(threadName: String, error: Throwable, context: Context? = null): String {
        val version = context?.packageManager
            ?.getPackageInfo(context.packageName, 0)
            ?.versionName
            .orEmpty()
        return Json.record(
            linkedMapOf(
                "occurred_at" to System.currentTimeMillis(),
                "source" to Source.APP.wire,
                "kind" to "uncaught_exception",
                "thread" to threadName,
                "exception" to error.javaClass.name,
                "message" to (error.message?.take(MAX_MESSAGE) ?: ""),
                "app_version" to version,
                "api_level" to Build.VERSION.SDK_INT,
                "stack" to error.stackTrace.take(MAX_STACK).map { frame ->
                    "${frame.className}.${frame.methodName}(${frame.fileName}:${frame.lineNumber})"
                },
            ),
        )
    }

    private fun append(directory: File, record: String) {
        try {
            File(directory, FILE_NAME).appendText(record + "\n")
        } catch (_: Exception) {
            // Must not affect stability after a crash.
        }
    }
}