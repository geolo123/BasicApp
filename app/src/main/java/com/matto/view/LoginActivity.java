package com.matto.view;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.common.ui.BaseActivity;
import com.matto.R;
import com.matto.app.LogicProxy;
import com.matto.logic.LoginLogic;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */
public class LoginActivity extends BaseActivity implements LoginLogic.LoginView {

    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.passwrod)
    EditText passwrod;
    @Bind(R.id.login)
    Button login;

    LoginLogic mLoginLogic;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitData() {
        mLoginLogic = LogicProxy.getInstance().getBindViewProxy(LoginLogic.class, this);
    }

    @OnClick(R.id.login)
    void login() {
        mLoginLogic.login("zhangsan", "12344");
    }

    @Override
    public void onLoginSuccess() {
        Log.d("cs", "成功222wdwadwadwadwa2");
    }

    @Override
    public void onLoginFail() {
        Log.d("cs", "登wdadwadwadwaddwa2");
    }
}
