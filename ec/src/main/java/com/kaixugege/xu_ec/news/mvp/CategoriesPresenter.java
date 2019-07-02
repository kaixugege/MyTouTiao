package com.kaixugege.xu_ec.news.mvp;

import android.util.Log;

import com.kaixugege.xu.core.net.RestClient;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class CategoriesPresenter implements CategoriesContract.CategoriesPresenter {
    private Disposable disposable;

    public CategoriesPresenter(CategoriesContract.CategoriesView categoriesView) {
        this.categoriesView = categoriesView;
    }

    private CategoriesContract.CategoriesView categoriesView;


    @Override
    public Disposable categories() {

        RestClient.builder().url("https://www.baidu.com")
                .build()
                .get().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d(getClass().getSimpleName(), "获取的数据为" + s);
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
