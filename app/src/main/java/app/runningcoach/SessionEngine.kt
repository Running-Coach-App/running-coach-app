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
    private var paceMissingAnnounced = false
    private var distanceMissingAnnounced = false
    private var offTopicRepliesGiven = 0

    fun start(kind: SessionKind): String {
        running = true
        this.kind = kind
        elapsedMillis = 0
        distanceMeters = null
        lastSpokenEffort = null
        nextStatsAtMillis = FIRST_STATS_AT_MILLIS
        paceMissingAnnounced = false
        distanceMissingAnnounced = false
        offTopicRepliesGiven = 0
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
            return offTopicReply(text)
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

    /**
     * The answer to a question that is not about this run. A question on a theme the
     * coach recognises gets that theme's line; anything else gets the next of the
     * general replies, so asking twice does not get the same words twice.
     */
    private fun offTopicReply(question: String): String {
        val words = question.split(NOT_A_LETTER).filter { it.isNotEmpty() }
        val themed = OFF_TOPIC_THEMES.firstOrNull { (keywords, _) -> keywords.any { it in words } }
        if (themed != null) {
            return themed.second
        }
        val reply = OFF_TOPIC_REPLIES[offTopicRepliesGiven % OFF_TOPIC_REPLIES.size]
        offTopicRepliesGiven++
        return reply
    }

    /**
     * The scheduled stats line. A stat that is missing is named once, then left
     * out until it is available again, per DEC-011.
     */
    fun statsPhrase(): String {
        val distance = distanceMeters
        val haveDistance = distance != null && distance > 0.0
        val havePace = haveDistance && elapsedMillis > 0

        val parts = mutableListOf(speakTime(elapsedMillis))
        if (havePace || !paceMissingAnnounced) {
            parts += speakPace(elapsedMillis, distanceMeters)
        }
        paceMissingAnnounced = !havePace
        if (haveDistance || !distanceMissingAnnounced) {
            parts += speakDistance(distanceMeters)
        }
        distanceMissingAnnounced = !haveDistance
        return parts.joinToString(" ")
    }

    companion object {
        /** The spoken stats cadence the customer fixed in DEC-013. */
        const val FIRST_STATS_AT_MILLIS: Long = 180_000
        const val STATS_EVERY_MILLIS: Long = 180_000

        private val NOT_A_LETTER = Regex("[^a-z]+")

        /**
         * Said to an off-topic question the coach recognises a theme in. Each line turns the
         * runner back to the run and states nothing about the theme itself, per DEC-012 and
         * the customer's ask for a reply with some character in it.
         */
        val OFF_TOPIC_THEMES: List<Pair<List<String>, String>> = listOf(
            listOf("eat", "ate", "eaten", "eating", "food", "hungry", "breakfast", "lunch", "dinner", "snack") to
                "Can we not think about food now and focus on the run?",
            listOf("weather", "rain", "raining", "sun", "sunny", "cold", "hot", "wind", "windy") to
                "The weather can wait. You are the one moving, not the sky.",
            listOf("work", "email", "emails", "meeting", "boss", "office", "deadline") to
                "Work will still be there at the cool down. Keep your legs going.",
            listOf("music", "song", "songs", "playlist", "radio") to
                "I only talk running. Your playlist is your own business.",
            listOf("sleep", "sleepy", "tired", "bed", "nap", "rest") to
                "You can rest later. Right now, one more step.",
        )

        /** Said to any other off-topic question, taken in turn so the coach does not repeat itself. */
        val OFF_TOPIC_REPLIES: List<String> = listOf(
            "That one is for after the run. Keep moving.",
            "I only know this run. Ask me about your time, your pace, or your distance.",
            "Not my department. Save it for the finish line.",
        )

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
