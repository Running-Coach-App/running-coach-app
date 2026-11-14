package app.runningcoach

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DiagnosticLogTest {
    @Test
    fun aCrashRecordNamesTheFailureWithoutPersonalContent() {
        val record = DiagnosticLog.buildRecord("main", IllegalStateException("engine not ready"))
        assertTrue(record.contains("\"kind\":\"uncaught_exception\""))
        assertTrue(record.contains("\"exception\":\"java.lang.IllegalStateException\""))
        assertFalse(record.contains("display_name"))
        assertFalse(record.contains("latitude"))
        assertFalse(record.contains("question"))
    }
}