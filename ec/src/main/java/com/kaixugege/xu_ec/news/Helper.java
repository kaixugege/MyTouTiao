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
    public static List<String> data = new ArrayList<>();

    static {
        data.add("关注");
        data.add("头条");
        data.add("视频");
        data.add("娱乐");
        data.add("体育");
        data.add("新时代");
        data.add("动漫");
        data.add("要闻");
        data.add("段子");
        data.add("北京");
        data.add("美图");
        data.add("汽车");
        data.add("科技");
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


    public static List<Fragment> initFragmentData() {
        List<Fragment> mFragmentChannels = new ArrayList<>();
        for (int i = 0; i < initChannelData().size(); i++) {
            mFragmentChannels.add(new ChannelDelegate(initChannelData().get(i).getChanglCode()));
        }
        return mFragmentChannels;
    }

}
