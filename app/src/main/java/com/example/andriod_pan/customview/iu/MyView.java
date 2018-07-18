package com.example.andriod_pan.customview.iu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by andriod_pan on 2018/7/18.
 */

public class MyView extends View {


    public MyView(Context context) {
        super(context);
    }


    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //先声明两个int值来表示最终的width和height并给定一个默认的大小
        int width_size = 100;
        int height_size = 100;
        //使用MeasureSpec分别获取width和height的MODE和SIZE
        int HEIGHT_MODE = MeasureSpec.getMode(heightMeasureSpec);
        int HEIGHT_SIZE = MeasureSpec.getSize(heightMeasureSpec);
        int WIDTH_MODE = MeasureSpec.getMode(widthMeasureSpec);
        int WIDTH_SIZE = MeasureSpec.getSize(widthMeasureSpec);
        if (HEIGHT_MODE == MeasureSpec.EXACTLY) {
            height_size = HEIGHT_SIZE;       //如果测量模式是精确的话 那么就直接使用获取到的值就好了
        } else if (HEIGHT_MODE == MeasureSpec.AT_MOST) {  //如果是最大值模式的话 那么久比较获取的和设定的默认值那个小就使用那个.ps:Math.min(int a,int b)是比较数值大小的.
            height_size = Math.min(HEIGHT_SIZE, height_size);
        } else if (HEIGHT_MODE == MeasureSpec.UNSPECIFIED) {
            height_size = 100;
        }

        if (WIDTH_MODE == MeasureSpec.EXACTLY) {
            width_size = WIDTH_SIZE;
        } else if (WIDTH_MODE == MeasureSpec.AT_MOST) {
            width_size = Math.min(WIDTH_SIZE, width_size);
        } else if (HEIGHT_MODE == MeasureSpec.UNSPECIFIED) {
            width_size = 100;
        }
        //测量完毕后得到的了width和height通过setMeasuredDimension()设置width和height,真正决定具体大小的是setMeasuredDimension()的两个参数.
        setMeasuredDimension(width_size, height_size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.GRAY);
        float radius = 100;
        float radius2 = 50;
        float cx = 50;
        float cy = 50;
        Paint paint = new Paint();       //实例化一个Paint对象
        paint.setColor(Color.YELLOW);      //设置圆的颜色
        //通过canvas的drawCircle方法画一个圆圈.
        canvas.drawCircle(400, 400, radius, paint);

        Paint paint2 = new Paint();       //实例化一个Paint对象
        paint2.setColor(Color.BLACK);      //设置圆的颜色
        //通过canvas的drawCircle方法画一个圆圈.
        canvas.drawCircle(400, 400, radius2, paint2);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                //按下

                break;
            case MotionEvent.ACTION_MOVE:
                //移动

                break;
            case MotionEvent.ACTION_UP:
                //松开

                break;
        }
        return super.onTouchEvent(event);
    }
}

