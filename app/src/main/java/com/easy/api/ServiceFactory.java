package com.easy.api;

import com.common.api.RestPool;
import com.easy.pojo.Gank;

import retrofit2.Call;


/**
 * author miekoz on 2016/3/21.
 * email  meikoz@126.com
 */
public class ServiceFactory {

    private static ApiService mService;

    public static ApiService getMainIns(){
        if (mService == null){
            mService = RestPool.getIns().createService(ApiService.class);
        }
        return mService;
    }

    public Call<Gank> getBenefitsGoods(int size, int page){
       return mService.getMainAndroid(size,page);
    }

}
