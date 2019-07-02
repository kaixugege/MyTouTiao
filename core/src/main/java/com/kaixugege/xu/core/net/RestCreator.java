package com.kaixugege.xu.core.net;

import android.arch.lifecycle.ViewModelProvider;

import com.kaixugege.xu.core.app.ConfigType;
import com.kaixugege.xu.core.app.Configurator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class RestCreator {

    private static final class ParamsHolder {
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();//配置
    }

    //这里是线程安全的单例模式，调用这个函数之后才会执行 new
    public static WeakHashMap<String, Object> getParans() {
        return ParamsHolder.PARAMS;
    }
    public static final class RetrofitHodle {
        private static final String BASE_URL = (String) Configurator.INSTANCE.getConfigs().get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .client(new OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static final class RestServiceHolder {
        public static final RxRestService REST_SERVICE = RetrofitHodle.RETROFIT_CLIENT.create(RxRestService.class);
    }

    private static final class OKHttpHolder {

        private static final int TIME_OUT = 60;
        private static OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();
//        private static final ArrayList<Interceptor> INTERCEPTORS = Configurator.getConfigurations(ConfigType.INTERCEPTOR.name());

        private static final OkHttpClient OK_HTTP_CLIENT = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

        private static OkHttpClient.Builder addInterceptor() {
//            if (INTERCEPTORS != null && !INTERCEPTORS.isEmpty()) {
//                for (Interceptor interceptor : INTERCEPTORS) {
//                    BUILDER.addInterceptor(interceptor);
//                }
//            }
            return BUILDER;
        }
    }



}
