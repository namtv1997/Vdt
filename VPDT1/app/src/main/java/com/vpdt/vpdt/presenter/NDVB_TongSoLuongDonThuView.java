package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.NDVB_DonThu;

public interface NDVB_TongSoLuongDonThuView extends BaseView<NDVB_TongSoLuongDonThu_Presenter> {
    Context gContext();

    void onGetDataSuccess(NDVB_DonThu ndvb_donThu);

    void onGetCongViecSuccess();

    void xoaKQPhongTLSuccess();
}
