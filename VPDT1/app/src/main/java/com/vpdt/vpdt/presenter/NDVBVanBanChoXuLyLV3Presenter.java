package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanChoXuLyLV3Presenter extends BasePresenter {
    void getAllPhoPhongDonViCapHai(String nam);

    void getAllChuyenVienDonViCapHai(String nam);

    void duyetVBChoXuLyTPChuTriDonViCapHai(String nam, int id, int idPhoPhong, String chiDaoPhoPhong, String idPhoPhongPhoiHops,
                                           String chiDaoPhoPhongPhoiHops, int idChuyenVien, String chiDaoChuyenVien,
                                           String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy);

    void duyetVBChoXuLyTPPhoiHopDonViCapHai(String nam, int id, int idPhoPhong, String chiDaoPhoPhong, String idPhoPhongPhoiHops,
                                            String chiDaoPhoPhongPhoiHops, int idChuyenVien, String chiDaoChuyenVien,
                                            String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy);


}
