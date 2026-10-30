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
    fun afterStopTheCoachSpeaksDistanceAndTimeOnce() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        session.onTick(120_000, 500.0)
        assertEquals("Session stopped.", session.stop())
        assertEquals(
            "Distance 0.5 kilometres. Time 2 minutes 0 seconds.",
            session.summaryPhrase(),
        )
    }

    @Test
    fun afterStopWithNoDistanceTheSummarySaysSo() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        session.onTick(60_000, null)
        session.stop()
        assertEquals(
            "You covered no distance. Time 1 minute 0 seconds.",
            session.summaryPhrase(),
        )
    }

    @Test
    fun lastLinesHoldAtMostTwoNewestLastAndStartClearsThem() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        assertTrue(session.lastLines.isEmpty())
        session.remember("Session started.")
        session.onTick(0, null).forEach { session.remember(it) }
        assertEquals(listOf("Session started.", "Jog."), session.lastLines)
        session.remember("Hard.")
        assertEquals(listOf("Jog.", "Hard."), session.lastLines)
        session.start(SessionKind.STEADY)
        assertTrue(session.lastLines.isEmpty())
    }

    @Test
    fun afterStopTheScreenLinesAreTheStopAndTheSummary() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        session.onTick(120_000, 500.0)
        val stopped = session.stop()
        val summary = session.summaryPhrase()
        session.remember(stopped)
        session.remember(summary)
        assertEquals(listOf(stopped, summary), session.lastLines)
    }

    @Test
    fun aRunShorterThanAMinuteIsNotKept() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        session.onTick(59_000, 100.0)
        assertFalse(session.shouldKeepRecord())
        session.onTick(60_000, 100.0)
        assertTrue(session.shouldKeepRecord())
    }

    @Test
    fun displayCompanionsCoverIdleAndKnownValues() {
        assertEquals("0:00", SessionEngine.displayTime(0))
        assertEquals("—", SessionEngine.displayPace(0, null))
        assertEquals("—", SessionEngine.displayDistance(null))
        assertEquals("1:30", SessionEngine.displayTime(90_000))
        assertEquals("3:00 /km", SessionEngine.displayPace(90_000, 500.0))
        assertEquals("0.5 km", SessionEngine.displayDistance(500.0))
    }

    @Test
    fun statsForDisplayAreCompactClockPaceAndDistance() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        assertEquals(listOf("0:00", "—", "—"), session.statsForDisplay())
        session.onTick(90_000, 500.0)
        assertEquals(listOf("1:30", "3:00 /km", "0.5 km"), session.statsForDisplay())
    }

    @Test
    fun howAmIDoingReturnsTimePaceAndDistance() {
        val session = SessionEngine()
        session.start(SessionKind.STEADY)
        session.onTick(90_000, 500.0)
        val reply = session.answer("How am I doing?")
        assertTrue(reply.contains("Time 1 minute 30 seconds."))
        assertTrue(reply.contains("Pace"))
        assertTrue(reply.contains("Distance"))
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
    fun anOffTopicQuestionOnAKnownThemeGetsThatThemesReply() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        session.onTick(90_000, 500.0)

        assertEquals(
            "Can we not think about food now and focus on the run?",
            session.answer("Have I eaten today?"),
        )
        assertEquals(
            "The weather can wait. You are the one moving, not the sky.",
            session.answer("Is it going to rain?"),
        )
        assertEquals(
            "You can rest later. Right now, one more step.",
            session.answer("Why am I so tired?"),
        )
    }

    @Test
    fun anUnrecognisedOffTopicQuestionTakesTheRepliesInTurnAndRepeatsNothing() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        session.onTick(90_000, 500.0)

        val replies = listOf(
            session.answer("What is my heart rate?"),
            session.answer("Who won the match?"),
            session.answer("Where are we?"),
        )
        assertEquals(SessionEngine.OFF_TOPIC_REPLIES, replies)
        assertEquals(replies.toSet().size, replies.size)

        assertEquals(SessionEngine.OFF_TOPIC_REPLIES.first(), session.answer("Who won the match?"))
    }

    @Test
    fun anOffTopicReplyInventsNoStatAndTheRunKeepsAnswering() {
        val session = SessionEngine()
        session.start(SessionKind.INTERVAL)
        session.onTick(90_000, 500.0)

        val everyReply = SessionEngine.OFF_TOPIC_THEMES.map { it.second } + SessionEngine.OFF_TOPIC_REPLIES
        for (reply in everyReply) {
            assertFalse(reply.any { it.isDigit() })
            assertFalse(reply.contains("kilometre"))
        }

        session.answer("Have I eaten today?")
        assertEquals("Time 1 minute 30 seconds.", session.answer("How long have I been running?"))
    }
}
