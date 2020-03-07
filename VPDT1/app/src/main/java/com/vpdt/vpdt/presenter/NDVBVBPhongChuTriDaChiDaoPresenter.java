package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVBPhongChuTriDaChiDaoPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetVBPhongChuTriDaChiDao(int id, int idPhoPhong, String idPhoPhongPhoiHops, int idChuyenVien, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String vanBanDauRaTruongPhong, boolean vanBanQuanTrong,
                                    boolean phoGiamDocDonDoc, String hanGiaiQuyet);
}
