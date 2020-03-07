package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailDeXuatCongViecPhoiHopChoDuyet;

public interface TTVB_DeXuatCongViecPhoiHopChoDuyetView extends BaseView<TTVB_DeXuatCongViecPhoiHopChoDuyetPresenter> {
    Context gContext();

    void onGetDaTaSuccess(DetailDeXuatCongViecPhoiHopChoDuyet detailDeXuatCongViecPhoiHopChoDuyet);

    void xoaKQPhongTLSuccess();

    void onGetCongViecSuccess();
}
