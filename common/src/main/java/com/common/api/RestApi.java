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
public class RestApi {
    public RestApi(){

    }

    public static <T> T createService(Class<T> clz){

        //okhttp
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(7676, TimeUnit.MILLISECONDS);

        //log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(EasyApp.getInstance().gson))
                .client(okHttpClient)
                .build();
        return retrofit.create(clz);

    }
}
