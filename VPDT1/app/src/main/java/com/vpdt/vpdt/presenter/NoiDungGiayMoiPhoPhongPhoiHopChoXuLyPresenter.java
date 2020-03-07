package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungGiayMoiPhoPhongPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetGMPhoPhongPhoiHopChoXuLy(int id, int idPhoPhong, int idPhoiHop, String idChuyenVienPhoiHops, String chiDaoChuTri, String hanXuLy);
}
