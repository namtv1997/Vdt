package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NoiDungDauViecPhongChuTriChuyenVienChoXuLyView extends BaseView<NoiDungDauViecPhongChuTriChuyenVienChoXuLyPresenter> {
    Context gContext();

    void deXuatGiaHanDauViecPhongChuTriChoXuLyCVSuccess();
}
