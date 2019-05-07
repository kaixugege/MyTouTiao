package com.kaixugege.mytoutiao.content;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kaixugege.mytoutiao.R;
import com.kaixugege.xu_ec.news.NewsDelegate;
import com.kaixugege.xu_ec.news.ViewFindUtils;
import com.xugege.xu_lib_tablayout.tablayout.CommonTabLayout;
import com.xugege.xu_lib_tablayout.tablayout.listener.CustomTabEntity;
import com.xugege.xu_lib_tablayout.tablayout.listener.OnTabSelectListener;
import com.xugege.xu_lib_tablayout.tablayout.utils.UnreadMsgUtils;
import com.xugege.xu_lib_tablayout.tablayout.widget.MsgView;

import java.util.ArrayList;
import java.util.Random;

public class ContentActivity extends AppCompatActivity {
    private Context mContext;
    private CommonTabLayout bottomTab = null;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private Integer[] mIconUnselectIds = {
            new Integer(R.mipmap.tab_home_unselect), new Integer(R.mipmap.tab_speech_unselect),
            new Integer(R.mipmap.tab_contact_unselect), new Integer(R.mipmap.tab_more_unselect)};
    private Integer[] mIconSelectIds = {
            new Integer(R.mipmap.tab_home_select), new Integer(R.mipmap.tab_speech_select),
            new Integer(R.mipmap.tab_contact_select), new Integer(R.mipmap.tab_more_select)};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


        try {
            mContext = this;
            viewPager = findViewById(R.id.content_lls);
            bottomTab = findViewById(R.id.bottom_tabss);
            if (bottomTab == null)
                Log.d("==========", "为空啊");

            else
                Log.d("==========", "不  为空啊");
            for (String title : mTitles) {
                mFragments.add(NewsDelegate.newInstance("Switch ViewPager " + title));
            }

            for (int i = 0; i < mTitles.length; i++) {
                mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            }

            Log.d("==========", "开始设置");
            //两位数
            bottomTab.showMsg(0, 55);

            bottomTab.setMsgMargin(0, -5, 5);

            //三位数
            bottomTab.showMsg(1, 100);
            bottomTab.setMsgMargin(1, -5, 5);

            //设置未读消息红点
            bottomTab.showDot(2);
            MsgView rtv_2_2 = bottomTab.getMsgView(2);
            if (rtv_2_2 != null) {
                UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f));
            }

            //设置未读消息背景
            bottomTab.showMsg(3, 5);
            bottomTab.setMsgMargin(3, 0, 5);
            MsgView rtv_2_3 = bottomTab.getMsgView(3);
            if (rtv_2_3 != null) {
                rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
            }

            MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

            viewPager.setAdapter(adapter);
        } catch (Exception ex) {
            Log.d(" =========== ", ex.getMessage());
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    Random mRandom = new Random();

    private void tl_2() {
        bottomTab.setTabData(mTabEntities);
        bottomTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    bottomTab.showMsg(0, mRandom.nextInt(100) + 1);
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomTab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(1);
    }

    protected int dp2px(float dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
