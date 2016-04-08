package com.common;

import android.app.Application;
import android.util.Config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public class EasyApp extends Application{
    public Gson gson;
    private static EasyApp ourInstance = new EasyApp();
    public static EasyApp getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        this.initGson();

        LogLevel logLevel;
        if (Config.DEBUG)logLevel =LogLevel.FULL;
        else logLevel=LogLevel.NONE;

        Logger.init().methodOffset(2).methodCount(2).logLevel(logLevel);
    }

    private void initGson() {
        this.gson = new GsonBuilder()
                .setDateFormat(Constant.GANK_DATA_FORMAT)
                .create();
    }
}
