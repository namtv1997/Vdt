package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBSoLuongVanBanGiaoPhongChuTriView extends BaseView<NDVBSoLuongVanBanGiaoPhongChuTriPresenter> {
    Context gContext();

    void tuChoiVBGiaoPhongChuTriSuccess();

    void tuChoiVBGiaoPhongChuTriTruongPhongSuccess();

    void themHanVBPhongChuTriChoXuLy();
}
