package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanPhoiHopDaChiDaoPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetVBPhongPhoiHopDaChiDao(int id, int idPhoPhong, String idPhoPhongPhoiHops, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet);

    void tuChoiVBPhoiHopDaChiDao(int idPhoiHop, String noiDungTuChoi);
}
