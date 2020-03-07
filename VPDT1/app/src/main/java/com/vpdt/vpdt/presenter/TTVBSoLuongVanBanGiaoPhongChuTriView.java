package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DeatailVanBanSoLuongVanBanPhongChuTri;

public interface TTVBSoLuongVanBanGiaoPhongChuTriView extends BaseView<TTVBSoLuongVanBanGiaoPhongChuTriPresenter> {
    Context gContext();

    void onGetDaTaSuccess(DeatailVanBanSoLuongVanBanPhongChuTri deatailVanBanSoLuongVanBanPhongChuTri);

    void xoaKQPhongTLSuccess();

}
