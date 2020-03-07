package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungVanBanGiaoPhongChoXuLyPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetVBPhongChuTriChoXuLy(int id, int idPhoPhong, String idPhoPhongPhoiHops, int idChuyenVien, String idChuyenVienPhoiHops, String chiDao, String chiDaoChuTri, boolean luuvanBan, boolean vanBanQuanTrong, boolean phoGiamDocDonDoc, String hanGiaiQuyet);

    void tuChoiVBPhongChuTriChoXuLy(int id, String noiDungTuChoi, String ghiChu);

    void tuChoiTPVBPhongChuTriChoXuLy(String nam, int id, String noiDungTuChoi, String ghiChu);

    void themHanVBPhongChuTriChoXuLy(int id, String hanDeXuat, String lyDo);
}
