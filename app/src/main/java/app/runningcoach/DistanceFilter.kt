package app.runningcoach

/** One location fix, reduced to what a decision about distance needs. */
data class Fix(
    val atMillis: Long,
    /** The accuracy radius the provider reports, in metres, or null when it reports none. */
    val accuracyMetres: Float?,
    /** The provider's own speed in metres per second, or null when it reports none. */
    val speedMps: Float?,
)

/**
 * Which fixes the product measures distance with, and which steps between them
 * count as distance covered.
 *
 * Before this existed, every fix the provider produced was trusted and every
 * difference between two of them was added, so a phone lying still on a desk
 * recorded 516 m in four and a half minutes and spoke a pace of 1:38 per
 * kilometre (#251). A GPS fix wanders by tens of metres while the phone does not
 * move, and `distanceTo` is never negative, so the error only ever accumulates.
 *
 * docs/architecture/adr/ADR-007.md holds every threshold below and the reason it
 * was chosen. This lives outside CoachService, with no Android types, so a unit
 * test can reach it.
 */
object DistanceFilter {
    /**
     * Whether a fix is accurate enough to measure with at all. A fix that reports
     * no accuracy cannot support a distance claim, because nothing bounds its error.
     */
    fun usable(fix: Fix): Boolean {
        val accuracy = fix.accuracyMetres
        return accuracy != null && accuracy <= ACCURACY_LIMIT_METRES
    }

    /**
     * Whether the step between two usable fixes is distance the runner covered.
     *
     * Three things disqualify it: the provider's own speed saying the device is not
     * moving, which is independent of where the coordinates wandered to; a step too
     * short to tell from noise; and a step that implies a speed no runner reaches.
     */
    fun stepCounts(previous: Fix, next: Fix, stepMetres: Double): Boolean {
        if (stepMetres < NOISE_FLOOR_METRES) {
            return false
        }
        val speed = next.speedMps
        if (speed != null && speed < MOVING_SPEED_MPS) {
            return false
        }
        val elapsedMillis = next.atMillis - previous.atMillis
        if (elapsedMillis <= 0) {
            return false
        }
        return stepMetres / (elapsedMillis / 1000.0) <= STEP_SPEED_LIMIT_MPS
    }

    /**
     * Whether a pace is one a runner could have held for the whole session, which is
     * what an average over the session's own elapsed time claims. A pace that fails
     * this is not spoken as fact: FR-006's "not available yet" is said instead.
     */
    fun paceIsPlausible(elapsedMillis: Long, distanceMeters: Double?): Boolean {
        if (distanceMeters == null || distanceMeters <= 0.0 || elapsedMillis <= 0) {
            return false
        }
        return distanceMeters / (elapsedMillis / 1000.0) <= AVERAGE_SPEED_LIMIT_MPS
    }

    /** A fix whose radius is worse than this is not measured with. ADR-007. */
    const val ACCURACY_LIMIT_METRES = 20.0f

    /** Below this the provider says the device is not moving, whatever the coordinates say. */
    const val MOVING_SPEED_MPS = 0.5f

    /** A one-second step faster than this is a fix jumping, not a person running. */
    const val STEP_SPEED_LIMIT_MPS = 12.5

    /** An average over a whole session above this is beyond any human record. */
    const val AVERAGE_SPEED_LIMIT_MPS = 8.0

    /** Below this a step is under the resolution of a consumer fix. */
    const val NOISE_FLOOR_METRES = 1.0
}
