package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDauViecPhongChuTriChoXuLyTPCCPresenter extends BasePresenter {
    void getAlCVPhongBanCC(String nam);

    void getAllPhoPhongBanCC(String nam);

    void duyetDauViecPhongChuTriChoXuLyTPCC(String nam, int id, int idPhoPhong, String tenPhoPhong,
                                            String idPhoPhongPhoiHops, String tenPhoPhongPhoiHops,
                                            int idChuyenVien, String tenChuyenVien, String idChuyenVienPhoiHops,
                                            String tenChuyenVienPhoiHops, String hanXuLy);

    void duyetDauViecPhongPhoHopChoXuLyTPCC(String nam, int id,
                                            String idPhoPhongPhoiHops, String tenPhoPhongPhoiHops, String hanXuLy);

    void duyetDauViecTruongPhongPhoHopCT(String nam, int id, int idPhoPhong, String tenPhoPhong,
                                         String idPhoPhongPhoiHops, String tenPhoPhongPhoiHops,
                                         int idChuyenVien, String tenChuyenVien, String idChuyenVienPhoiHops,
                                         String tenChuyenVienPhoiHops, String hanXuLy);
}
