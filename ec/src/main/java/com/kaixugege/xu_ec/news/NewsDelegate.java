package com.kaixugege.xu_ec.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;
import com.xu.gege.fragment.frg.ILazyLoda;
import com.xugege.xu_lib_tablayout.tablayout.SlidingTabLayout;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class NewsDelegate extends BaseDelegate {
    private String TAG = "NewsDelegate";
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    ViewPager viewPager;
    VpAdapter vpAdapter;
    SlidingTabLayout tab;
    ImageView search;
    ImageView add;

    public static NewsDelegate newInstance(String s) {

        Bundle args = new Bundle();

        NewsDelegate fragment = new NewsDelegate();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Object getLayout() {
        Log.d("NewsDelegate", "开始getlayout");
        return R.layout.delegate_news;
    }

    @Override
    public void onBindView(View rootView) {
        Log.d("NewsDelegate", "onBindView");

        viewPager = ViewFindUtils.find(rootView, R.id.news_vp);
        tab = ViewFindUtils.find(rootView, R.id.content_tablayout);
        search = ViewFindUtils.find(rootView, R.id.iv_search);
        add = ViewFindUtils.find(rootView, R.id.iv_add);

        vpAdapter = new VpAdapter(getFragmentManager(), Helper.initChannelData(), Helper.initFragmentData());
        viewPager.setAdapter(vpAdapter);


        tab.setViewPager(viewPager, Helper.getData(), getActivity(), Helper.initFragmentData());
        tab.setTabPadding(12);
        tab.setTabSpaceEqual(true);
        tab.setTextSelectColor(getActivity().getResources().getColor(R.color.black));
        tab.setTextUnselectColor(getActivity().getResources().getColor(R.color.textbg));


    }


    @Override
    public ILazyLoda setILoader() {
        return new ILazyLoda() {
            @Override
            public void onFragmentFirstVisible() {

            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {

            }
        };
    }
}
