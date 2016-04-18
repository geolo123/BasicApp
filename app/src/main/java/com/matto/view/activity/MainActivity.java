package com.matto.view.activity;

import android.os.Bundle;

import com.common.view.ui.BaseActivity;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitleBar("标题");
    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    protected void onInitView() {

    }
}
