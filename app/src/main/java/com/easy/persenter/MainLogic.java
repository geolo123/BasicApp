package com.easy.persenter;

import com.easy.app.annotation.Implement;
import com.easy.persenter.core.MvpView;
import com.easy.model.GankDetails;

import java.util.List;

/**
 * author meikoz on 2016/3/25.
 * email  meikoz@126.com
 */
@Implement(MainLogic.class)
public interface MainLogic extends MvpView {

    void getMainAndroid(List<GankDetails> list, boolean isRefresh);
}
