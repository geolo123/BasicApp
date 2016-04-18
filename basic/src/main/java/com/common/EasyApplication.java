package com.common;

import android.app.Application;
import android.content.Context;

import com.common.control.manager.LocationManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class EasyApplication extends Application {
    public Gson gson;
    private static EasyApplication ourInstance = new EasyApplication();
    private static Context mContext;

    public static EasyApplication getInstance() {
        return ourInstance;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        mContext = getApplicationContext();
        this.initGson();

//        LogLevel logLevel;
//        if (Config.DEBUG)logLevel =LogLevel.FULL;
//        else logLevel=LogLevel.NONE;
//
//        Logger.init().methodOffset(2).methodCount(2).logLevel(logLevel);

        new LocationManager(this).doStartLocation();
    }

    private void initGson() {
        this.gson = new GsonBuilder()
                .setDateFormat(Constant.GANK_DATA_FORMAT)
                .create();
    }
}
