package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface DoiMatKhauView extends BaseView<DoiMatKhauPresenter> {
    Context gContext();

    void onFailure();

    void onSuccess();

    void onLogOutSuccess();
}
