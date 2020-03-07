package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBGiayMoiGiaoPhongChuTriDaHoanThanhPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetGMGiaoPhongChuTriDaHoanThanh(int id, int idPhoPhong, String idPhoPhongPhoiHops, int idChuyenVien, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet);
}
