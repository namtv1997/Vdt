package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface ThongKeVanBanView extends BaseView<ThongKeVanBanPresenter> {
    Context gContext();

    void onGetDataSuccess();
}
