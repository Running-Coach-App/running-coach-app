package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The test for QR-06. Google's `Stability_ANR` criterion requires that the app
 * neither crashes nor blocks the UI thread, and Android vitals puts a published
 * threshold under it. No vitals figure exists for this product, because nobody
 * outside the team has installed it, so the coach's own decision loop is driven
 * instead: a whole session's worth of ticks, at the real cadence, with the
 * awkward inputs a run actually produces.
 *
 * The loop runs on the main thread inside CoachService, so an exception here is
 * a crash on a phone and slow work here is a frame the UI thread does not get.
 */
class StabilitySoakTest {
    private companion object {
        const val TICK_MILLIS = 1_000L
        const val SESSION_MILLIS = 60 * 60 * 1_000L

        /** Generous for 3,600 iterations; a real tick has one frame, about 16 ms. */
        const val BUDGET_MILLIS = 2_000L
    }

    @Test
    fun anHourLongSessionNeitherThrowsNorStopsSpeaking() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)

        var spokenLines = 0
        var elapsed = 0L
        while (elapsed < SESSION_MILLIS) {
            elapsed += TICK_MILLIS
            // A fix that comes and goes, as it does under bridges and buildings.
            val distance = when {
                elapsed % 600_000L < 90_000L -> null
                else -> elapsed / 300.0
            }
            spokenLines += session.onTick(elapsed, distance).size
        }

        assertTrue("an hour of coaching spoke nothing", spokenLines > 0)
        assertTrue(session.running)
        assertEquals("Session stopped.", session.stop())
        assertFalse(session.running)
    }

    @Test
    fun theDecisionLoopStaysWellInsideAFrameBudgetAcrossAWholeSession() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)

        val startedAt = System.nanoTime()
        var elapsed = 0L
        while (elapsed < SESSION_MILLIS) {
            elapsed += TICK_MILLIS
            session.onTick(elapsed, elapsed / 300.0)
        }
        val tookMillis = (System.nanoTime() - startedAt) / 1_000_000

        assertTrue(
            "a session's worth of ticks took ${tookMillis}ms, over the ${BUDGET_MILLIS}ms budget",
            tookMillis < BUDGET_MILLIS,
        )
    }

    @Test
    fun aSessionSurvivesTicksThatGoBackwardsRepeatOrJump() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)

        // A jammed or jumpy fix, which DEC-032 says to pass through rather than
        // correct, so the engine has to tolerate whatever the phone reports.
        val awkward = listOf(
            0L to 0.0,
            180_000L to 400.0,
            179_000L to 399.0,
            179_000L to 399.0,
            5_000_000L to 1_000_000.0,
            1_000L to 0.0,
            360_000L to null,
        )
        awkward.forEach { (at, distance) -> session.onTick(at, distance) }

        assertTrue(session.running)
        assertEquals("Session stopped.", session.stop())
    }

    @Test
    fun answeringRepeatedlyThroughoutASessionNeitherThrowsNorGrowsWithoutBound() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)

        repeat(500) { index ->
            session.onTick(index * 1_000L, index.toDouble())
            session.answer(
                when (index % 4) {
                    0 -> "how far have I gone"
                    1 -> "what is my pace"
                    2 -> "how long have I been running"
                    else -> "what is for dinner"
                },
            )
        }

        // lastLines is what the screen shows; it must not accumulate a session's
        // worth of speech, or the service holds every line a long run produced.
        assertTrue(
            "lastLines grew to ${session.lastLines.size}",
            session.lastLines.size <= 10,
        )
        assertEquals("Session stopped.", session.stop())
    }

    @Test
    fun aSessionCanBeStartedAndStoppedRepeatedlyWithoutLeavingStateBehind() {
        val session = SessionEngine()

        repeat(50) {
            session.start(SessionKind.INTERVAL)
            session.onTick(200_000L, 500.0)
            session.stop()
            assertFalse(session.running)
        }

        session.start(SessionKind.STEADY)
        assertEquals(0L, session.elapsedMillis)
        session.stop()
    }
}
