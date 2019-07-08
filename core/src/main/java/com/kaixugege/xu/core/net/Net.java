package com.kaixugege.xu.core.net;

import java.util.WeakHashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/7/8
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class Net {

    private Net() {

    }

    private static class Holder {
        static Net INSTANCE = new Net();
    }

    public static Net instance() {
        return Holder.INSTANCE;
    }

    private String url;//url路径
    private WeakHashMap<String, String> api;//api接口


    public String getUrl() {
        return url;
    }

    public Net setUrl(String url) {
        this.url = url;
        return this;
    }


    public WeakHashMap<String, String> getApi() {
        if (api == null) {
            api = new WeakHashMap<String, String>();
        }
        return api;
    }


    public Net putApi(String apiKey, String apiValue) {
        getApi().put(apiKey, apiValue);
        return this;
    }


    public Net putApi(WeakHashMap<String, String> apiMap) {
        getApi().putAll(apiMap);
        return this;
    }

    public Net clearApi() {
        getApi().clear();
        return this;
    }

    public void setApi(WeakHashMap<String, String> api) {
        if (api == null) {
            this.api = api;
        } else {
            this.api.putAll(api);
        }
    }


}
