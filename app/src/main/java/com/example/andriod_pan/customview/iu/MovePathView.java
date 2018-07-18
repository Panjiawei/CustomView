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

public class MovePathView extends View {

    private Path mPath;
    private Paint mPaint;
    //手指按下的位置
    private float startX,startY;

    public MovePathView(Context context) {
        super(context);
        init();
    }

    public MovePathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MovePathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //初始化
    private void init() {
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: //按下

                startX = event.getX();
                startY = event.getY();
                //设置原点
                mPath.moveTo(startX,startY);
                break;
            case MotionEvent.ACTION_UP: //松开

                break;
            case MotionEvent.ACTION_MOVE:  //移动
                float currX = event.getX();
                float currY = event.getY();
                //连线
                mPath.lineTo(currX,currY);
                //刷新view
                invalidate();
                break;

        }
        //返回true，消费事件
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }
    //对外提供的方法，重新绘制
    public void reset(){
        mPath.reset();
        invalidate();
    }









}
