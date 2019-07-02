package com.kaixugege.xu.core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/5/20
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class XuTouTiao {

    public static final WeakHashMap<String, Object> getConfigurations() {
        return Configurator.INSTANCE.getConfigs();
    }

    public static final Configurator getConfigurator() {
        return Configurator.INSTANCE;
    }

    //    初始化
    public static final Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context);
        return Configurator.INSTANCE;
    }


}
