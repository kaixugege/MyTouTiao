package com.kaixugege.xu.core.ui.myview.ttilebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
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
 * Time:           2019/4/25
 * ProjectName:    BomManage
 * ClassName:
 * Info:
 */
public class MyTItleBar extends LinearLayout {
    private String titleTextStr;
    private TextView tool_title;
    private LinearLayout tool_setting;
    private static final String TAG = "MyTItleBar";
    private ImageView back;

    public Integer getTitleTextColor() {
        return titleTextColor;
    }


    public MyTItleBar setTitleTextColor(Integer titleTextColor) {
        this.titleTextColor = titleTextColor;
        if (tool_title != null) {
            tool_title.setTextColor(titleTextColor);
        } else {
            Log.d(TAG, "title 为空");
        }

        return this;
    }

    private Integer titleTextColor;

    private TitleOnClickListener titleOnClickListener;

    public TitleOnClickListener getTitleOnClickListener() {
        return titleOnClickListener;
    }

    public void setTitleOnClickListener(TitleOnClickListener titleOnClickListener) {
        this.titleOnClickListener = titleOnClickListener;
    }


    public MyTItleBar(Context context) {
        this(context, null);
    }

    public MyTItleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTItleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        @SuppressLint("CustomViewStyleable") TypedArray typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.MyBar);

        int count = typedArray.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.MyBar_titleText) {
                titleTextStr = typedArray.getString(R.styleable.MyBar_titleText);
            }
        }
        typedArray.recycle();

        View view = LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this);
        initView(view);

    }


    private void initView(View view) {

        LinearLayout title_bar = (LinearLayout) view.findViewById(R.id.tool_back);
        tool_title = view.findViewById(R.id.tool_title);
        tool_setting = view.findViewById(R.id.tool_setting);
        back = view.findViewById(R.id.tool_back_img);
        if (back != null)
            back.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (titleOnClickListener != null) {
                        titleOnClickListener.onBackClick();
                    }
                }
            });
        else {
            Log.d(TAG, "返回键为空");
        }

        if (titleTextStr != null) {
            tool_title.setText(titleTextStr);
        }
        title_bar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleOnClickListener != null) {
                    titleOnClickListener.onBackClick();
                }
            }
        });

        tool_title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleOnClickListener != null) {
                    titleOnClickListener.onTItleClick();
                }
            }
        });
        tool_setting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleOnClickListener != null) {
                    titleOnClickListener.onSettingClick();
                }
            }
        });
    }

    public void setTitleTextStr(String titleStr) {
        if (!TextUtils.isEmpty(titleStr)) {
            if (tool_title != null) {
                tool_title.setText(titleStr);
            } else {
                Log.d(TAG, "title 为空");
            }
        }
    }

    /**
     * 监听标题点击接口
     */
    public interface TitleOnClickListener {
        /**
         * 返回按钮的点击事件
         */
        void onBackClick();

        void onTItleClick();

        void onSettingClick();
    }


}