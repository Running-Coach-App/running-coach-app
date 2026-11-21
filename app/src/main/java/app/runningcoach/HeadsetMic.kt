package app.runningcoach

/**
 * Picks which capture device the recogniser should use.
 *
 * The integers are the same as `AudioDeviceInfo` type constants, kept here so
 * the ranking can be unit-tested without an Android runtime.
 */
object HeadsetMic {
    const val TYPE_WIRED_HEADSET = 3
    const val TYPE_BLUETOOTH_SCO = 7
    const val TYPE_BUILTIN_MIC = 15
    const val TYPE_BLE_HEADSET = 26

    fun preferredType(types: List<Int>): Int? {
        val present = types.toSet()
        if (TYPE_BLUETOOTH_SCO in present) {
            return TYPE_BLUETOOTH_SCO
        }
        if (TYPE_BLE_HEADSET in present) {
            return TYPE_BLE_HEADSET
        }
        if (TYPE_WIRED_HEADSET in present) {
            return TYPE_WIRED_HEADSET
        }
        if (TYPE_BUILTIN_MIC in present) {
            return TYPE_BUILTIN_MIC
        }
        return null
    }
}