package com.kaixugege.xu.core.net;

import android.content.Context;


import java.io.File;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class RestClient {
    private String Url;
    private RequestBody BODY;
    private Context Context;
    private File File;
    private static final Map<String, Object> PARAMS = RestCreator.getParans();

    public RestClient(String url, RequestBody body, Context context, File file) {
        Url = url;
        BODY = body;
        Context = context;
        File = file;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }

    private Observable<String> request(EHttpType method) {
        final RxRestService service = RestCreator.RestServiceHolder.REST_SERVICE;
        Observable<String> observable = null;
        switch (method) {

            case GET:
                observable = service.get(Url, PARAMS);
                break;

            case PUT:
                observable = service.put(Url, PARAMS);
                break;

            case POST:
                observable = service.post(Url, PARAMS);
                break;

            case DELETE:
                observable = service.delete(Url, PARAMS);
                break;

            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), File);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", File.getName(), requestBody);
                observable = service.upload(Url, body);
                break;

            default:
                break;

        }
        return observable;
    }

    public final Observable<String> get(){
        return request((EHttpType.GET));
    }

}
