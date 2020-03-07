package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanChoChiDaoPresenter extends BasePresenter {
    void getAllTruongPhongDonViCapHai(String nam);

    void getAllPhongBanDonViCapHai(String nam);

    void duyetVBChoChiDaoDonViCapHai(String nam, int id, int idLanhDao, String tenLanhDao, int idPhongChuTri,
                                     String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy);

    void duyetVBDaChiDaoPhongChuaXuLyDonViCapHai(String nam, int id, int idLanhDao, String tenLanhDao, int idPhongChuTri,
                                                 String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy);

    void duyetVBChoChiDaoDonViCapHaiPhong(String nam, int id, int idPhongChuTri, String tenPhongChuTri,
                                          String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy);

    void duyetVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String nam, int id, int idLanhDao, String tenLanhDao, int idPhongChuTri,
                                                      String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy);

}
