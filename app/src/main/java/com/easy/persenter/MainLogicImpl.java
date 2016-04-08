package com.easy.persenter;

import com.easy.api.ServiceFactory;
import com.easy.persenter.core.BasePresenter;
import com.easy.pojo.GankDetails;
import com.easy.pojo.Gank;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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
            public void onResponse(Response<Gank> response, Retrofit retrofit) {
                List<GankDetails> results = response.body().getResults();
                if (MainLogicImpl.this.getMvpView() != null)
                    MainLogicImpl.this.getMvpView().getMainAndroid(results,true);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}
