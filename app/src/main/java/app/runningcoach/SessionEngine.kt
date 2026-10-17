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

    fun start(kind: SessionKind): String {
        running = true
        this.kind = kind
        return "Session started."
    }

    fun stop(): String {
        running = false
        return "Session stopped."
    }
}
