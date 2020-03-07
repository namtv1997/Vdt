package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_VanBanPhongChuTriChoXuLyPresenter extends BasePresenter {
    void getAllTruongPhongChiCuc(String nam);

    void getAllChiCucPho(String nam);

    void duyetVBPhongChuTriChoXuLyCC(String nam, int id, int idChiCuc, int idChiCucPho, int idTruongPhong, String idTruongPhongPPs, String chiDaoChiCucPho, String chiDaoChuTri, String hanGiaiQuyet);

    void tuChoiVBPhongChuTriChoXuLyCC(String nam, int id, String noiDungTuChoi, String ghiChu);
}
