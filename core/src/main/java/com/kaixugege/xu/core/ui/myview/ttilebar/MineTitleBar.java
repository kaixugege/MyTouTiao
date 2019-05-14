package com.kaixugege.xu.core.ui.myview.ttilebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaixugege.xu.core.R;

/**
 * @Author: KaixuGege
 * Time:           2019/5/14
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class MineTitleBar extends LinearLayout {

    private final String TAG = MineTitleBar.class.getSimpleName();
    private ImageView back;
    private String titleTextStr;
    private TextView tool_title;
    private LinearLayout tool_setting;
    private Integer titleTextColor;

    private IMineTitleBarClick iMineTitleBarClick;


    public MineTitleBar(Context context) {
        this(context, null);
    }

    public MineTitleBar(Context context, AttributeSet attrs) {
        this(context, null, 0);
    }

    public MineTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.MyBar);
        int count = typedArray.getIndexCount();

        for (int i = 0; i < count; i++) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.MyBar_titleText) {
                titleTextStr = typedArray.getString(R.styleable.MyBar_titleText);
            }
        }
        typedArray.recycle();
//首先我们重写了LinearLayout中带有两个参数的构造函数，
// 在布局中引入TitleLayout控件就会调用这个构造函数，
// 然后在构造函数中需要对标题栏布局进行动态加载，这就要借助LayoutInflater来实现了，
// 通过LayoutInflater的from()方法可以构造出一个LayoutInflater对象，
// 然后调用inflate()方法就可以动态加载一个布局文件，inflate()方法接收两个参宿，
// 第一个参数是要加载的布局文件的id，这里我们传入R.layout.title，
// 第二个参数是给加载好的布局再添加一个父布局，这里我们想要指定为TitleLayout，
// 于是直接传入this

        View view = LayoutInflater.from(context).inflate(R.layout.bar_mine_title, this);
        initView(view);
    }

    private void initView(View view) {
    }


    public MineTitleBar setTitleTextColor(Integer titleTextColor) {
        this.titleTextColor = titleTextColor;
        if (tool_title != null) {
            tool_title.setTextColor(titleTextColor);
        } else {
            Log.d(TAG, "title 为空");
        }

        return this;
    }

    public Integer getTitleTextColor() {
        return titleTextColor;
    }


    public IMineTitleBarClick getiMineTitleBarClick() {
        return iMineTitleBarClick;
    }

    public void setiMineTitleBarClick(IMineTitleBarClick iMineTitleBarClick) {
        this.iMineTitleBarClick = iMineTitleBarClick;
    }

    /**
     * 监听标题点击接口
     */
    public interface IMineTitleBarClick {
        /**
         * 返回按钮的点击事件
         */
        void onBackClick();

        void onTItleClick();

        void onSettingClick();
    }

}
