package com.matto.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.common.ui.BaseActivity;
import com.matto.R;
import com.common.control.LogicProxy;
import com.matto.logic.LoginLogic;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */
public class LoginActivity extends BaseActivity implements LoginLogic.LoginView {

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
    @Bind(R.id.edit_username) EditText mEditName;
    @Bind(R.id.edit_passwrod) EditText mEditPasswrod;
    LoginLogic mLoginLogic;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView() {
        mLoginLogic = LogicProxy.getInstance().getBindViewProxy(LoginLogic.class, this);
    }

    @OnClick(R.id.btn_login)
    void login() {
        mLoginLogic.login("zhangsan", "123");
    }

    @Override
    public void onLoginSuccess() {
        Log.d("cs", "登录成功");
    }

    @Override
    public void onLoginFail() {
        Log.d("cs", "登录失败");
    }
}
