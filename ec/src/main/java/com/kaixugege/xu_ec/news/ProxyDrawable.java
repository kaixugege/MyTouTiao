package com.kaixugege.xu_ec.news;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.lang.reflect.Field;

public class ProxyDrawable extends Drawable {
    View view;
    Paint paint;

    float paddingLeft ;
    float paddingTop;

    public ProxyDrawable(View view) {
        this.view = view;
        paint = new Paint();
        paint.setColor(0xFF6DA9FF);
        float density = view.getResources().getDisplayMetrics().density;
        //这两个留白可以根据需求更改
        paddingLeft = 0 * density;
        paddingTop =  5 * density;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        //这里通过反射获取SlidingTabStrip的两个变量，源代码画的是下划线，我们现在画的是带圆角的矩形
        int mIndicatorLeft = getIntValue("mIndicatorLeft");
        int mIndicatorRight = getIntValue("mIndicatorRight");
        int height = view.getHeight();
        int radius = height / 2;
        if (mIndicatorLeft >= 0 && mIndicatorRight > mIndicatorLeft) {
            canvas.drawRoundRect(new RectF(mIndicatorLeft + (int)paddingLeft, (int)paddingTop, mIndicatorRight - (int)paddingLeft, height - (int)paddingTop), radius, radius, paint);
        }
    }

    int getIntValue(String name) {
        try {
            Field f = view.getClass().getDeclaredField(name);
            f.setAccessible(true);
            Object obj = f.get(view);
            return (Integer) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }
}
