package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBGiayMoiGiaoPhongChuTriDaChiDaoPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetGMGiaoPhongChuTriDaChiDao(int id, int idPhoPhong, String idPhoPhongPhoiHops, int idChuyenVien, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, boolean vanBanQuanTrong, String hanGiaiQuyet);
}
