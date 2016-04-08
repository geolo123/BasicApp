package com.easy.view;

import android.widget.ListView;

import com.common.ui.BaseActivity;
import com.easy.R;
import com.easy.persenter.MainLogic;
import com.easy.persenter.MainLogicImpl;
import com.easy.model.GankDetails;
import com.easy.ui.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * author meikoz on 2016/3/25.
 * email  meikoz@126.com
 */
public class MainActivity extends BaseActivity implements MainLogic {

    @Bind(R.id.lv_main)
    ListView mainLv;
    private List<GankDetails> androids = new ArrayList<>();
    private MainAdapter adapter;
    private MainLogicImpl mainImpl;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitData() {
        this.mainImpl = new MainLogicImpl();
        this.mainImpl.attachView(this);
        this.adapter = new MainAdapter(this, androids, R.layout.item_home_list);
        mainLv.setAdapter(adapter);
        this.mainImpl.getData();
    }


    @Override
    public void onFailue(Throwable e) {

    }

    @Override
    public void getMainAndroid(List<GankDetails> list, boolean isRefresh) {
        if (!list.isEmpty())
            androids.addAll(list);
            adapter.notifyDataSetChanged();
    }

}
