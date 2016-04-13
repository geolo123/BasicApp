package com.easy.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.common.control.ToastTip;
import com.common.ui.BaseActivity;
import com.easy.R;
import com.easy.app.LogicProxy;
import com.easy.persenter.LoginLogic;
import com.easy.persenter.LoginLogicImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author meikoz on 2016/4/13.
 * email  meikoz@126.com
 */
public class LoginActivity extends BaseActivity implements LoginView {

    LogicProxy mLogicProxy = LogicProxy.getInstance();

    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.passwrod)
    EditText passwrod;
    @Bind(R.id.login)
    Button login;
    private LoginLogic logic;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitData() {
        logic = mLogicProxy.getProxy();
//        Log.d("cs", logic + "");
        logic.attachView(this);
    }

    @OnClick(R.id.login)
    void login() {
        logic.login("zhangsan", "12344");
    }

    @Override
    public void onLoginSuccess() {
        Log.d("cs", "成功222wdwadwadwadwa2");
//        ToastTip.show("登录成功");
    }

    @Override
    public void onLoginFail() {
        Log.d("cs", "登wdadwadwadwaddwa2");
//        ToastTip.show("登录失败");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
