package com.easy;

import com.common.api.RestApi;
import com.common.ui.EasyBaseActivity;

import retrofit.Call;
import retrofit.Response;

public class MainActivity extends EasyBaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitData() {
        final Call<Repo> call = RestApi.createService(UserService.class).getData("福利", 10, 1);
        call.enqueue(new Back() {

            @Override
            protected void onSuccess(Response body) {
            }
        });
    }

}
