package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/** Collects what the engine emits, so the records can be read back in a test. */
private class Recorder : TelemetrySink {
    data class Event(val name: String, val occurredAt: Long, val sessionId: String, val source: Source, val fields: Map<String, Any?>)

    val events = mutableListOf<Event>()
    val lines = mutableListOf<String>()

    override fun event(name: String, occurredAt: Long, sessionId: String, source: Source, fields: Map<String, Any?>) {
        events += Event(name, occurredAt, sessionId, source, fields)
    }

    override fun line(occurredAt: Long, sessionId: String, source: Source, lineId: String, kind: LineKind, outcome: LineOutcome, latencyMillis: Long) {
        lines += Json.line(occurredAt, sessionId, source, lineId, kind, outcome, latencyMillis)
    }

    fun names(): List<String> = events.map { it.name }
}

class TelemetryTest {
    private fun engineWith(recorder: Recorder, ids: MutableList<String> = mutableListOf("s-1", "s-2")): SessionEngine {
        var tick = 0L
        return SessionEngine(sink = recorder, clock = { tick += 1_000; tick }, newSessionId = { ids.removeAt(0) })
    }

    @Test
    fun aWholeSessionRecordsEachStepOfTheCoreTaskInOrder() {
        val recorder = Recorder()
        val session = engineWith(recorder)
        session.start(SessionKind.INTERVAL)
        session.onTick(1_000, null)
        session.onTick(180_000, 400.0)
        session.answer("how far have I gone")
        session.stop()
        session.recordSummarySpoken()

        assertEquals(
            listOf(
                Events.SESSION_STARTED,
                Events.EFFORT_CUE_SPOKEN,
                Events.STATS_SPOKEN,
                Events.QUESTION_ASKED,
                Events.QUESTION_ANSWERED,
                Events.SESSION_STOPPED,
                Events.SESSION_SUMMARY_SPOKEN,
            ),
            recorder.names(),
        )
    }

    @Test
    fun everyRecordCarriesTheSessionTheSourceAndTheMomentItHappened() {
        val recorder = Recorder()
        val session = engineWith(recorder)
        session.start(SessionKind.STEADY)
        session.onTick(180_000, 100.0)
        session.stop()

        assertTrue(recorder.events.isNotEmpty())
        recorder.events.forEach {
            assertEquals("s-1", it.sessionId)
            assertEquals(Source.APP, it.source)
            assertTrue(it.occurredAt > 0)
        }
    }

    @Test
    fun eachSessionGetsItsOwnIdentifier() {
        val recorder = Recorder()
        val session = engineWith(recorder)
        session.start(SessionKind.STEADY)
        val first = session.sessionId
        session.stop()
        session.start(SessionKind.STEADY)
        assertNotEquals(first, session.sessionId)
    }

    @Test
    fun aRealSessionIdentifierIsRandomRatherThanCounted() {
        val one = SessionEngine()
        val two = SessionEngine()
        one.start(SessionKind.STEADY)
        two.start(SessionKind.STEADY)
        assertNotEquals(one.sessionId, two.sessionId)
        assertTrue(one.sessionId.length >= 32)
    }

    @Test
    fun aQuestionRecordsItsTopicAndNeverItsWords() {
        val recorder = Recorder()
        val session = engineWith(recorder)
        session.start(SessionKind.STEADY)
        session.answer("Ola what is my pace right now")

        val asked = recorder.events.single { it.name == Events.QUESTION_ASKED }
        assertEquals("pace", asked.fields["topic"])
        val everything = recorder.events.joinToString { it.fields.toString() }
        assertFalse(everything.contains("Ola"))
        assertFalse(everything.contains("right now"))
    }

    @Test
    fun anOffTopicQuestionRecordsThatItWasNotAnswered() {
        val recorder = Recorder()
        val session = engineWith(recorder)
        session.start(SessionKind.STEADY)
        session.answer("what is for dinner")

        val answered = recorder.events.single { it.name == Events.QUESTION_ANSWERED }
        assertEquals("off_topic", answered.fields["topic"])
        assertEquals(false, answered.fields["answered"])
    }

    @Test
    fun aStoppedSessionRecordsHowLongItRanAndHowFarItWent() {
        val recorder = Recorder()
        val session = engineWith(recorder)
        session.start(SessionKind.STEADY)
        session.onTick(65_000, 250.0)
        session.stop()

        val stopped = recorder.events.single { it.name == Events.SESSION_STOPPED }
        assertEquals(65L, stopped.fields["duration_s"])
        assertEquals(250, stopped.fields["distance_m"])
        assertEquals("runner", stopped.fields["reason"])
    }

    @Test
    fun anEventIsOneLineOfJsonWithItsHeadFieldsFirst() {
        val json = Json.event("session_started", 1_700, "s-1", Source.APP, mapOf("kind" to "interval"))
        assertEquals(
            """{"event":"session_started","occurred_at":1700,"session_id":"s-1","source":"app","kind":"interval"}""",
            json,
        )
        assertFalse(json.contains("\n"))
    }

    @Test
    fun aLineRecordCarriesTheLineItsKindItsOutcomeAndItsDelay() {
        val json = Json.line(1_700, "s-1", Source.SMOKE, "l-9", LineKind.STATS, LineOutcome.DROPPED_BUSY, 2_400)
        assertEquals(
            """{"occurred_at":1700,"session_id":"s-1","source":"smoke","line_id":"l-9","line_kind":"stats","outcome":"dropped_busy","latency_ms":2400}""",
            json,
        )
    }

    @Test
    fun aValueThatCouldBreakTheLineIsEscaped() {
        val json = Json.event("x", 1, "s-1", Source.APP, mapOf("odd" to "a\"b\\c\nd"))
        assertTrue(json.contains("""a\"b\\c\nd"""))
        assertFalse(json.trimEnd().contains("\n"))
    }

    @Test
    fun recordingIsOffByDefaultSoTelemetryIsNeverAReasonToFail() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        session.onTick(180_000, 100.0)
        session.answer("how far")
        assertEquals("Session stopped.", session.stop())
    }
}
