package com.easy.persenter;

import com.easy.app.annotation.Implement;


/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */

@Implement(LoginLogicImpl.class)
public interface LoginLogic<T> {

    void login(String name, String passwrod);
    void attachView(T mvpView);
}