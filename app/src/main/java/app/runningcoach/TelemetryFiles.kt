package app.runningcoach

import java.io.File

/**
 * Writes each record as one line of JSON to a file in the app's private storage.
 *
 * Nothing is sent anywhere: the product holds no INTERNET permission, and DEC-028
 * keeps a runner's data on the device, to be exported as a file when they choose.
 *
 * A failure to write is swallowed. Recording what the coach did must never be the
 * reason a run stops.
 */
class FileTelemetrySink(
    directory: File,
    private val maxEventLines: Int = MAX_EVENT_LINES,
) : TelemetrySink {
    private val events = File(directory, EVENTS_FILE)
    private var linesWritten = 0

    override fun event(name: String, occurredAt: Long, sessionId: String, source: Source, fields: Map<String, Any?>) {
        append(Json.event(name, occurredAt, sessionId, source, fields))
    }

    override fun line(occurredAt: Long, sessionId: String, source: Source, lineId: String, kind: LineKind, outcome: LineOutcome, latencyMillis: Long) {
        append(Json.line(occurredAt, sessionId, source, lineId, kind, outcome, latencyMillis))
    }

    private fun append(record: String) {
        try {
            events.appendText(record + "\n")
            linesWritten++
            if (linesWritten >= TRIM_EVERY) {
                linesWritten = 0
                trim()
            }
        } catch (error: Exception) {
            // Recording is best effort. A run is not interrupted because a write failed.
        }
    }

    /** Keeps the newest records and drops the oldest, so the file cannot grow without end. */
    private fun trim() {
        try {
            if (!events.exists()) {
                return
            }
            val kept = events.readLines()
            if (kept.size <= maxEventLines) {
                return
            }
            events.writeText(kept.takeLast(maxEventLines).joinToString("\n", postfix = "\n"))
        } catch (error: Exception) {
            // As above: a failed trim is not a reason to stop a session.
        }
    }

    private companion object {
        const val EVENTS_FILE = "events.jsonl"

        /** Covers the longest window docs/analytics.md defines, at ten events a session. */
        const val MAX_EVENT_LINES = 5_000
        const val TRIM_EVERY = 200
    }
}
