package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBDauViecHoanThanhChoLanhDaoPhongDuyetView extends BaseView<NDVBDauViecHoanThanhChoLanhDaoPhongDuyetPresenter> {
    Context gContext();

    void ontuChoiDauViecHoanThanhChoLDDuyetSuccess();

    void onduyetDauViecHoanThanhChoLDDuyetSuccess();
}
