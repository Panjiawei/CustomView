package com.example.andriod_pan.customview.iu;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by andriod_pan on 2018/7/18.
 */

public class RippleView extends View {


    private Paint mPaint;
    private Path mPath;
    //波纹的宽度
    private int mItemWaveLength = 1000;
    //波纹每次移动的距离
    private int dx;

    public RippleView(Context context) {
        super(context);
        init();
    }

    public RippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RippleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //初始化
    private void init(){
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动后,重置mPath，将之前路径清空
        mPath.reset();
        //距离顶部的高度
        int originY = 600;
        //波纹宽度的一般
        int halfWaveLen = mItemWaveLength/2;
        //随着刷新，每次移动dx距离
        mPath.moveTo(-mItemWaveLength+dx,originY);
        //for循环当前屏幕中所有的波纹
        for (int i = -mItemWaveLength;i<=getWidth()+mItemWaveLength;i+=mItemWaveLength){
            mPath.rQuadTo(halfWaveLen/2,-100,halfWaveLen,0);
            mPath.rQuadTo(halfWaveLen/2,100,halfWaveLen,0);
        }
        mPath.lineTo(getWidth(),getHeight());
        mPath.lineTo(0,getHeight());
        mPath.close();

        canvas.drawPath(mPath,mPaint);

    }

    /**
     * 动画的目的是让波纹移动起来
     * 利用调用在path.moveTo的时候，将起始点向右移动即可实现移动，
     * 而且只要我们移动一个波长的长度，波纹就会重合，就可以实现无限循环了
     */
    public void startAnim(){
        //动画移动的距离 0~mItemWaveLength
        ValueAnimator animator = ValueAnimator.ofInt(0,mItemWaveLength);
        //时间
        animator.setDuration(2000);
        //重复次数，这里是无限次
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        //动画刷新监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //每次移动的距离
                dx = (int)animation.getAnimatedValue();
                //刷新View
                postInvalidate();
            }
        });
        animator.start();
    }


}
