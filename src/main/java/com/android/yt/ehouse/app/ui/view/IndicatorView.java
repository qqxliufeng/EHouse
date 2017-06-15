package com.android.yt.ehouse.app.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.android.yt.ehouse.app.R;


/**
 * Created by feng on 2016/9/14.
 */

public class IndicatorView extends View {

    private Paint mPaint;
    private int radius;
    private boolean isFocused;

    private int defaultIndicatorColor;
    private int focusedIndicatorColor = Color.WHITE;

    public IndicatorView(Context context) {
        this(context,null);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.IndicatorView,defStyleAttr,0);
        defaultIndicatorColor = typedArray.getColor(R.styleable.IndicatorView_indicator_color, ContextCompat.getColor(getContext(), R.color.blue));
        typedArray.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = Math.min(getMeasuredHeight() / 2,getMeasuredWidth() / 2);
    }

    public void setSelect(boolean focused) {
        isFocused = focused;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isFocused){
            mPaint.setColor(focusedIndicatorColor);
        }else {
            mPaint.setColor(defaultIndicatorColor);
        }
        canvas.drawCircle(radius,radius,radius,mPaint);
    }

    public void setDefaultIndicatorColor(int indicatorColor) {
        this.defaultIndicatorColor = indicatorColor;
        invalidate();
    }

    public void setFocusedIndicatorColor(int indicatorColor){
        this.focusedIndicatorColor = indicatorColor;
        invalidate();
    }

}
