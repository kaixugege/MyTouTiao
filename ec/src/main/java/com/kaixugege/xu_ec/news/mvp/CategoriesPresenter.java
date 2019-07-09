package com.kaixugege.xu_ec.news.mvp;

import android.content.Context;
import android.util.Log;


import android.widget.Toast;
import com.kaixugege.xu.core.net.Net;
import com.kaixugege.xu.core.net.RestClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class CategoriesPresenter implements CategoriesContract.CategoriesPresenter {
    private static final String TAG = "CategoriesPresenter";
    private Disposable disposable;
    private Context context;

    public CategoriesPresenter(CategoriesContract.CategoriesView categoriesView) {
        this.categoriesView = categoriesView;
    }


    public CategoriesPresenter(CategoriesContract.CategoriesView categoriesView, Context activity) {
        this.categoriesView = categoriesView;
        this.context = activity;
    }

    private CategoriesContract.CategoriesView categoriesView;


    @Override
    public Disposable categories() {
        Log.d(getClass().getSimpleName(), "categories   这里要加载数据 ");
        HashMap<String, Object> mParams = new HashMap<>();
        Observable<String> observable = RestClient.builder()
                .url(Net.instance().getApi().get("news_list"))
                .params(mParams)
                .build()
                .get();
       observable
                .subscribeOn(Schedulers.io())//指定被观察者执行的线程
                .observeOn(AndroidSchedulers.mainThread())//指定观察者执行的线程
                .subscribe(
                        new Observer<String>() {

                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.d(TAG,"onSubscribe  ");
                                disposable = d;

                            }

                            @Override
                            public void onNext(String s) {
                                Log.d(TAG,"onNext  "+s);
                                Toast.makeText(context, "onNext:\r\n" + s, Toast.LENGTH_LONG).show();
                                categoriesView.onCategoriesSucc(null);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(TAG,"onError  "+e.getMessage());
                                categoriesView.onCategoriesFail();
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG,"onComplete  ");
                            }

                        }
                );
//
//        , new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Toast.makeText(context, "accept:\r\n" + s, Toast.LENGTH_LONG).show();
//                Log.i(getClass().getSimpleName(), "accept " + s);
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//
//            }
//        }
        return disposable;
    }

    @Override
    public void start() {

    }
}
