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
public final class Helper {

    public static String[] getData() {
        return data.toArray(new String[data.size()]);
    }

    private static List<String> data = new ArrayList<>();
    public static String[] tabs = {"娱乐", "军事", "汽车", "财经", "笑话", "体育", "科技", "感情", "头条"};

    static {
        data.add(tabs[0]);
        data.add(tabs[1]);
        data.add(tabs[2]);
    }


    public static List<Channel> initChannelData(NewsTab newsTab) {
        List<Channel> mSelectedChannels = new ArrayList<>();
        for (int i = 0; i < newsTab.getTabs().size(); i++) {
            if (newsTab.getTabs().get(i).isState()) {
                String title = newsTab.getTabs().get(i).getTitle();
                String code = newsTab.getTabs().get(i).getTitle();
                mSelectedChannels.add(new Channel(title, code));
            }
        }
        return mSelectedChannels;
    }


    public static ArrayList<Fragment> initFragmentData(NewsTab newsTab) {
        ArrayList<Fragment> mFragmentChannels = new ArrayList<>();
        for (int i = 0; i < newsTab.getTabs().size(); i++) {
            if (newsTab.getTabs().get(i).isState()) {
                mFragmentChannels.add(new ChannelDelegate(initChannelData(newsTab).get(i).getChanglCode(), newsTab.getTabs().get(i)));
            }
        }
        return mFragmentChannels;
    }

}
