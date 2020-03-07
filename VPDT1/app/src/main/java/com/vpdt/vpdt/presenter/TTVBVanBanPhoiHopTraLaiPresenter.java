package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBVanBanPhoiHopTraLaiPresenter extends BasePresenter {
    void getDetailVBChuyenVienXuLy(int id);

    void hoanThanhVBChuyenVienXuLy(int id, String ketQua);

    void xoaKQPhongTL(String id);
}
