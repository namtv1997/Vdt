package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBDeXuatCongViecPhoiHopChoDuyetView extends BaseView<NDVBDeXuatCongViecPhoiHopChoDuyetPresenter> {
    Context gContext();

    void guiLenDeXuatCV();

    void dongYDeXuatCV();

    void traLaiDeXuatCV();
}
