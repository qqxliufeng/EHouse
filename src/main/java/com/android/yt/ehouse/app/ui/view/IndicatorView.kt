package com.android.yt.ehouse.app.ui.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View

import com.android.yt.ehouse.app.R


/**
 * Created by feng on 2016/9/14.
 */

class IndicatorView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private val mPaint: Paint
    private var radius: Int = 0
    private var isIndicatorFocused: Boolean = false

    private var defaultIndicatorColor: Int = 0
    private var focusedIndicatorColor = Color.WHITE

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.IndicatorView, defStyleAttr, 0)
        defaultIndicatorColor = typedArray.getColor(R.styleable.IndicatorView_indicator_color, ContextCompat.getColor(getContext(), R.color.blue))
        typedArray.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = Math.min(measuredHeight / 2, measuredWidth / 2)
    }

    fun setSelect(focused: Boolean) {
        isIndicatorFocused = focused
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        if (isFocused) {
            mPaint.color = focusedIndicatorColor
        } else {
            mPaint.color = defaultIndicatorColor
        }
        canvas.drawCircle(radius.toFloat(), radius.toFloat(), radius.toFloat(), mPaint)
    }

    fun setDefaultIndicatorColor(indicatorColor: Int) {
        this.defaultIndicatorColor = indicatorColor
        invalidate()
    }

    fun setFocusedIndicatorColor(indicatorColor: Int) {
        this.focusedIndicatorColor = indicatorColor
        invalidate()
    }

}
