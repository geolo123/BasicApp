package com.easy.api;

import com.common.api.RestApi;
import com.easy.pojo.GoodsRepo;

import retrofit.Call;

/**
 * author miekoz on 2016/3/21.
 * email  meikoz@126.com
 */
public class ServiceFactory {

    private static MainService mService;

    public static MainService getMainIns(){
        if (mService == null){
            mService = RestApi.getIns().createService(MainService.class);
        }
        return mService;
    }

    public Call<GoodsRepo> getBenefitsGoods(int size, int page){
       return mService.getBenefitsGoods(size,page);
    }

}
