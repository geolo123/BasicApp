package com.matto.ui.activity;

import android.os.Bundle;

import com.common.ui.BaseActivity;
import com.common.ui.ReplaceActivity;


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
