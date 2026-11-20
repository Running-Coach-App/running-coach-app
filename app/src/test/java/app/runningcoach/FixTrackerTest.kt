package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The counting behind `location_fix_lost`, `location_fix_regained` and the
 * `fix_available_pct` metric. Issue #252 found every one of these wrong on a real
 * phone, because the service kept its fix state across sessions.
 */
class FixTrackerTest {
    @Test
    fun aSessionWithAFixFromItsFirstMomentsLosesNothing() {
        val fix = FixTracker()
        fix.startSession(1_000)
        assertNull(fix.onFix(1_200))
        var lost = false
        for (second in 1..60) {
            fix.onFix(1_200 + second * 1_000L)
            lost = lost || fix.noteStaleness(1_200 + second * 1_000L)
        }
        assertFalse("a fix every second is never stale", lost)
    }

    @Test
    fun theSpellStartsAtTheLastFixAndIsReportedOnceWhenTheFixReturns() {
        val fix = FixTracker()
        fix.startSession(0)
        fix.onFix(10_000)
        assertFalse(fix.noteStaleness(20_000))
        assertTrue("stale 15 s after the last fix", fix.noteStaleness(26_000))
        assertFalse("reported once, not on every tick", fix.noteStaleness(27_000))
        assertTrue(fix.lost)
        assertEquals("measured from the last fix, not from the tick that noticed", 30L, fix.onFix(40_000))
        assertFalse(fix.lost)
        assertNull("the spell is closed", fix.onFix(41_000))
    }

    @Test
    fun aNewSessionInheritsNothingFromThePreviousOne() {
        val fix = FixTracker()
        fix.startSession(0)
        fix.onFix(1_000)
        assertTrue(fix.noteStaleness(60_000))
        assertTrue(fix.lost)

        // Four minutes of the phone sitting idle between the two sessions.
        fix.startSession(300_000)
        assertFalse("a session starts with a clean fix state", fix.lost)
        assertFalse("the previous session's last fix is not this session's", fix.noteStaleness(300_500))
        assertNull("no spell is open to close", fix.onFix(301_000))
    }

    @Test
    fun lostSecondsNeverExceedTheSessionThatReportsThem() {
        // The two sessions from the phone's own file in issue #252: 28 s reporting
        // 120 s lost, and 81 s reporting 185 s.
        for (durationMillis in listOf(28_000L, 81_000L)) {
            val fix = FixTracker()
            val startedAt = 500_000L
            fix.startSession(startedAt)
            var reported = 0L
            for (elapsed in 0..durationMillis step 1_000L) {
                fix.noteStaleness(startedAt + elapsed)
            }
            reported += fix.onFix(startedAt + durationMillis) ?: 0L
            assertTrue(
                "lost_s $reported must fit inside a ${durationMillis / 1000} s session",
                reported <= durationMillis / 1000,
            )
        }
    }

    @Test
    fun nothingIsMeasuredBeforeASessionStarts() {
        val fix = FixTracker()
        assertFalse("no session, nothing to report", fix.noteStaleness(60_000))
        assertFalse(fix.lost)
        assertNull(fix.onFix(61_000))
    }

    @Test
    fun aSessionThatNeverGetsAFixSaysSoRatherThanSayingNothing() {
        val fix = FixTracker()
        fix.startSession(0)
        assertFalse(fix.noteStaleness(10_000))
        assertTrue("16 s into a session with no fix at all", fix.noteStaleness(16_000))
        assertEquals("measured from the session's own start", 20L, fix.onFix(20_000))
    }
}
