package com.easy.api;

import com.common.api.HttpClientApi;
import com.easy.pojo.Gank;

import retrofit.Call;

/**
 * author miekoz on 2016/3/21.
 * email  meikoz@126.com
 */
public class ServiceFactory {

    private static MainService mService;

    public static MainService getMainIns(){
        if (mService == null){
            mService = HttpClientApi.getIns().createService(MainService.class);
        }
        return mService;
    }

    public Call<Gank> getBenefitsGoods(int size, int page){
       return mService.getMainAndroid(size,page);
    }

}
