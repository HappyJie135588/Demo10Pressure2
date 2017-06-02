package com.huangjie.demo10pressure2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by HuangJie on 2017/6/2.
 */

public class MyPressureView extends View {
    private int pressure = 0;

    public MyPressureView(Context context) {
        super(context);
        //程序员在代码中动态创建控件的时候使用
    }

    public MyPressureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //AttributeSet 属性集合 解析xml文件时 属性都会封装在这个AttributeSet中
    }

    public MyPressureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //多了一个defStyleAttr 在xml文件中声明一个样式的时候 解析xml之后 就会转换成这个defStyleAttr
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        if (pressure > 80) {
            paint.setColor(Color.RED);
        } else if (pressure > 50) {
            paint.setColor(Color.YELLOW);
        } else {
            paint.setColor(Color.GREEN);
        }
        paint.setTextSize(30);
//        paint.setColor(Color.RED);
        canvas.drawText("当前压力值",30,30,paint);
        canvas.drawRect(30, 200 - pressure, 80, 200, paint);
    }

    /**
     * 设置压力大小
     *
     * @param pressure
     */
    public void setPressure(int pressure) {
        this.pressure = pressure;
        //当pressure发生改变要重绘界面
        //使当前的界面无效 如果view是可见的在未来某一时刻会调用onDraw重新绘制界面
        //invalidate();
        //子线程刷新界面要用postInvalidate
        postInvalidate();
    }
}
