package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SessionEngineTest {
    @Test
    fun startAndStopAreSpokenAndTheSessionGoesQuiet() {
        val session = SessionEngine()
        assertEquals("Session started.", session.start(SessionKind.INTERVAL))
        assertTrue(session.running)
        val during = session.onTick(1_000, null)
        assertTrue(during.any { it == "Jog." })
        assertEquals("Session stopped.", session.stop())
        assertFalse(session.running)
        assertTrue(session.onTick(2_000, 100.0).isEmpty())
    }

    @Test
    fun statsAreSpokenWithinThreeMinutesAndMissingDistanceIsNotInvented() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        val early = session.onTick(14_000, null)
        assertTrue(early.none { it.startsWith("Time") })
        val atFifteen = session.onTick(15_000, null)
        val stats = atFifteen.single { it.startsWith("Time") }
        assertTrue(stats.contains("Time 0 minutes 15 seconds."))
        assertTrue(stats.contains("Distance is not available yet."))
        assertTrue(stats.contains("Pace is not available yet."))
        assertFalse(stats.contains("0.0 kilometres"))
    }

    @Test
    fun aRealDistanceIsSpokenAsPaceAndDistance() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        val stats = session.onTick(60_000, 1000.0).single { it.startsWith("Time") }
        assertTrue(stats.contains("Time 1 minute 0 seconds."))
        assertTrue(stats.contains("Pace 1 minute 0 seconds per kilometre."))
        assertTrue(stats.contains("Distance 1.0 kilometres."))
    }

    @Test
    fun intervalSessionSpeaksEffortChangesAndSteadyDoesNot() {
        val interval = SessionEngine()
        interval.start(SessionKind.INTERVAL)
        assertEquals(listOf("Jog."), interval.onTick(0, null))
        assertTrue(interval.onTick(59_000, null).none { it == "Hard." || it == "Easier." || it == "Jog." })
        assertTrue(interval.onTick(60_000, null).contains("Hard."))
        assertTrue(interval.onTick(120_000, null).contains("Easier."))

        val steady = SessionEngine()
        steady.start(SessionKind.STEADY)
        val lines = steady.onTick(0, null) + steady.onTick(60_000, null) + steady.onTick(120_000, null)
        assertTrue(lines.none { it == "Hard." || it == "Easier." || it == "Jog." })
    }

    @Test
    fun aSpokenTimeQuestionReturnsElapsedTimeAndNothingElseIsInvented() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        session.onTick(90_000, 500.0)
        assertEquals("Time 1 minute 30 seconds.", session.answer("How long have I been running?"))
        assertEquals("That is not a stat of this run.", session.answer("What is my heart rate?"))
        session.stop()
        assertEquals("There is no session.", session.answer("How long have I been running?"))
    }
}
