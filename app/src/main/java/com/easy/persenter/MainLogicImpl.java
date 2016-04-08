package com.easy.persenter;

import com.easy.persenter.core.BasePresenter;
import com.easy.pojo.Gank;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author meikoz on 2016/3/25.
 * email  meikoz@126.com
 */
public class MainLogicImpl extends BasePresenter<MainLogic>{

    public MainLogicImpl(){

    }

    public void getData(){
        Call<Gank> call = mMainService.getMainAndroid(10,1);
        call.enqueue(new Callback<Gank>() {
            @Override
            public void onResponse(Call<Gank> call, Response<Gank> response) {

            }

            @Override
            public void onFailure(Call<Gank> call, Throwable t) {

            }
        });
    }

}
