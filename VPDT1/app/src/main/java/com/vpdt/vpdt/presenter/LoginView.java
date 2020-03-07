package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface LoginView extends BaseView<LoginPresenter> {
    Context gContext();

    void onFailure(String s);

    void onLoginSuccess();
}
