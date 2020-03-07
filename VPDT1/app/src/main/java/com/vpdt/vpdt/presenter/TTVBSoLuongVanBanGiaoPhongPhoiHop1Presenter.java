package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBSoLuongVanBanGiaoPhongPhoiHop1Presenter extends BasePresenter {
    void getDetailGMChuyenVienXuLy(int id);

    void hoanThanhGMChuyenVienXuLy(int id, String ketQua, String tenFileKetQua);

    void xoaKQPhongTL(String id);
}
