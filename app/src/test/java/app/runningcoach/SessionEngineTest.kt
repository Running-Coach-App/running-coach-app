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
    fun theFirstStatsLineComesOnTheThreeMinuteCadenceAndMissingStatsAreNotInvented() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        val early = session.onTick(179_000, null)
        assertTrue(early.none { it.startsWith("Time") })
        val atThreeMinutes = session.onTick(180_000, null)
        val stats = atThreeMinutes.single { it.startsWith("Time") }
        assertTrue(stats.contains("Time 3 minutes 0 seconds."))
        assertTrue(stats.contains("Pace is not available yet."))
        assertTrue(stats.contains("Distance is not available yet."))
        assertFalse(stats.contains("0.0 kilometres"))
    }

    @Test
    fun statsAreSpokenEveryThreeMinutes() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        val spoken = (1..9).map { minute ->
            session.onTick(minute * 60_000L, 1000.0).count { it.startsWith("Time") }
        }
        assertEquals(listOf(0, 0, 1, 0, 0, 1, 0, 0, 1), spoken)
    }

    @Test
    fun aRealDistanceIsSpokenAsPaceAndDistance() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        val stats = session.onTick(180_000, 1000.0).single { it.startsWith("Time") }
        assertTrue(stats.contains("Time 3 minutes 0 seconds."))
        assertTrue(stats.contains("Pace 3 minutes 0 seconds per kilometre."))
        assertTrue(stats.contains("Distance 1.0 kilometres."))
    }

    @Test
    fun aMissingStatIsNamedOnceAndThenLeftOutUntilItReturns() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)

        val first = session.onTick(180_000, null).single { it.startsWith("Time") }
        assertTrue(first.contains("Pace is not available yet."))
        assertTrue(first.contains("Distance is not available yet."))

        val second = session.onTick(360_000, null).single { it.startsWith("Time") }
        assertEquals("Time 6 minutes 0 seconds.", second)

        val third = session.onTick(540_000, null).single { it.startsWith("Time") }
        assertEquals("Time 9 minutes 0 seconds.", third)

        val whenTheFixReturns = session.onTick(720_000, 2000.0).single { it.startsWith("Time") }
        assertTrue(whenTheFixReturns.contains("Pace 6 minutes 0 seconds per kilometre."))
        assertTrue(whenTheFixReturns.contains("Distance 2.0 kilometres."))

        val whenItIsLostAgain = session.onTick(900_000, null).single { it.startsWith("Time") }
        assertTrue(whenItIsLostAgain.contains("Pace is not available yet."))
        assertTrue(whenItIsLostAgain.contains("Distance is not available yet."))

        val afterThat = session.onTick(1_080_000, null).single { it.startsWith("Time") }
        assertEquals("Time 18 minutes 0 seconds.", afterThat)
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
        session.stop()
        assertEquals("There is no session.", session.answer("How long have I been running?"))
    }

    @Test
    fun anOffTopicQuestionGetsTheFocusOnRunningReplyAndNoInventedStat() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        session.onTick(90_000, 500.0)

        val reply = session.answer("What is my heart rate?")
        assertEquals(SessionEngine.OFF_TOPIC_REPLY, reply)
        assertFalse(reply.contains("Time"))
        assertFalse(reply.contains("Pace"))
        assertFalse(reply.contains("Distance"))

        assertEquals("Time 1 minute 30 seconds.", session.answer("How long have I been running?"))
    }
}
