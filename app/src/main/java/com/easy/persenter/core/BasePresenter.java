package com.easy.persenter.core;

import com.easy.net.ApiService;
import com.easy.net.ServiceFactory;

/**
 * author meikoz on 2016/3/25.
 * email  meikoz@126.com
 */
public class BasePresenter<T extends MvpView> implements Presenter<T>{

    private T mMvpView;
    public ApiService mMainService;

    @Override
    public void attachView(T mvpView) {
        this.mMvpView = mvpView;
        this.mMainService = ServiceFactory.getMainIns();
    }

    @Override
    public void detachView() {
        this.mMvpView = null;
    }

    public boolean isViewAttached(){
        return  mMvpView != null;
    }

    public  T getMvpView(){
        return mMvpView;
    }

    public void checkViewAttached(){
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
