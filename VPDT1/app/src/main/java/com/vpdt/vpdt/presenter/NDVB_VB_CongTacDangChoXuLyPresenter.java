package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_VB_CongTacDangChoXuLyPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetVBCongTacDangChoXuLyPhong(int id, int idPhoPhong, String idPhoPhongPhoiHops, int idChuyenVien, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, boolean vanBanQuanTrong, boolean phoGiamDocDonDoc, String hanGiaiQuyet);

    void tuChoiVBCongTacDangChoXuLyPhong(int id, String noiDungTuChoi, String ghiChu);
}
