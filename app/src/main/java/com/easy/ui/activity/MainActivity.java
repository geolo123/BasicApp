package com.easy.ui.activity;

import android.os.Bundle;

import com.common.ui.ReplaceActivity;
import com.easy.ui.fragment.HomeFragment;


public class MainActivity extends ReplaceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitleBar("标题");
        replaceFragment(new HomeFragment());
    }
}
