package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface ClickVanBanThongKeVBTheoLDCDView extends BaseView<ClickVanBanThongKeVBTheoLDCDPresenter> {
    Context gContext();

    void onGetDataSuccess();
}
