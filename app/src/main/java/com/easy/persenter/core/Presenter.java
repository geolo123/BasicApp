package com.easy.persenter.core;

/**
 * author meikoz on 2016/3/25.
 * email  meikoz@126.com
 */
public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();

}
