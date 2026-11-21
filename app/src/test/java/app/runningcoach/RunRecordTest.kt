package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RunRecordTest {
    @Test
    fun aFinishedRunCarriesItsDateDistanceAndElapsedTime() {
        val record = RunRecord(
            atMillis = 1_700_000_000_000L,
            kind = SessionKind.INTERVAL,
            elapsedMillis = 720_000,
            distanceMeters = 1_600.0,
            summary = "You covered 1.6 kilometres. Time 12 minutes 0 seconds.",
        )
        assertTrue(record.stamp().isNotBlank())
        assertEquals("12:00", SessionEngine.displayTime(record.elapsedMillis))
        assertEquals("1.6 km", SessionEngine.displayDistance(record.distanceMeters))
    }

    @Test
    fun aRunWithNoDistanceStillShowsItsTime() {
        val record = RunRecord(
            atMillis = 1_700_000_000_000L,
            kind = SessionKind.STEADY,
            elapsedMillis = 60_000,
            distanceMeters = null,
            summary = "You covered no distance. Time 1 minute 0 seconds.",
        )
        assertEquals("1:00", SessionEngine.displayTime(record.elapsedMillis))
        assertEquals("—", SessionEngine.displayDistance(record.distanceMeters))
    }
}
