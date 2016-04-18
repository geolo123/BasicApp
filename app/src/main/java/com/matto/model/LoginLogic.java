package com.matto.model;

import com.common.model.control.LogicControl;
import com.common.model.annotation.Implement;


/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */

@Implement(LoginLogicImpl.class)
public interface LoginLogic extends LogicControl<LoginLogic.LoginView> {

    interface LoginView {
        void onLoginSuccess();

        void onLoginFail();
    }

    void login(String name, String passwrod);
}