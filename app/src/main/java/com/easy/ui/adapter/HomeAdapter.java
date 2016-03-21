package com.easy.ui.adapter;

import android.content.Context;

import com.common.comm.CommonAdapter;
import com.common.comm.ViewHolder;
import com.easy.R;
import com.easy.pojo.Goods;

import java.util.List;

/**
 * author miekoz on 2016/3/18.
 * email  meikoz@126.com
 */
public class HomeAdapter extends CommonAdapter<Goods> {
    public HomeAdapter(Context context, List<Goods> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, Goods item) {
        helper.setText(R.id.tv_test,item.desc);
    }
}
