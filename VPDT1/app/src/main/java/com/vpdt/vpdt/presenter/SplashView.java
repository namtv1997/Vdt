package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface SplashView extends BaseView<SplashPresenter> {
    Context gContext();

    void onGetDataSuccess();

    void onGetDataFail();
}