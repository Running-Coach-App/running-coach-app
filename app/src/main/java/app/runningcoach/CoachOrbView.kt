package app.runningcoach

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

/**
 * The coach popup itself: a morphing blob, not a drawing inside a card.
 */
class CoachOrbView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {
    var listening: Boolean = false
        set(value) {
            field = value
            if (isShown) {
                startMotion()
            }
            invalidate()
        }

    private val fill = Paint(Paint.ANTI_ALIAS_FLAG)
    private val glow = Paint(Paint.ANTI_ALIAS_FLAG)
    private val blob = Path()
    private var phase = 0f
    private var motion: ValueAnimator? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val color = ContextCompat.getColor(context, R.color.accent_default)
        fill.color = color
        fill.style = Paint.Style.FILL
        glow.color = color
        glow.style = Paint.Style.FILL
        glow.alpha = 55
        startMotion()
    }

    override fun onDetachedFromWindow() {
        motion?.cancel()
        motion = null
        super.onDetachedFromWindow()
    }

    override fun onDraw(canvas: Canvas) {
        val cx = width / 2f
        val cy = height / 2f
        val pulse = 1f + 0.06f * sin(phase)
        canvas.save()
        canvas.scale(pulse, pulse, cx, cy)
        drawBlob(canvas, cx, cy, 1.18f, glow)
        drawBlob(canvas, cx, cy, 1f, fill)
        canvas.restore()
    }

    private fun drawBlob(canvas: Canvas, cx: Float, cy: Float, size: Float, paint: Paint) {
        val round = if (listening) 0.42f else 0.92f
        val rx = min(cx, width * 0.5f) * round * size
        val ry = cy * 0.78f * size
        val ripples = if (listening) 3 else 8
        val depth = if (listening) 0.07f else 0.16f
        blob.reset()
        val steps = 48
        for (i in 0..steps) {
            val t = i / steps.toFloat()
            val ang = (t * Math.PI * 2).toFloat()
            val wobble = 1f + depth * sin(phase * 2f + ang * ripples)
            val x = cx + rx * wobble * cos(ang)
            val y = cy + ry * wobble * sin(ang)
            if (i == 0) {
                blob.moveTo(x, y)
            } else {
                blob.lineTo(x, y)
            }
        }
        blob.close()
        canvas.drawPath(blob, paint)
    }

    private fun startMotion() {
        motion?.cancel()
        if (!ValueAnimator.areAnimatorsEnabled()) {
            phase = 1.1f
            invalidate()
            return
        }
        motion = ValueAnimator.ofFloat(0f, (Math.PI * 2).toFloat()).apply {
            duration = if (listening) 1400L else 800L
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            addUpdateListener {
                phase = it.animatedValue as Float
                invalidate()
            }
            start()
        }
    }
}
