package app.runningcoach

/**
 * The wordings the coach understands, kept as data rather than as conditions.
 *
 * `DEC-034`. The customer ruled out an embedded model on performance grounds — "moving to
 * embedded LLM is quite a bit of work, and it will make the performance of the app even
 * worse... it will work for 5 seconds, and then done" — and asked for the rule approach to
 * be widened instead: "try having a bunch of them, and ask LLM to generate a bunch of them,
 * and use the rules. I'm not saying that the rules approach is bad... more rules that detect
 * the intent."
 *
 * These phrasings were generated that way and then read through by hand before being
 * committed. **No model runs in the product.** What ships is this word list and the match
 * below, so a new wording costs a line here and no new code.
 *
 * A phrase matches when its words appear as consecutive words in the question. A one-word
 * phrase therefore matches that whole word anywhere and never inside a longer one: "fast"
 * answers about pace, and "breakfast" does not.
 *
 * Two words are deliberately absent. **"rate"** is not a pace word, because "what is my
 * heart rate" is a question this product must refuse rather than answer with a pace
 * ([`FR-005`]). And bare **"far"** is not a distance word, because "what is my time so far"
 * is a question about time.
 */
object QuestionVocabulary {
    /** How long the session has been running. */
    val TIME: List<String> = listOf(
        "time",
        "how long",
        "how much longer",
        "elapsed",
        "duration",
        "clock",
        "timer",
        "how many minutes",
        "how much time",
        "minutes so far",
        "minutes in",
        "been running",
        "been going",
        "running for",
        "going for",
        "started",
        "time now",
    )

    /** How fast the runner is moving. */
    val PACE: List<String> = listOf(
        "pace",
        "fast",
        "faster",
        "speed",
        "quick",
        "quickly",
        "tempo",
        "per kilometre",
        "per kilometer",
        "per km",
        "per mile",
        "minutes per kilometre",
        "minutes per km",
        "split",
        "splits",
        "slow",
        "slowing",
        "slowing down",
        "speeding up",
        "picking up",
        "am i slow",
        "am i fast",
        "how hard am i working",
    )

    /** How far the runner has gone. */
    val DISTANCE: List<String> = listOf(
        "distance",
        "how far",
        "how much further",
        "further",
        "kilometre",
        "kilometres",
        "kilometer",
        "kilometers",
        "km",
        "kms",
        "mile",
        "miles",
        "metre",
        "metres",
        "meter",
        "meters",
        "covered",
        "gone",
        "travelled",
        "traveled",
        "run so far",
    )

    /**
     * Every stat at once. The customer asked for this one by name: "I said, like, what's my
     * stats? Because I want it all, for example."
     *
     * Nothing here is a single common word like "doing", on purpose. "Doing" alone used to
     * mean this, which made "what speed am I doing" answer all three stats instead of the
     * pace that was asked for.
     */
    val EVERYTHING: List<String> = listOf(
        "stats",
        "stat",
        "statistics",
        "numbers",
        "everything",
        "all of it",
        "all three",
        "all my stats",
        "the lot",
        "summary",
        "status",
        "status update",
        "update",
        "report",
        "run report",
        "rundown",
        "recap",
        "overview",
        "the full picture",
        "how am i doing",
        "how am i going",
        "how am i getting on",
        "how are we doing",
        "how is it going",
        "how's it going",
        "how is the run going",
        "how is my run going",
        "how are things",
        "where am i at",
        "give me everything",
        "give me the stats",
        "tell me everything",
        "what's my status",
    )

    private val NOT_A_LETTER = Regex("[^a-z]+")

    /**
     * The words of a question, lowercased, with apostrophes closed up so that "how's"
     * becomes one word and the phrases above can be written the way a runner says them.
     */
    fun words(text: String): List<String> {
        return text.lowercase()
            .replace("'", "")
            .replace("’", "")
            .split(NOT_A_LETTER)
            .filter { it.isNotEmpty() }
    }

    /** True when any phrase in [phrases] appears as consecutive words in [questionWords]. */
    fun matches(questionWords: List<String>, phrases: List<String>): Boolean {
        return phrases.any { phrase -> containsRun(questionWords, words(phrase)) }
    }

    private fun containsRun(haystack: List<String>, needle: List<String>): Boolean {
        if (needle.isEmpty() || needle.size > haystack.size) {
            return false
        }
        for (start in 0..haystack.size - needle.size) {
            if (needle.indices.all { haystack[start + it] == needle[it] }) {
                return true
            }
        }
        return false
    }
}
