package com.easy.ui;

import android.os.Bundle;

import com.common.ui.ReplaceActivity;


public class MainActivity extends ReplaceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitleBar("标题");
        replaceFragment(new HomeFragment());
    }
}
