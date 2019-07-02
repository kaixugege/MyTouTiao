package com.kaixugege.xu.core.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public interface RestService {
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);


    @FormUrlEncoded
    @POST
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Call<String> putRaw(@Url String url, @Body RequestBody body);


    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    @Streaming //边下载边写入,不使用Streaming会直接下载到内存中去
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);//默认模式是一次性下载到内存里，下载完成后再统一写入文件， 文件过大时容易内存溢出

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
