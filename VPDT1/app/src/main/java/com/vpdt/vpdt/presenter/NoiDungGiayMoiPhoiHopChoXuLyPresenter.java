package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungGiayMoiPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetGMPhongPhoiHopChoXuLy(int id, int idPhoPhong, String idPhoPhongPhoiHops, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet);

    void tuChoiGMPhoiHopChoXuLy(int idPhoiHop, String noiDungTuChoi);
}
