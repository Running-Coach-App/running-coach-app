package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * The rules that decide what counts as distance covered. Issue #251 found a phone
 * lying still on a desk recording 516 m in four and a half minutes and speaking a
 * pace of 1:38 per kilometre; every case below is one of the steps that produced
 * that, or one of the real steps the filtering must not throw away.
 */
class DistanceFilterTest {
    private fun fix(atMillis: Long, accuracy: Float?, speed: Float?) =
        Fix(atMillis = atMillis, accuracyMetres = accuracy, speedMps = speed)

    @Test
    fun aFixIsMeasuredWithOnlyWhenItSaysHowAccurateItIs() {
        assertTrue(DistanceFilter.usable(fix(0, 8f, 2.5f)))
        assertTrue("the threshold itself is usable", DistanceFilter.usable(fix(0, 20f, 2.5f)))
        assertFalse("worse than the threshold", DistanceFilter.usable(fix(0, 20.1f, 2.5f)))
        assertFalse("an indoor fix", DistanceFilter.usable(fix(0, 48f, 0f)))
        assertFalse("no accuracy at all bounds no error", DistanceFilter.usable(fix(0, null, 2.5f)))
    }

    @Test
    fun aStillPhoneCoversNoDistanceHoweverFarItsCoordinatesWander() {
        // The desk case: good-looking fixes a second apart, wandering 12 m each time,
        // with the provider's own speed saying the phone is not moving.
        val previous = fix(0, 12f, 0.0f)
        val next = fix(1_000, 12f, 0.0f)
        assertFalse(DistanceFilter.stepCounts(previous, next, 12.0))
        assertFalse(DistanceFilter.stepCounts(previous, next, 3.0))
        assertFalse("just under a slow walk", DistanceFilter.stepCounts(previous, fix(1_000, 12f, 0.4f), 12.0))
    }

    @Test
    fun realRunningStillCounts() {
        // A 5:00 per kilometre runner covers 3.3 m a second, on a fix no better than
        // many city fixes. Rejecting this would be the filtering throwing real
        // distance away, which is the failure the other direction.
        val previous = fix(0, 15f, 3.3f)
        val next = fix(1_000, 15f, 3.3f)
        assertTrue(DistanceFilter.stepCounts(previous, next, 3.3))
        assertTrue("a sprint finish", DistanceFilter.stepCounts(previous, fix(1_000, 15f, 9.0f), 9.0))
        assertTrue(
            "a fix that reports no speed is judged on its step alone",
            DistanceFilter.stepCounts(fix(0, 10f, null), fix(1_000, 10f, null), 3.3),
        )
    }

    @Test
    fun aFixThatJumpsIsNotAPersonRunning() {
        val previous = fix(0, 10f, 14f)
        assertFalse("300 m in a second", DistanceFilter.stepCounts(previous, fix(1_000, 10f, 14f), 300.0))
        assertFalse("13 m/s is past a sprinter", DistanceFilter.stepCounts(previous, fix(1_000, 10f, 14f), 13.0))
        assertTrue("12 m/s is not", DistanceFilter.stepCounts(previous, fix(1_000, 10f, 14f), 12.0))
        assertFalse(
            "two fixes with the same timestamp imply no speed at all",
            DistanceFilter.stepCounts(previous, fix(0, 10f, 14f), 5.0),
        )
    }

    @Test
    fun aStepUnderAMetreIsNoise() {
        val previous = fix(0, 5f, 2.0f)
        assertFalse(DistanceFilter.stepCounts(previous, fix(1_000, 5f, 2.0f), 0.4))
        assertTrue(DistanceFilter.stepCounts(previous, fix(1_000, 5f, 2.0f), 1.0))
    }

    @Test
    fun aPaceNoRunnerCouldHoldIsNotPlausible() {
        // 516 m over the whole 270 s is 1.9 m/s and plausible: the inflation is not
        // visible in the total. At 33 s the lock screen read 0.3 km, which is 9.1 m/s
        // and is not, and the 1:38 per kilometre it spoke needs 337 m, which is 10.2.
        assertTrue(DistanceFilter.paceIsPlausible(270_000, 516.0))
        assertFalse(DistanceFilter.paceIsPlausible(33_000, 300.0))
        assertFalse(DistanceFilter.paceIsPlausible(33_000, 337.0))
        assertTrue("a 5:00 per kilometre runner", DistanceFilter.paceIsPlausible(300_000, 1_000.0))
        assertTrue("the fastest plausible average", DistanceFilter.paceIsPlausible(1_000, 8.0))
        assertFalse("faster than any record", DistanceFilter.paceIsPlausible(1_000, 8.1))
        assertFalse("no distance", DistanceFilter.paceIsPlausible(60_000, null))
        assertFalse("no distance covered", DistanceFilter.paceIsPlausible(60_000, 0.0))
        assertFalse("no time", DistanceFilter.paceIsPlausible(0, 100.0))
    }

    @Test
    fun theThresholdsAreTheOnesADRSevenStates() {
        assertEquals(20.0f, DistanceFilter.ACCURACY_LIMIT_METRES, 0.0f)
        assertEquals(0.5f, DistanceFilter.MOVING_SPEED_MPS, 0.0f)
        assertEquals(12.5, DistanceFilter.STEP_SPEED_LIMIT_MPS, 0.0)
        assertEquals(8.0, DistanceFilter.AVERAGE_SPEED_LIMIT_MPS, 0.0)
        assertEquals(1.0, DistanceFilter.NOISE_FLOOR_METRES, 0.0)
    }
}
