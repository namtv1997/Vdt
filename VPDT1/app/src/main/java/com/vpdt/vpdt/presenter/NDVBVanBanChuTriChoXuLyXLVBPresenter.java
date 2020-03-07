package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanChuTriChoXuLyXLVBPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetVBChuTriChoXuLy(int id, int idChuyenVien, String idChuyenVienPhoiHops, String chiDaoChuTri, boolean luuvanBan, boolean phoGiamDocDonDoc, String hanXuLy);

    void tuChoiVBChuTriChoXuLy(int id, String noiDungTuChoi, String ghiChu);

    void themHanVBChuTriChoXuLy(int id, String hanDeXuat, String lyDo);
}
