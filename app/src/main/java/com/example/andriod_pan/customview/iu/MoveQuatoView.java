package com.example.andriod_pan.customview.iu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by andriod_pan on 2018/7/18.
 */

public class MoveQuatoView extends View {
    private Paint mPaint;
    private Path mPath;
    //上个位置
    private float mPreX,mPreY;
    //结束位置
    private float endY,endX;

    public MoveQuatoView(Context context) {
        super(context);
        init();
    }

    public MoveQuatoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MoveQuatoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化
    private void init() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                endX = (mPreX + event.getX()) / 2;
                endY = (mPreY + event.getY()) / 2;
                mPath.quadTo(mPreX, mPreY, endX, endY);
                mPreX = event.getX();
                mPreY = event.getY();
                invalidate();
                break;
        }
        return true;
    }



}
