package com.matto.model.http;

import com.common.model.http.HttpClient;
import com.matto.pojo.Gank;

import retrofit2.Call;


/**
 * author miekoz on 2016/3/21.
 * email  meikoz@126.com
 */
public class ServiceFactory {

    private static MainService mService;

    public static MainService getMainIns(){
        if (mService == null){
            mService = HttpClient.getIns().createService(MainService.class);
        }
        return mService;
    }

    public Call<Gank> getBenefitsGoods(int size, int page){
       return mService.getMainAndroid(size,page);
    }

}
