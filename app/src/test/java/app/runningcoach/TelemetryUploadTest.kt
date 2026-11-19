package app.runningcoach

import android.content.Context
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * `TelemetryUpload` reaches the campus uploader by reflection, so the compiler
 * cannot catch a change that breaks the call. These are the two things it looks
 * up at run time, and getting the receiver wrong is what crashed every debug
 * launch until this was written.
 */
class TelemetryUploadTest {
    private val target = Class.forName("app.runningcoach.CampusTelemetryUpload")

    @Test
    fun theSingletonIsReachableByTheNameTheShimUses() {
        assertNotNull(
            "TelemetryUpload invokes runOnce on this object; without it the receiver is null",
            target.getField("INSTANCE").get(null),
        )
    }

    @Test
    fun runOnceIsReachableWithTheSignatureTheShimAsksFor() {
        assertNotNull(target.getDeclaredMethod("runOnce", Context::class.java))
    }
}
