package com.kaixugege.xu_ec.news;

import android.support.v4.app.Fragment;

import com.kaixugege.xu_ec.news_item.ChannelDelegate;

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
    public static String[] getData() {
        return data.toArray(new String[data.size()]);
    }

    private static List<String> data = new ArrayList<>();
    private static String[] tabs = {"娱乐","军事","汽车","财经","笑话","体育","科技","感情","头条"};

    static {
        data.add(tabs[0]);
        data.add(tabs[1]);
        data.add(tabs[2]);
    }


    public static List<Channel> initChannelData() {
        List<Channel> mSelectedChannels = new ArrayList<>();
        for (String data : data) {
            String title = data;
            String code = data;
            mSelectedChannels.add(new Channel(title, code));
        }
        return mSelectedChannels;
    }


    public static ArrayList<Fragment> initFragmentData() {
        ArrayList<Fragment> mFragmentChannels = new ArrayList<>();
        for (int i = 0; i < initChannelData().size(); i++) {
            mFragmentChannels.add(new ChannelDelegate(initChannelData().get(i).getChanglCode()));
        }
        return mFragmentChannels;
    }

}
