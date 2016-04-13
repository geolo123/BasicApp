package com.easy.ui.adapter;

import android.content.Context;

import com.common.basic.CommonAdapter;
import com.common.basic.ViewHolder;
import com.easy.R;
import com.easy.model.GankDetails;

import java.util.List;

/**
 * author miekoz on 2016/3/18.
 * email  meikoz@126.com
 */
public class MainAdapter extends CommonAdapter<GankDetails> {
    public MainAdapter(Context context, List<GankDetails> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, GankDetails item) {
        helper.setText(R.id.tv_test,item.desc);
    }
}
