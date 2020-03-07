package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailGiayMoiPhongChuTriChoXuLy;

public interface TTVBGiayMoiPhongChuTriChoXuLyView extends BaseView<TTVBGiayMoiPhongChuTriChoXuLyPresenter> {
    Context gContext();

    void onGetDaTaSuccess(DetailGiayMoiPhongChuTriChoXuLy detailGiayMoiPhongChuTriChoXuLy);

    void hoanThanhGMChuyenVienChuTriXuLySuccess();

    void xoaKQPhongTLSuccess();
}
