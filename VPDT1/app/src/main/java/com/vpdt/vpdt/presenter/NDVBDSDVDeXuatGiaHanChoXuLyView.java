package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBDSDVDeXuatGiaHanChoXuLyView extends BaseView<NDVBDSDVDeXuatGiaHanChoXuLyPresenter> {
    Context gContext();

    void tuchoigiahan();

    void dongygiahan();

    void deXuatGiaHan();
}
