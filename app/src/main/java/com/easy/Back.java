package com.easy;

import com.orhanobut.hawk.Hawk;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * author miekoz on 2016/3/17.
 * email  meikoz@126.com
 */
public abstract class Back implements Callback{
    @Override
    public void onResponse(Response response, Retrofit retrofit) {
        onSuccess(response);
    }

    @Override
    public void onFailure(Throwable t) {

    }
    protected abstract void onSuccess(Response body);
}
