package app.runningcoach

/**
 * What the product records about itself, with no Android types, so the engine's
 * emissions can be checked from a unit test.
 *
 * The events are the ones `docs/analytics.md` registers; the line records are the
 * ones FR-014 specifies. Nothing here sends anything anywhere: a sink decides
 * where a record goes, and the only sink that writes is the file one in
 * CoachService. Optional campus upload is gated on DEC-030 and DEC-031.
 */

/** What the traffic is. Every metric excludes SMOKE and USABILITY_TEST. */
enum class Source(val wire: String) {
    APP("app"),
    USABILITY_TEST("usability-test"),
    SMOKE("smoke"),
}

/** Which kind of line fell due, the route of a spoken line. */
enum class LineKind(val wire: String) {
    STATS("stats"),
    EFFORT("effort"),
    ANSWER("answer"),
}

/** How a line that fell due ended. */
enum class LineOutcome(val wire: String) {
    SPOKEN("spoken"),
    DROPPED_BUSY("dropped_busy"),
    DROPPED_UNAVAILABLE("dropped_unavailable"),
}

/** What a spoken question was about. Never the words the runner used. */
enum class QuestionTopic(val wire: String) {
    TIME("time"),
    PACE("pace"),
    DISTANCE("distance"),
    OFF_TOPIC("off_topic"),
}

object Events {
    const val SESSION_STARTED = "session_started"
    const val STATS_SPOKEN = "stats_spoken"
    const val EFFORT_CUE_SPOKEN = "effort_cue_spoken"
    const val SPOKEN_LINE_DROPPED = "spoken_line_dropped"
    const val QUESTION_ASKED = "question_asked"
    const val QUESTION_ANSWERED = "question_answered"
    const val LOCATION_FIX_LOST = "location_fix_lost"
    const val LOCATION_FIX_REGAINED = "location_fix_regained"
    const val SESSION_STOPPED = "session_stopped"
    const val SESSION_SUMMARY_SPOKEN = "session_summary_spoken"
}

/**
 * Where a record goes. The engine and the service emit through this, so neither
 * knows about files, and a test can collect records in a list instead.
 */
interface TelemetrySink {
    fun event(name: String, occurredAt: Long, sessionId: String, source: Source, fields: Map<String, Any?>)

    fun line(occurredAt: Long, sessionId: String, source: Source, lineId: String, kind: LineKind, outcome: LineOutcome, latencyMillis: Long)
}

/**
 * Stands in until the service has a directory to write to, so the engine can be
 * built before the sink exists and never has to be rebuilt.
 */
class DeferredSink : TelemetrySink {
    var delegate: TelemetrySink = NoTelemetry

    override fun event(name: String, occurredAt: Long, sessionId: String, source: Source, fields: Map<String, Any?>) =
        delegate.event(name, occurredAt, sessionId, source, fields)

    override fun line(occurredAt: Long, sessionId: String, source: Source, lineId: String, kind: LineKind, outcome: LineOutcome, latencyMillis: Long) =
        delegate.line(occurredAt, sessionId, source, lineId, kind, outcome, latencyMillis)
}

/** The default. Records nothing, so telemetry is never a reason for a crash. */
object NoTelemetry : TelemetrySink {
    override fun event(name: String, occurredAt: Long, sessionId: String, source: Source, fields: Map<String, Any?>) = Unit

    override fun line(occurredAt: Long, sessionId: String, source: Source, lineId: String, kind: LineKind, outcome: LineOutcome, latencyMillis: Long) = Unit
}

/**
 * One record as one line of JSON. Written by hand rather than with a library,
 * because the shape is fixed and a dependency here would be the only one the
 * product does not already need.
 */
object Json {
    fun event(name: String, occurredAt: Long, sessionId: String, source: Source, fields: Map<String, Any?>): String {
        val head = linkedMapOf<String, Any?>(
            "event" to name,
            "occurred_at" to occurredAt,
            "session_id" to sessionId,
            "source" to source.wire,
        )
        head.putAll(fields)
        return obj(head)
    }

    fun record(fields: Map<String, Any?>): String = obj(fields)

    fun line(occurredAt: Long, sessionId: String, source: Source, lineId: String, kind: LineKind, outcome: LineOutcome, latencyMillis: Long): String =
        obj(
            linkedMapOf(
                "occurred_at" to occurredAt,
                "session_id" to sessionId,
                "source" to source.wire,
                "line_id" to lineId,
                "line_kind" to kind.wire,
                "outcome" to outcome.wire,
                "latency_ms" to latencyMillis,
            ),
        )

    private fun obj(fields: Map<String, Any?>): String =
        fields.entries.joinToString(separator = ",", prefix = "{", postfix = "}") { (key, value) ->
            "${string(key)}:${value(value)}"
        }

    private fun value(value: Any?): String =
        when (value) {
            null -> "null"
            is Boolean -> value.toString()
            is Int, is Long -> value.toString()
            is Double -> if (value.isFinite()) value.toString() else "null"
            is List<*> -> value.joinToString(separator = ",", prefix = "[", postfix = "]") { element -> value(element) }
            else -> string(value.toString())
        }

    private fun string(text: String): String {
        val out = StringBuilder(text.length + 2)
        out.append('"')
        for (character in text) {
            when (character) {
                '"' -> out.append("\\\"")
                '\\' -> out.append("\\\\")
                '\n' -> out.append("\\n")
                '\r' -> out.append("\\r")
                '\t' -> out.append("\\t")
                else -> if (character < ' ') out.append("\\u%04x".format(character.code)) else out.append(character)
            }
        }
        out.append('"')
        return out.toString()
    }
}
