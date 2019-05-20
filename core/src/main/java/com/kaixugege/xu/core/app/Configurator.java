package com.kaixugege.xu.core.app;

import java.util.WeakHashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/5/20
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class Configurator {

    public WeakHashMap<Object, Object> getConfigs() {
        return CONFIGS;
    }

    //配置
    private static final WeakHashMap<Object, Object> CONFIGS = new WeakHashMap<>();

    private static class Holder {
        private static final Configurator CONFIGURATOR = new Configurator();
    }

    public static final Configurator INSTANCE = Holder.CONFIGURATOR;

    public Configurator withApiHost(String host) {
        getConfigs().put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public Configurator withLoginReady(boolean loginReady) {
        getConfigs().put(ConfigType.SIGN_IN_READY.name(), loginReady);
        return this;
    }

    //获取是否登陆,默认为false，没有登陆
    public boolean getLoginReady() {
        Object o = getConfigs().get(ConfigType.SIGN_IN_READY.name());
        boolean loginReady = false;
        if (o != null) {
            loginReady = (Boolean) o;
        }
        return loginReady;
    }


}
