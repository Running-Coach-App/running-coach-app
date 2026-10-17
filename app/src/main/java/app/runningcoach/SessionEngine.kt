package app.runningcoach

enum class SessionKind {
    INTERVAL,
    STEADY,
}

/**
 * The spoken coach, with no Android types, so the acceptance criteria can be
 * checked from a unit test.
 */
class SessionEngine {
    var running: Boolean = false
        private set

    var kind: SessionKind = SessionKind.INTERVAL
        private set

    var elapsedMillis: Long = 0
        private set

    var distanceMeters: Double? = null
        private set

    private var nextStatsAtMillis: Long = FIRST_STATS_AT_MILLIS

    fun start(kind: SessionKind): String {
        running = true
        this.kind = kind
        elapsedMillis = 0
        distanceMeters = null
        nextStatsAtMillis = FIRST_STATS_AT_MILLIS
        return "Session started."
    }

    fun stop(): String {
        running = false
        return "Session stopped."
    }

    fun onTick(elapsedMillis: Long, distanceMeters: Double?): List<String> {
        if (!running) {
            return emptyList()
        }
        this.elapsedMillis = elapsedMillis
        this.distanceMeters = distanceMeters
        val lines = mutableListOf<String>()
        if (elapsedMillis >= nextStatsAtMillis) {
            lines += statsPhrase()
            nextStatsAtMillis += STATS_EVERY_MILLIS
        }
        return lines
    }

    fun statsPhrase(): String {
        return speakTime(elapsedMillis) + " " + speakPace(elapsedMillis, distanceMeters) + " " + speakDistance(distanceMeters)
    }

    companion object {
        const val FIRST_STATS_AT_MILLIS: Long = 15_000
        const val STATS_EVERY_MILLIS: Long = 60_000

        fun speakTime(elapsedMillis: Long): String {
            val totalSeconds = elapsedMillis / 1000
            val minutes = totalSeconds / 60
            val seconds = totalSeconds % 60
            return "Time $minutes ${unit(minutes, "minute", "minutes")} $seconds ${unit(seconds, "second", "seconds")}."
        }

        fun speakDistance(distanceMeters: Double?): String {
            if (distanceMeters == null || distanceMeters <= 0.0) {
                return "Distance is not available yet."
            }
            val kilometres = distanceMeters / 1000.0
            return "Distance ${formatTenths(kilometres)} kilometres."
        }

        fun speakPace(elapsedMillis: Long, distanceMeters: Double?): String {
            if (distanceMeters == null || distanceMeters <= 0.0 || elapsedMillis <= 0) {
                return "Pace is not available yet."
            }
            val secondsPerKm = (elapsedMillis / 1000.0) / (distanceMeters / 1000.0)
            val whole = secondsPerKm.toLong()
            val minutes = whole / 60
            val seconds = whole % 60
            return "Pace $minutes ${unit(minutes, "minute", "minutes")} $seconds ${unit(seconds, "second", "seconds")} per kilometre."
        }

        private fun unit(count: Long, singular: String, plural: String): String {
            return if (count == 1L) singular else plural
        }

        private fun formatTenths(value: Double): String {
            val tenths = (value * 10).toLong()
            val whole = tenths / 10
            val fraction = tenths % 10
            return "$whole.$fraction"
        }
    }
}
