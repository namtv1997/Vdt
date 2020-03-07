package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_GiayMoiChoXuLyPresenter extends BasePresenter {
    void getAllTruongPhongChiCuc(String nam);

    void getAllChiCucPho(String nam);

    void duyetVBPhongChoXuLyCC(String nam, int id, int idChiCuc, int idChiCucPho, int idTruongPhong, String idTruongPhongPPs, String chiDaoChiCucPho, String chiDaoChuTri, String hanGiaiQuyet);

    void duyetGMDaXuLyCC(String nam, int id, int idChiCuc, int idChiCucPho, int idTruongPhong, String idTruongPhongPPs, String chiDaoChiCucPho, String chiDaoChuTri, String hanGiaiQuyet);

}
