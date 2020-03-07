package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanChoXuLyLV4Presenter extends BasePresenter {
    void getAllChuyenVienDonViCapHai(String nam);

    void duyetVBChoXuLyPPChuTriDonViCapHai(String nam, int id, int idChuyenVien, String chiDaoChuyenVien,
                                           String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy);

    void duyetVBChoXuLyPPhoiHopDonViCapHai(String nam, int id, int idChuyenVien, String chiDaoChuyenVien,
                                           String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy);

    void duyetVBPhoiHopChoXuLyDonViCapHai(String nam, int id, int CT_PH,
                                          String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy);

}
