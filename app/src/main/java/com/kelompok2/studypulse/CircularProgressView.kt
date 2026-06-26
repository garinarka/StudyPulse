package com.kelompok2.studypulse

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CircularProgressView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val bgPaint = Paint().apply {
        color = Color.parseColor("#FCE4DE")
        style = Paint.Style.STROKE
        strokeWidth = 18f
        isAntiAlias = true
    }

    private val progressPaint = Paint().apply {
        color = Color.parseColor("#E8765C")
        style = Paint.Style.STROKE
        strokeWidth = 18f
        strokeCap = Paint.Cap.ROUND
        isAntiAlias = true
    }

    private val rect = RectF()
    var maxValue: Int = 1500
    var currentValue: Int = 1500
        set(value) {
            field = value
            invalidate() // trigger onDraw ulang
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val stroke = progressPaint.strokeWidth
        rect.set(stroke / 2, stroke / 2, width - stroke / 2, height - stroke / 2)

        canvas.drawArc(rect, 0f, 360f, false, bgPaint)

        val sweepAngle = (currentValue.toFloat() / maxValue.toFloat()) * 360f
        canvas.drawArc(rect, -90f, sweepAngle, false, progressPaint)
    }
}