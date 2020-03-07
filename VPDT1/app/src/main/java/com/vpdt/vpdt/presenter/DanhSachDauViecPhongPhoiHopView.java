package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface DanhSachDauViecPhongPhoiHopView extends BaseView<DanhSachDauViecPhongPhoiHopPresenter> {
    Context gContext();

    void onGetDataPhongPhoiHopSuccess();

    void onGetDataPhongChuTriSuccess();
}
