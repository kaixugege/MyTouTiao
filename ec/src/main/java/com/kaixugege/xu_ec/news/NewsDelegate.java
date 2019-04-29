package com.kaixugege.xu_ec.news;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu.tablayout.tablayout.SlidingTabLayout;
import com.kaixugege.xu_ec.R;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class NewsDelegate extends BaseDelegate {
    private String TAG = "NewsDelegate";

    ViewPager viewPager;
    VpAdapter vpAdapter;
    SlidingTabLayout tab;
    ImageView mAddTab;

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
//        mAddTab = rootView.findViewById(R.id.content_add_tab);
        mAddTab = ViewFindUtils.find(rootView,R.id.content_add_tab);
        vpAdapter = new VpAdapter(getFragmentManager(), Helper.initChannelData(), Helper.initFragmentData());
        viewPager.setAdapter(vpAdapter);
        viewPager.setOffscreenPageLimit(Helper.initFragmentData().size());

//        tab.setTabMode(MODE_SCROLLABLE);
//        tab.setupWithViewPager(viewPager);


//        tab.setSelectedTabIndicatorColor(getResources().getColor(R.color.red));
        tab.setMinimumWidth(15);
//        tab.setTabTextColors(getResources().getColor(R.color.design_default_color_primary),getResources().getColor(R.color.red));
        int i = 0;
//        for (Channel channel : Helper.initChannelData()) {
//            tab.getTabAt(i).setText("是"+i);
//            tab.getTabAt(i).setCustomView(R.layout.tab_news);
//            View view1 = tab.getTabAt(i).getCustomView();
//            if (view1!= null){
////                view1.setBackground(new ProxyDrawable(view1));
//                TextView textView = view1.findViewById(R.id.tab_news_txt);
//                textView.setTextColor(getContext().getResources().getColor(R.color.red));
//                textView.setText(" i"+i);
//            }else{
//                Log.d(TAG,"view1 为空");
//            }


//            TabLayout.Tab t = tab.newTab().setText(channel.getTitle()).setCustomView(R.layout.tab_news);
//            TextView v =(TextView) t.getCustomView().findViewById(R.id.tab_news_txt);
//            v.setText(i);

//            tab.addTab(t, i);
//            View view = tab.getTabAt(i).getCustomView();
//            TextView textView = view.findViewById(R.id.tab_news_txt);
//            textView.setText(channel.getTitle()+" !!");
//            i++;
//        }
//        tab.setTabIndicatorFullWidth(false);
        return null;
    }


}
