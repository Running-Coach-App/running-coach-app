package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SessionEngineTest {
    @Test
    fun startAndStopAreSpoken() {
        val session = SessionEngine()
        assertEquals("Session started.", session.start(SessionKind.INTERVAL))
        assertTrue(session.running)
        assertEquals("Session stopped.", session.stop())
        assertFalse(session.running)
    }

    @Test
    fun aSteadySessionIsStartedAndStoppedTheSameWay() {
        val session = SessionEngine()
        assertEquals("Session started.", session.start(SessionKind.STEADY))
        assertEquals(SessionKind.STEADY, session.kind)
        assertEquals("Session stopped.", session.stop())
    }
}
