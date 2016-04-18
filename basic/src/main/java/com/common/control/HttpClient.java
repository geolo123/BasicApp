package com.common.control;

import com.common.Constant;
import com.common.EasyApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class HttpClient {

    private static HttpClient mInstance;
    private Retrofit retrofit;

    public static HttpClient getIns() {
        if (mInstance == null) {
            synchronized (HttpClient.class) {
                if (mInstance == null) mInstance = new HttpClient();
            }
        }
        return mInstance;
    }

    public HttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File cacheFile = new File(EasyApplication.getInstance().getCacheDir(), "android");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .connectTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .cache(cache)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(EasyApplication.getInstance().gson))
                .client(okHttpClient)
                .build();
    }

    public <T> T createService(Class<T> clz) {
        return retrofit.create(clz);
    }
}
