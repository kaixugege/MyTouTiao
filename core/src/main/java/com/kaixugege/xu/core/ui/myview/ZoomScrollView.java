package com.kaixugege.xu.core.ui.myview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * @Author: KaixuGege
 * Time:           2019/5/13
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 * 重写让ScrollView有滚动监听(23以前是没有滚动监听的)
 * 拦截touch事件，让其支持下拉放大图片
 */

public class ZoomScrollView extends ScrollView {
    private View zoomView;//需要拉伸的view
    /**
     * 是否正在下拉
     */
    private boolean mIsPulling;
    private int zoomViewHeight;
    private int zoomViewWidth;
    private int mLastY;
    private int mLastX;


    //滑动放大系数，系数越大，滑动时放大程度越大
    private float mScaleRatio = 0.4f;
    //    最大的放大倍数
    private float mScaleTimes = 2f;
    //    回弹时间系数，系数越小，回弹越快
    private float mReplyRatio = 0.5f;


    public ZoomScrollView(Context context) {
        super(context);

    }

    public ZoomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs);

    }


    public ZoomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);

    }

    @SuppressLint("NewApi")
    public ZoomScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttr(attrs);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        //设置不可过度滚动，否则上移后下拉会出现部分空白的情况
        setOverScrollMode(OVER_SCROLL_NEVER);

        //获取第 0 个 View.
        View child = getChildAt(0);


        if (child != null && child instanceof ViewGroup) {
            zoomView = ((ViewGroup) child).getChildAt(0);
        }

    }

    public void setHeadView(View headView) {
        zoomView = headView;
        zoomViewHeight = zoomView.getMeasuredHeight();
        zoomViewWidth = zoomView.getMeasuredHeight();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        zoomViewHeight = zoomView.getHeight();
        zoomViewWidth = zoomView.getWidth();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (zoomView == null)
            return super.onTouchEvent(ev);

        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (!mIsPulling) {
                    //第一次下拉
                    if (getScrollY() == 0) {
                        //在顶部的手，记录顶部位置
                        mLastY = (int) ev.getY();
                    } else {
                        break;
                    }

                    if (ev.getY() - mLastY < 0)
                        return super.onTouchEvent(ev);

                    int distance = (int) ((ev.getY() - mLastY) * mScaleRatio);
                    mIsPulling = true;
                    setZoom(distance);
                }
        }

        return super.onTouchEvent(ev);
    }

    /**
     * 放大view
     */
    private void setZoom(float s) {
        float scaleTimes = (float) ((zoomViewWidth + s) / (zoomViewWidth * 1.0));
//        如超过最大放大倍数，直接返回
        if (scaleTimes > mScaleTimes) return;

        ViewGroup.LayoutParams layoutParams = zoomView.getLayoutParams();
        layoutParams.width = (int) (zoomViewWidth + s);
        layoutParams.height = (int) (zoomViewHeight * ((zoomViewWidth + s) / zoomViewWidth));
//        设置控件水平居中
        ((MarginLayoutParams) layoutParams).setMargins(0, 0, -(layoutParams.width - zoomViewWidth) / 2, 0);
        zoomView.setLayoutParams(layoutParams);
    }

    private void replyView() {
        final float distance = zoomView.getMeasuredWidth() - zoomViewWidth;

        //设置动画
        ValueAnimator animator = ObjectAnimator.ofFloat(distance, 0.0F).setDuration((long) (distance * mReplyRatio));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setZoom((float) animation.getAnimatedValue());
            }
        });

        animator.start();

    }

    private void initAttr(AttributeSet attrs) {

    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    private OnScrollListener onScrollListener;

    public interface OnScrollListener {
        void onScroll(int scrollX, int scrollY, int oldScrollX, int oldScrollY);
    }
}
