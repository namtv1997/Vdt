package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungDauViecPhongPhoiHopDaXuLyPhoPhongPhoiHopPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetDauViecPhongPhoHopDaChiDaoTPPH(int id, String idChuyenVienPhoiHops,
                                             String tenChuyenVienPhoiHops,
                                             String hanXuLy);
}
