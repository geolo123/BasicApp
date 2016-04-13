package com.matto.logic;

import android.util.Log;

/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */
public class LoginLogicImpl implements LoginLogic {

    LoginView mView;

    @Override
    public void login(String name, String passwrod) {
        if (!name.equals("zhangsan") || !passwrod.equals(123)) {
//            ToastTip.show("deng");
            Log.d("cs", "登录成功");
            mView.onLoginFail();
        } else {
            Log.d("cs", "登录成功2222");
//            ToastTip.show("2222");
//            mView.onLoginSuccess();
        }
    }

    @Override
    public void attachView(LoginView mvpView) {
        Log.d("cs", "拿到LoginView");
        this.mView = mvpView;
    }

//    @Override
//    public void attachView(LoginView mvpView) {
//        Log.d("cs", "拿到view");
//        this.mView = mvpView;
//    }
}
