package com.kaixugege.mytoutiao;

import com.kaixugege.xu.core.app.XuApp;
import com.kaixugege.xu.core.app.XuTouTiao;

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

        XuTouTiao.init(getApplicationContext())
                .withApiHost("https://www.baidu.com")
                .withLoginReady(false)
                .withConfigReady(true);

    }

}
