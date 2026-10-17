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
        assertEquals("Session stopped.", session.stop())
        assertFalse(session.running)
        assertTrue(session.onTick(2_000, 100.0).isEmpty())
    }

    @Test
    fun aSteadySessionIsStartedAndStoppedTheSameWay() {
        val session = SessionEngine()
        assertEquals("Session started.", session.start(SessionKind.STEADY))
        assertEquals(SessionKind.STEADY, session.kind)
        assertEquals("Session stopped.", session.stop())
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
    fun statsRepeatEveryMinuteAfterTheFirst() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        assertEquals(1, session.onTick(15_000, null).size)
        assertTrue(session.onTick(74_000, null).isEmpty())
        assertEquals(1, session.onTick(75_000, null).size)
    }
}
