package com.kaixugege.xu_ec.news_item.mvp;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.kaixugege.xu.core.net.Net;
import com.kaixugege.xu.core.net.RestClient;
import com.kaixugege.xu_ec.news.mvp.CategoriesContract;
import com.kaixugege.xu_ec.news_item.entiy.BNews;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.HashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/7/9
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class DiscoveryPresenter implements CategoriesContract.CategoriesPresenter {
    Disposable disposable = null;
    public DiscoveryContract.DiscoveryView discoveryView;

    public DiscoveryPresenter(DiscoveryContract.DiscoveryView discoveryView) {
        this.discoveryView = discoveryView;
    }

    @Override
    public Disposable categories() {

        Log.d(getClass().getSimpleName(), "categories   这里要加载数据 ");
        HashMap<String, Object> mParams = new HashMap<>();
        Observable<String> observable = RestClient.builder()
                .url(Net.instance().getApi().get("news_list"))
                .params(mParams)
                .build().get();
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
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
