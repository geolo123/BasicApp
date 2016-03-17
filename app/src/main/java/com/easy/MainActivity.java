package com.easy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.common.api.RestApi;
import com.common.ui.EasyBaseActivity;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends EasyBaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitData() {
        final Call<Repo> call = RestApi.createService(UserService.class).getData("福利", 10, 1);
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Response<Repo> response, Retrofit retrofit) {
                Toast.makeText(getApplicationContext(),response.body().toString(),1).show();
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }

}
