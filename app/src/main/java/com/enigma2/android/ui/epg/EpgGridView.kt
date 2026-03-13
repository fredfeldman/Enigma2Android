package com.enigma2.android.ui.epg

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.enigma2.android.R
import com.enigma2.android.data.model.EpgEvent
import java.util.concurrent.TimeUnit

class EpgGridView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    // Callbacks
    var onEventSelected: ((EpgEvent) -> Unit)? = null
    var onEventLongPressed: ((EpgEvent) -> Unit)? = null
    var onEventDoubleClicked: ((EpgEvent) -> Unit)? = null

    // Data
    private var events: List<EpgEvent> = emptyList()
    private var serviceRefs: List<String> = emptyList()
    private var eventsByService: Map<String, List<EpgEvent>> = emptyMap()
    private var selectedEvent: EpgEvent? = null
    private var recordingEventIds: Set<Long> = emptySet()

    // Dimensions
    private val rowHeightPx: Float = resources.getDimension(R.dimen.epg_row_height)
    private val pixelsPerMinute: Float = 6f

    // Paints
    private val paintPast = Paint().apply {
        color = ContextCompat.getColor(context, R.color.epg_event_past)
    }
    private val paintNow = Paint().apply {
        color = ContextCompat.getColor(context, R.color.epg_event_now)
    }
    private val paintFuture = Paint().apply {
        color = ContextCompat.getColor(context, R.color.epg_event_future)
    }
    private val paintSelected = Paint().apply {
        color = ContextCompat.getColor(context, R.color.accent)
    }
    private val paintRecording = Paint().apply {
        color = ContextCompat.getColor(context, R.color.error)
    }
    private val paintText = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.text_primary)
        textSize = resources.getDimension(R.dimen.epg_text_size)
    }
    private val paintNowLine = Paint().apply {
        color = ContextCompat.getColor(context, R.color.accent)
        strokeWidth = 3f
    }
    private val paintBorder = Paint().apply {
        color = ContextCompat.getColor(context, R.color.surface_dark)
        strokeWidth = 1f
        style = Paint.Style.STROKE
    }

    var startTimeMs: Long = 0L
        set(value) {
            field = value
            invalidate()
        }

    private val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            val hit = hitTest(e.x, e.y)
            if (hit != null) {
                if (hit == selectedEvent) {
                    onEventDoubleClicked?.invoke(hit)
                } else {
                    selectedEvent = hit
                    onEventSelected?.invoke(hit)
                    invalidate()
                }
            }
            return true
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            val hit = hitTest(e.x, e.y)
            if (hit != null) {
                onEventDoubleClicked?.invoke(hit)
            }
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            val hit = hitTest(e.x, e.y)
            if (hit != null) {
                onEventLongPressed?.invoke(hit)
            }
        }
    })

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)
        return true
    }

    fun setEvents(events: List<EpgEvent>, serviceRefs: List<String>) {
        this.events = events
        this.serviceRefs = serviceRefs
        this.eventsByService = events.groupBy { it.sref }
        invalidate()
        requestLayout()
    }

    fun setRecordingIds(ids: Set<Long>) {
        recordingEventIds = ids
        invalidate()
    }

    private fun hitTest(x: Float, y: Float): EpgEvent? {
        val row = (y / rowHeightPx).toInt()
        if (row < 0 || row >= serviceRefs.size) return null
        val sref = serviceRefs[row]
        val tapMs = startTimeMs + (x / pixelsPerMinute * 60_000).toLong()
        return events.filter { it.sref == sref }
            .firstOrNull { tapMs >= it.beginTimestamp * 1000 && tapMs < (it.beginTimestamp + it.durationSeconds) * 1000 }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (startTimeMs == 0L || events.isEmpty()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }
        val maxEndMs = events.maxOfOrNull { (it.beginTimestamp + it.durationSeconds) * 1000L } ?: 0L
        val durationMs = maxEndMs - startTimeMs
        val width = ((durationMs / 60_000f) * pixelsPerMinute).toInt().coerceAtLeast(100)
        val height = (serviceRefs.size * rowHeightPx).toInt().coerceAtLeast(100)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (events.isEmpty() || serviceRefs.isEmpty()) return

        val nowMs = System.currentTimeMillis()
        val visibleLeft = scrollX.toFloat()
        val visibleRight = (scrollX + width).toFloat()

        serviceRefs.forEachIndexed { row, sref ->
            val top = row * rowHeightPx
            val bottom = top + rowHeightPx
            // Skip rows entirely outside the visible vertical range
            if (bottom < 0 || top > height) return@forEachIndexed
            val rowEvents = eventsByService[sref] ?: return@forEachIndexed

            rowEvents.forEach { event ->
                val eventStartMs = event.beginTimestamp * 1000L
                val eventEndMs = eventStartMs + event.durationSeconds * 1000L
                val left = ((eventStartMs - startTimeMs) / 60_000f) * pixelsPerMinute
                val right = ((eventEndMs - startTimeMs) / 60_000f) * pixelsPerMinute
                if (right < visibleLeft || left > visibleRight) return@forEach

                val rect = RectF(left, top + 1, right - 1, bottom - 1)
                val paint = when {
                    event == selectedEvent -> paintSelected
                    event.id in recordingEventIds -> paintRecording
                    eventEndMs < nowMs -> paintPast
                    eventStartMs <= nowMs -> paintNow
                    else -> paintFuture
                }
                canvas.drawRoundRect(rect, 4f, 4f, paint)
                canvas.drawRoundRect(rect, 4f, 4f, paintBorder)

                // Clip text to rect
                canvas.save()
                canvas.clipRect(rect)
                canvas.drawText(
                    event.title,
                    left + 8f,
                    top + rowHeightPx * 0.6f,
                    paintText
                )
                canvas.restore()
            }
        }

        // "Now" vertical line
        val nowX = ((nowMs - startTimeMs) / 60_000f) * pixelsPerMinute
        if (nowX >= 0 && nowX <= width) {
            canvas.drawLine(nowX, 0f, nowX, height.toFloat(), paintNowLine)
        }
    }
}
