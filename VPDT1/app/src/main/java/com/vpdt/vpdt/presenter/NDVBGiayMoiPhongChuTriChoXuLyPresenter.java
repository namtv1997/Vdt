package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBGiayMoiPhongChuTriChoXuLyPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetGMPhongChuTriChoXuLy(int id, int idPhoPhong, String idPhoPhongPhoiHops, int idChuyenVien, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, String hanGiaiQuyet);

    void tuChoiGMPhongChuTriChoXuLy(int id, String noiDungTuChoi, String ghiChu);

}
