package app.runningcoach

enum class SessionKind {
    INTERVAL,
    STEADY,
}

enum class Effort {
    JOG,
    HARD,
    EASIER,
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

    private var lastSpokenEffort: Effort? = null
    private var nextStatsAtMillis: Long = FIRST_STATS_AT_MILLIS

    fun start(kind: SessionKind): String {
        running = true
        this.kind = kind
        elapsedMillis = 0
        distanceMeters = null
        lastSpokenEffort = null
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
        if (kind == SessionKind.INTERVAL) {
            val effort = effortAt(elapsedMillis)
            if (effort != lastSpokenEffort) {
                lines += effortPhrase(effort)
                lastSpokenEffort = effort
            }
        }
        if (elapsedMillis >= nextStatsAtMillis) {
            lines += statsPhrase()
            nextStatsAtMillis += STATS_EVERY_MILLIS
        }
        return lines
    }

    fun answer(question: String): String {
        if (!running) {
            return "There is no session."
        }
        val text = question.lowercase()
        val aboutTime = text.contains("time") || text.contains("long")
        val aboutPace = text.contains("pace") || text.contains("fast")
        val aboutDistance = text.contains("distance") || text.contains("far")
        if (!aboutTime && !aboutPace && !aboutDistance) {
            return "That is not a stat of this run."
        }
        val parts = mutableListOf<String>()
        if (aboutTime) {
            parts += speakTime(elapsedMillis)
        }
        if (aboutPace) {
            parts += speakPace(elapsedMillis, distanceMeters)
        }
        if (aboutDistance) {
            parts += speakDistance(distanceMeters)
        }
        return parts.joinToString(" ")
    }

    fun statsPhrase(): String {
        return speakTime(elapsedMillis) + " " + speakPace(elapsedMillis, distanceMeters) + " " + speakDistance(distanceMeters)
    }

    companion object {
        const val FIRST_STATS_AT_MILLIS: Long = 15_000
        const val STATS_EVERY_MILLIS: Long = 60_000
        private const val BLOCK_MILLIS: Long = 60_000
        private const val CYCLE_MILLIS: Long = 180_000

        fun effortAt(elapsedMillis: Long): Effort {
            val withinCycle = elapsedMillis % CYCLE_MILLIS
            return when {
                withinCycle < BLOCK_MILLIS -> Effort.JOG
                withinCycle < BLOCK_MILLIS * 2 -> Effort.HARD
                else -> Effort.EASIER
            }
        }

        fun effortPhrase(effort: Effort): String {
            return when (effort) {
                Effort.JOG -> "Jog."
                Effort.HARD -> "Hard."
                Effort.EASIER -> "Easier."
            }
        }

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
