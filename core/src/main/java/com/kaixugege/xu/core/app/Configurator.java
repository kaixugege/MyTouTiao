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

    public WeakHashMap<String, Object> getConfigs() {
        return CONFIGS;
    }

    //配置
    private static final WeakHashMap<String, Object> CONFIGS = new WeakHashMap<>();

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

    public static <T> T getConfigurations(Object key) {
        return INSTANCE.getConfiguration(key);
    }

    //这个注释是说这个类型并没有检测过，但是不抛出警告
    @SuppressWarnings("unchecked")
    public final <T>  T getConfiguration(Object key){
        checkConfiguratio();
        final Object value = CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) CONFIGS.get(key);
    }
    /**
     * 保证配置的完整性和安全性
     *
     * 获取配置得时候调用
     */
    private void checkConfiguratio(){
        final  boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw  new RuntimeException("Configuration is not ready, call configurre");//抛出一个运行时异常
        }
    }
}
