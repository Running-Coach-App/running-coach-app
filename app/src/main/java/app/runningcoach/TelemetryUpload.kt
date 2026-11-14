package app.runningcoach

import android.content.Context
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

/**
 * Sends new JSON Lines to the campus collector when usage data is on and [BuildConfig.COLLECTOR_URL] is set.
 */
object TelemetryUpload {
    private const val PREFS = "telemetry_upload"

    fun runOnce(context: Context) {
        if (!SessionHistory(context).telemetryEnabled) {
            return
        }
        val base = BuildConfig.COLLECTOR_URL.trim()
        if (base.isEmpty()) {
            return
        }
        val directory = context.filesDir
        uploadKind(context, base, File(directory, FileTelemetrySink.EVENTS_FILE), "events")
        uploadKind(context, base, File(directory, "diagnostics.jsonl"), "diagnostics")
    }

    private fun uploadKind(context: Context, baseUrl: String, file: File, kind: String) {
        if (!file.exists()) {
            return
        }
        val lines = file.readLines()
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val key = "offset_$kind"
        val offset = prefs.getInt(key, 0)
        if (offset >= lines.size) {
            return
        }
        val body = lines.subList(offset, lines.size).joinToString(separator = "\n", postfix = "\n")
        if (body.isBlank()) {
            return
        }
        try {
            val target = URL("${baseUrl.trimEnd('/')}/ingest?kind=$kind")
            val connection = target.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.doOutput = true
            connection.connectTimeout = 10_000
            connection.readTimeout = 30_000
            connection.setRequestProperty("Content-Type", "application/x-ndjson")
            connection.outputStream.use { stream ->
                stream.write(body.toByteArray(Charsets.UTF_8))
            }
            if (connection.responseCode in 200..299 || connection.responseCode == 204) {
                prefs.edit().putInt(key, lines.size).apply()
            }
        } catch (_: Exception) {
            // Best effort only.
        }
    }
}