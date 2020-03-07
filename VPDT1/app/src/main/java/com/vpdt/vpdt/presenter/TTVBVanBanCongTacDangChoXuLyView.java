package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailDeXuatCongViecPhoiHopChoDuyet;

public interface TTVBVanBanCongTacDangChoXuLyView extends BaseView<TTVBVanBanCongTacDangChoXuLyPresenter> {
    Context gContext();

    void onGetCongViecSuccess();

    void onGetDaTaSuccess(DetailDeXuatCongViecPhoiHopChoDuyet detailDeXuatCongViecPhoiHopChoDuyet);

    void xoaKQPhongTLSuccess();
}
