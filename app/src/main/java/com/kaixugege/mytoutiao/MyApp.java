package com.kaixugege.mytoutiao;

import com.kaixugege.xu.core.app.XuApp;
import com.kaixugege.xu.core.app.XuTouTiao;
import com.kaixugege.xu.core.net.Net;

/**
 * @Author: KaixuGege
 * Time:           2019/5/20
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class MyApp extends XuApp {

    @Override
    public void onCreate() {
        super.onCreate();

        Net.instance()
                .setUrl("http://api.dagoogle.cn/")
                .putApi("news_list", "news/nlist")//新闻列表
                .putApi("news_info", "news/ndetail")//新闻资讯详情
                .putApi("news_reply", "news/nreply");//新闻评论回复列表

        XuTouTiao.init(getApplicationContext())
                .withApiHost(Net.instance().getUrl())
                .withLoginReady(false)
                .withConfigReady(true);

    }

}
