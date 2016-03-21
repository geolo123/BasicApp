package com.easy.api;

import com.common.api.RestApi;
import com.easy.api.MainService;
import com.easy.pojo.GoodsRepo;

import retrofit.Call;
import rx.Observable;

/**
 * author miekoz on 2016/3/21.
 * email  meikoz@126.com
 */
public class ServiceFactory {

    /**每次加载条目*/
    public static final int LOAD_LIMIT = 20;
    /**加载起始页面*/
    public static final int LOAD_START = 1;

    private static MainService mService;

    public static MainService getIns(){
        if (mService == null){
            mService = RestApi.createService(MainService.class);
        }
        return mService;
    }

    public Call<GoodsRepo> getBenefitsGoods(int size, int page){
       return mService.getBenefitsGoods(size,page);
    }

}
