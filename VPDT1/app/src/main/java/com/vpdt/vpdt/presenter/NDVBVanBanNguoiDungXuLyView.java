package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBVanBanNguoiDungXuLyView extends BaseView<NDVBVanBanNguoiDungXuLyPresenter> {
    Context gContext();

    void traLaiVBNguoiDungXuLySuccess();
}
