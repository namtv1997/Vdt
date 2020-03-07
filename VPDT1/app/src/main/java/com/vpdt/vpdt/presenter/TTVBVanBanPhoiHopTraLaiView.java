package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanPhoiHopTraLai;

public interface TTVBVanBanPhoiHopTraLaiView extends BaseView<TTVBVanBanPhoiHopTraLaiPresenter> {
    Context gContext();

    void onGetDaTaSuccess(DetailVanBanPhoiHopTraLai detailVanBanPhoiHopTraLai);

    void hoanThanhVBChuyenVienXuLySuccess();

    void xoaKQPhongTLSuccess();
}
