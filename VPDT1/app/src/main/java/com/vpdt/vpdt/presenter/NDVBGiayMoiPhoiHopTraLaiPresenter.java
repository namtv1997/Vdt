package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBGiayMoiPhoiHopTraLaiPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetGMPhoiHopTraLai(int id, int idPhoPhong, String idPhoPhongPhoiHops, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet, int idCanBoTuchoi);
}
