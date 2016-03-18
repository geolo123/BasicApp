package com.common.api;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * author miekoz on 2016/3/18.
 * email  meikoz@126.com
 *
 * 自定义Callback 用户服务器返回数据统一处理
 */
public abstract class GsonCallback<T> implements Callback{
    @Override
    public void onResponse(Response response, Retrofit retrofit) {
        onSuccess(response);
    }

    @Override
    public void onFailure(Throwable t) {
        onFail(t);
    }

    protected abstract void onSuccess(Response<T> response);

    protected abstract void onFail(Throwable t);
}
