package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetVBPhongPhoiHopChoXuLy(int id, int idPhoPhong, String idPhoPhongPhoiHops, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet);

    void tuChoiVBPhoiHopChoXuLy(String idPhoiHop, String noiDungTuChoi);
}
