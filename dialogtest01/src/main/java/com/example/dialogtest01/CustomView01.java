package com.example.dialogtest01;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class CustomView01 extends View {

    private int mColor01;

    public CustomView01(Context context) {
        super(context,null);
    }

    public CustomView01(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public CustomView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.CustomView01);
        mColor01=a.getColor(R.styleable.CustomView01_textColor,Color.RED);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //先声明两个int值来表示最终的width和height并给定一个默认的大小
        int width_size  = 500;
        int height_size = 500;
        //使用MeasureSpec分别获取width和height的MODE和SIZE
        int HEIGHT_MODE = MeasureSpec.getMode(heightMeasureSpec);
        int HEIGHT_SIZE = MeasureSpec.getSize(heightMeasureSpec);
        int WIDTH_MODE = MeasureSpec.getMode(widthMeasureSpec);
        int WIDTH_SIZE = MeasureSpec.getSize(widthMeasureSpec);
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(width_size, height_size);
            // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(width_size, WIDTH_SIZE);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(HEIGHT_SIZE, height_size);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        // 画文本
//        canvas.drawText();
//        // 画弧
//        canvas.drawArc();
//        // 画圆
//        canvas.drawCircle();
        canvas.drawColor(Color.RED);      //设置canvas的背景色
        float radius = 50;                //给定半径
        //给定圆心的的坐标
        float cx = 50;
        float cy = 50;
        Paint paint1 = new Paint();       //实例化一个Paint对象
        paint1.setColor(Color.BLUE);      //设置圆的颜色
        //通过canvas的drawCircle方法画一个圆圈.
//        canvas.drawCircle(cx, cy, radius, paint1);
        Paint paint2 = new Paint();       //实例化一个Paint对象
        paint2.setColor(Color.BLACK);
        paint2.setStrokeWidth(10);//因为默认实在是太细了 设定了一个宽度值
        canvas.drawLine(0, 0, 100, 100, paint2);

        Paint paint3 = new Paint();       //实例化一个Paint对象
        paint3.setColor(Color.BLACK);     //设置圆的颜色
        paint3.setAntiAlias(true);        //设置抗锯齿
        paint3.setStyle(Paint.Style.STROKE);  //设置样式
        paint3.setStrokeWidth(3);          //设置宽度

        Paint paint4 = new Paint();      //实例化第二个paint对象
        paint4.setColor(Color.BLUE);     //设置颜色为蓝色
        paint4.setStyle(Paint.Style.STROKE);//设置样式
        paint4.setStrokeWidth(30);          //设定边框宽度

        //通过canvas的drawCircle方法画一个圆圈.
        canvas.drawCircle(cx, cy, radius, paint3);
        canvas.drawCircle(cx, cy, radius, paint4);
    }

    @Override
    protected void onLayout(boolean changed,int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 手指按下
                Log.e("TAG", "手指按下");
                break;
            case MotionEvent.ACTION_MOVE:
                // 手指移动
                Log.e("TAG", "手指移动");
                break;
            case MotionEvent.ACTION_UP:
                // 手指抬起
                Log.e("TAG", "手指抬起");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

}
