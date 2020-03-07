package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetDauViecPhongChuTriChoXuLyTPPP(int id, String idChuyenVienPhoiHops,
                                            String tenChuyenVienPhoiHops,
                                            String hanXuLy);
}
