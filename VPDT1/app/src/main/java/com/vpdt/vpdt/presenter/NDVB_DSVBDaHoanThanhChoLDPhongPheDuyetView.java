package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetView extends BaseView<NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter> {
    Context gContext();

    void duyetVanBanSuccess();

    void tuChoiVBDaHoanThanhChoLDPhongPheDuyetSuccess();
}
