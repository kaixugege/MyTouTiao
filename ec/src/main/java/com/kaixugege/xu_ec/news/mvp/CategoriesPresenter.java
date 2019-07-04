package com.kaixugege.xu_ec.news.mvp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;


import android.widget.Toast;
import com.kaixugege.xu.core.net.RestClient;
import com.kaixugege.xu.core.net.RxRestService;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.HashMap;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class CategoriesPresenter implements CategoriesContract.CategoriesPresenter {
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
                .url("")
                .params(mParams)
                .build()
                .get();
        disposable = observable
                .subscribeOn(Schedulers.io())//指定被观察者执行的线程
                .observeOn(AndroidSchedulers.mainThread())//指定观察者执行的线程
                .subscribe(
                        new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                Toast.makeText(context, "accept:\r\n" + s, Toast.LENGTH_LONG).show();
                                Log.i(getClass().getSimpleName(), "accept " + s);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        },
                        new Action() {
                            @Override
                            public void run() throws Exception {

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
