package com.common.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.common.R;

import butterknife.ButterKnife;

/**
 * author meikoz on 2016/3/30.
 * email  meikoz@126.com
 */
public abstract class BaseActivity extends FragmentActivity {

    protected EasyToolBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutResource());
        ButterKnife.bind(this);
        this.onInitData();
    }

    protected abstract int getLayoutResource();

    protected abstract void onInitData();

    protected void initTitleBar(String title) {
        findTitleBar();
        mTitleBar.setTitle(title);
    }

    private void findTitleBar() {
        mTitleBar = (EasyToolBar) findViewById(R.id.toolbar);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
