package com.kaixugege.xu_ec.news.mvp;

import android.util.Log;


import com.kaixugege.xu.core.net.RxRestService;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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

    public CategoriesPresenter(CategoriesContract.CategoriesView categoriesView) {
        this.categoriesView = categoriesView;
    }

    private CategoriesContract.CategoriesView categoriesView;


    @Override
    public Disposable categories() {
        Log.d(getClass().getSimpleName(), "categories   这里要加载数据 ");
//        Observable<String> observable = RestClient.builder()
//                .url("https://www.baidu.com")
//                .build()
//                .get();
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//日志级别
//        builder.addInterceptor(loggingInterceptor);
//
//        OkHttpClient client = builder.build();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.baidu.com/")
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(client)
//                .build();
//        RxRestService  rxRestService = retrofit.create(RxRestService.class);
//        HashMap<String, Object> filedMap = new HashMap<String, Object>();
//        Observable<String> observable = rxRestService.get("",filedMap);
//        Log.d(getClass().getSimpleName(), "categories   observer是否为空 " + observable);
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                Log.d(getClass().getSimpleName(), "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(getClass().getSimpleName(), "onNext  获取的数据为" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(getClass().getSimpleName(), "onError");
            }

            @Override
            public void onComplete() {
                Log.d(getClass().getSimpleName(), "onComplete");
            }
        };
//
//        observable
//                .subscribeOn(Schedulers.io())//指定被观察者执行的线程
//                .observeOn(AndroidSchedulers.mainThread())//指定观察者执行的线程
////                .observeOn(Schedulers.io())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        Log.i(getClass().getSimpleName(), "accept " + s);
//                    }
//                });




        final RxRestService rxRestService;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//日志级别
            builder.addInterceptor(loggingInterceptor);
        OkHttpClient client = builder.build();
        final Retrofit rrr = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

//        rxRestService = RestServer.INSTANCE().getRetrofit().create(RxRestService.class);
        rxRestService =rrr.create(RxRestService.class);
        HashMap<String, Object> filedMap = new HashMap<String, Object>();
        try {
            rxRestService.get("", filedMap)
                    .subscribeOn(Schedulers.io())//指定被观察者执行的线程
                    .observeOn(AndroidSchedulers.mainThread())//指定观察者执行的线程
                    .subscribe(observer);
        }
        catch (Exception ex){
            Log.e(getClass().getSimpleName(),"categories  ex  "+ex.getMessage());
        }

        return disposable;
    }

    @Override
    public void start() {

    }
}
