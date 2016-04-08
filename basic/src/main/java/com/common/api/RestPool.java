package com.common.api;

import com.common.Constant;
import com.common.EasyApp;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class RestPool {

    private static RestPool mInstance;
    private Retrofit retrofit;

    public static RestPool getIns(){
        if (mInstance == null){
            synchronized (RestPool.class){
                if (mInstance == null) mInstance = new RestPool();
            }
        }
        return mInstance;
    }

    public RestPool(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .connectTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .build();

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
