package app.runningcoach

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class RunRecord(
    val atMillis: Long,
    val kind: SessionKind,
    val elapsedMillis: Long,
    val distanceMeters: Double?,
    val summary: String,
) {
    fun stamp(): String {
        return SimpleDateFormat("d MMM HH:mm", Locale.ENGLISH).format(Date(atMillis))
    }
}
