package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NoiDungDauViecHoanThanhBiTraLaiView extends BaseView<NoiDungDauViecHoanThanhBiTraLaiPresenter> {
    Context gContext();

    void duyetDauViecHoanThanhBiTraLai();

    void traLaiDauViecHoanThanhBiTraLai();
}
