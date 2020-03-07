package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDauViecPhongChuTriChoXuLyPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetDauViecPhongChuTriChoXuLy(int id, int idPhoPhong, String tenPhoPhong,
                                        String idPhoPhongPhoiHops,
                                        String tenPhoPhongPhoiHops,
                                        int idChuyenVien,
                                        String tenChuyenVien,
                                        String idChuyenVienPhoiHops,
                                        String tenChuyenVienPhoiHops,
                                        String hanXuLy);
}
