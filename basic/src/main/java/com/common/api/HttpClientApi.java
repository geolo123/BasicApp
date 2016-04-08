package com.common.api;

import com.common.Constant;
import com.common.EasyApp;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class HttpClientApi {

    private static HttpClientApi mInstance;
    private Retrofit retrofit;

    public static HttpClientApi getIns(){
        if (mInstance == null){
            synchronized (HttpClientApi.class){
                if (mInstance == null) mInstance = new HttpClientApi();
            }
        }
        return mInstance;
    }

    public HttpClientApi(){

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(7676, TimeUnit.MILLISECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(EasyApp.getInstance().gson))
                .client(okHttpClient)
                .build();
    }

    public  <T> T createService(Class<T> clz){
        return retrofit.create(clz);
    }
}
