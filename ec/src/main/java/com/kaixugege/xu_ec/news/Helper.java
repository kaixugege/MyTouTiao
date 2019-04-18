package com.kaixugege.xu_ec.news;

import android.support.v4.app.Fragment;

import com.kaixugege.xu_ec.news.item.ChannelDelegate;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class Helper {
    public static List<Channel> initChannelData() {
        List<Channel> mSelectedChannels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String title = i + "";
            String code = i + "";
            mSelectedChannels.add(new Channel(title, code));
        }
        return mSelectedChannels;
    }


    public static List<Fragment> initFragmentData() {
        List<Fragment> mFragmentChannels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mFragmentChannels.add(new ChannelDelegate(initChannelData().get(i).getChanglCode()));
        }
        return mFragmentChannels;
    }

}
