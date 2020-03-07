package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetView extends BaseView<NDVBGiayMoiDaHoanThanhChoLanhDaoPheDuyetPresenter> {
    Context gContext();

    void duyetGMDaHoanThanhChoLDPheDuyetSuccess();

    void tuchoiGMDaHoanThanhChoLDPheDuyetSuccess();
}
