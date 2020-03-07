package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanChoLanhDaoPhongPheDuyet;

public interface TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetView extends BaseView<TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter> {
    Context gContext();

    void onGetDaTaSuccess(DetailVanBanChoLanhDaoPhongPheDuyet detailVanBanChoLanhDaoPhongPheDuyet);

    void xoaKQPhongTLSuccess();
}
