package com.enigma2.android.ui.epg

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.enigma2.android.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class EpgTimeRulerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val pixelsPerMinute: Float = 6f
    private val tickIntervalMs: Long = TimeUnit.MINUTES.toMillis(30)

    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.text_secondary)
        textSize = resources.getDimension(R.dimen.epg_ruler_text_size)
    }
    private val paintLine = Paint().apply {
        color = ContextCompat.getColor(context, R.color.surface_elevated)
        strokeWidth = 1f
    }

    var startTimeMs: Long = 0L
        set(value) {
            field = value
            invalidate()
            requestLayout()
        }

    var totalWidthPx: Int = 0
        set(value) {
            field = value
            requestLayout()
        }

    private val fmt = SimpleDateFormat("HH:mm", Locale.getDefault())

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = if (totalWidthPx > 0) totalWidthPx else MeasureSpec.getSize(widthMeasureSpec)
        val h = MeasureSpec.getSize(heightMeasureSpec).coerceAtLeast(48)
        setMeasuredDimension(w, h)
    }

    override fun onDraw(canvas: Canvas) {
        if (startTimeMs == 0L) return
        var tickMs = startTimeMs - (startTimeMs % tickIntervalMs) + tickIntervalMs
        while (true) {
            val x = ((tickMs - startTimeMs) / 60_000f) * pixelsPerMinute
            if (x > width) break
            canvas.drawLine(x, 0f, x, height.toFloat(), paintLine)
            canvas.drawText(fmt.format(Date(tickMs)), x + 4f, height * 0.7f, paintText)
            tickMs += tickIntervalMs
        }
    }
}
