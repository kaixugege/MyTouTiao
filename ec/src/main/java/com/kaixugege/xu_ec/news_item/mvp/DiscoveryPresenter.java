package com.kaixugege.xu_ec.news_item.mvp;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.TypeReference;
import com.kaixugege.xu.core.net.Net;
import com.kaixugege.xu.core.net.RestClient;
import com.kaixugege.xu.core.net.RestCreator;
import com.kaixugege.xu_ec.news.mvp.CategoriesContract;
import com.kaixugege.xu_ec.news_item.entiy.BNews;
import com.kaixugege.xu_ec.news_item.mvp.DiscoveryContract;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/7/9
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class DiscoveryPresenter implements CategoriesContract.CategoriesPresenter {

    public DiscoveryContract.DiscoveryView discoveryView;

    public DiscoveryPresenter(DiscoveryContract.DiscoveryView discoveryView) {
        this.discoveryView = discoveryView;
    }

    @Override
    public Disposable categories() {
           Disposable disposable = null;
        Log.d(getClass().getSimpleName(), "categories   这里要加载数据 ");
        HashMap<String, Object> mParams = new HashMap<>();
        Observable<String> observable = RestClient.builder()
                .url(Net.instance().getApi().get("news_list"))
                .params(mParams)
                .build().get();
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                BNews bNews = JSONObject.parseObject(s,BNews.class);
                discoveryView.onDiscoverySuccess(bNews);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        return disposable;
    }

    @Override
    public void start() {

    }
}
