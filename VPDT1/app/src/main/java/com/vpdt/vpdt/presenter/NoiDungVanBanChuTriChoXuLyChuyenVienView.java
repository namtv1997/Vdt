package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NoiDungVanBanChuTriChoXuLyChuyenVienView extends BaseView<NoiDungVanBanChuTriChoXuLyChuyenVienPresenter> {
    Context gContext();

    void tuChoiVBChuTriChoXuLyCVSuccess();

    void themHanVBChuTriChoXuLySuccess();
}
