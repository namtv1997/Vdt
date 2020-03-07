package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungGiayMoiPhoiHopDaChiDaoPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetGMGiaoPhongPhoiHopDaChiDao(int id, int idPhoPhong, String idPhoPhongPhoiHops, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet);

    void tuChoiGMPhoiHopDaChiDao(int idPhoiHop, String noiDungTuChoi);
}
