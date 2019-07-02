package com.kaixugege.xu.core.net;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class RxRestClientBuilder {
    public static Map<String, Object> mPARAMS = RestCreator.getParans();

    public RxRestClientBuilder url(String mUrl) {
        this.mUrl = mUrl;
        return this;
    }

    public RxRestClientBuilder body(RequestBody mBODY) {
        this.mBODY = mBODY;
        return this;
    }

    public RxRestClientBuilder context(Context mContext) {
        this.mContext = mContext;
        return this;
    }

    public RxRestClientBuilder checkParans() {
        if (mPARAMS == null) {
            mPARAMS = new WeakHashMap<>();
        }
        return this;
    }

    public RxRestClientBuilder file(File mFile) {
        this.mFile = mFile;
        return this;
    }

    public RxRestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RxRestClientBuilder raw(String raw) {
        this.mBODY = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), raw);
        return this;
    }

    private String mUrl = null;
    private RequestBody mBODY = null;
    private Context mContext = null;
    private File mFile = null;

    public final RestClient build() {
        return new RestClient(mUrl, mBODY, mContext, mFile);
    }
}
