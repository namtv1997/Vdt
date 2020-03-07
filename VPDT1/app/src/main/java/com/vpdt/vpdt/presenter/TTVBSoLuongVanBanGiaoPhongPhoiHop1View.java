package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanPhoiHopTraLai;

public interface TTVBSoLuongVanBanGiaoPhongPhoiHop1View extends BaseView<TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter> {
    Context gContext();

    void onGetDaTaSuccess(DetailVanBanPhoiHopTraLai detailVanBanPhoiHopTraLai);

    void hoanThanhGMChuyenVienXuLySuccess();

    void xoaKQPhongTLSuccess();
}
