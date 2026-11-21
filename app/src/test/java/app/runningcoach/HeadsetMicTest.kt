package app.runningcoach

import org.junit.Assert.assertEquals
import org.junit.Test

class HeadsetMicTest {
    @Test
    fun prefersBluetoothScoOverWired() {
        assertEquals(
            HeadsetMic.TYPE_BLUETOOTH_SCO,
            HeadsetMic.preferredType(listOf(HeadsetMic.TYPE_WIRED_HEADSET, HeadsetMic.TYPE_BLUETOOTH_SCO)),
        )
    }

    @Test
    fun fallsBackToBuiltinMic() {
        assertEquals(
            HeadsetMic.TYPE_BUILTIN_MIC,
            HeadsetMic.preferredType(listOf(HeadsetMic.TYPE_BUILTIN_MIC)),
        )
    }
}