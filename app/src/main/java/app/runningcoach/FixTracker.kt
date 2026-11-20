package app.runningcoach

/**
 * Whether a location fix is available, measured inside one session.
 *
 * This lives outside CoachService, with no Android types, because the arithmetic
 * is what went wrong: the service kept the last fix it had ever seen across
 * sessions, so a 28-second session reported 120 seconds without a fix and
 * `fix_available_pct` came out negative. A unit test cannot reach a Service, so
 * the counting that FR-013 and QR-04 depend on is checked here instead.
 *
 * Every spell of lost time this reports starts at or after the moment the
 * session started, so `lost_s` can never exceed the session that reports it.
 */
class FixTracker(private val staleAfterMillis: Long = STALE_AFTER_MILLIS) {
    /** Whether the fix counts as lost right now. */
    var lost = false
        private set

    private var lastFixAt = 0L
    private var lostSince = 0L

    /**
     * A session has started. Nothing from the previous session carries over, and
     * the clock the staleness test reads starts at the session's own first moment,
     * so a session that never gets a fix at all is reported as a lost fix rather
     * than as a session with nothing to say.
     */
    fun startSession(nowMillis: Long) {
        lost = false
        lostSince = 0L
        lastFixAt = nowMillis
    }

    /**
     * A fix arrived. Returns the whole seconds it had been lost when this ends a
     * lost spell, and null when the fix was not lost, so the caller records
     * `location_fix_regained` exactly once per spell.
     */
    fun onFix(nowMillis: Long): Long? {
        lastFixAt = nowMillis
        if (!lost) {
            return null
        }
        lost = false
        val lostSeconds = (nowMillis - lostSince) / 1000
        lostSince = 0L
        return lostSeconds
    }

    /**
     * Returns true on the single call that first finds the fix stale, so the
     * caller records `location_fix_lost` once rather than on every tick.
     */
    fun noteStaleness(nowMillis: Long): Boolean {
        if (lost || lastFixAt == 0L || nowMillis - lastFixAt <= staleAfterMillis) {
            return false
        }
        lost = true
        lostSince = lastFixAt
        return true
    }

    companion object {
        /** QR-04's grace period: a fix quiet for longer than this is a lost fix. */
        const val STALE_AFTER_MILLIS = 15_000L
    }
}
