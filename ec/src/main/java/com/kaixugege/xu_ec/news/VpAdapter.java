package com.kaixugege.xu_ec.news;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
class VpAdapter extends FragmentStatePagerAdapter {


    private List<Channel> mChannels;

    private List<Fragment> mFragments;

    private ArrayList<NewsTab.Tab> tabs;


    public VpAdapter(FragmentManager fm) {
        super(fm);
    }

    public VpAdapter(FragmentManager fm, List<Channel> channels, List<Fragment> fragments) {
        super(fm);
        this.mChannels = channels != null ? mChannels = channels : new ArrayList<Channel>();
        this.mFragments = fragments != null ? mFragments = fragments : new ArrayList<Fragment>();
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return ((Channel) (mChannels.get(position))).getTitle();
//    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
