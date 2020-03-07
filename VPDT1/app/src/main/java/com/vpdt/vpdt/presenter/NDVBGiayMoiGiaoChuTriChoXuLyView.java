package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBGiayMoiGiaoChuTriChoXuLyView extends BaseView<NDVBGiayMoiGiaoChuTriChoXuLyPresenter> {
    Context gContext();

    void tuChoiGMChuTriChoXuLyCVSuccess();
}
