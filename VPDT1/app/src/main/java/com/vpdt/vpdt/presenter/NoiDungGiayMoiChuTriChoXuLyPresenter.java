package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungGiayMoiChuTriChoXuLyPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetGMChuTriChoXuLy(int id, int idChuyenVien, String idChuyenVienPhoiHops, String chiDaoChuTri, String hanXuLy);

    void tuChoiGMChuTriChoXuLy(int id, String noiDungTuChoi, String ghiChu);
}
