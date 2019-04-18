package com.kaixugege.xu_ec.news;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class NewsDelegate extends BaseDelegate {

    ViewPager viewPager;
    VpAdapter vpAdapter;
    TabLayout tab;

    @Override
    public Object setLayout() {
        Log.d("NewsDelegate", "开始setlayout");
        return R.layout.delegate_news;
    }

    @Override
    public Object onBindView(View rootView) {
        Log.d("NewsDelegate", "onBindView");

        viewPager = rootView.findViewById(R.id.news_vp);
        tab = rootView.findViewById(R.id.tabContent);

        vpAdapter = new VpAdapter(getFragmentManager(), Helper.initChannelData(), Helper.initFragmentData());
        viewPager.setAdapter(vpAdapter);
        viewPager.setOffscreenPageLimit(Helper.initFragmentData().size());
        int i=0;
//
//        for (Channel channel:Helper.initChannelData()){
//            TabLayout.Tab ta = new TabLayout.Tab();
//            ta.setText(channel.getTitle());
//            tab.addTab(ta,i);
//            i++;
//        }
        tab.setTabMode(MODE_SCROLLABLE);
        tab.setupWithViewPager(viewPager);



        return null;
    }


}
