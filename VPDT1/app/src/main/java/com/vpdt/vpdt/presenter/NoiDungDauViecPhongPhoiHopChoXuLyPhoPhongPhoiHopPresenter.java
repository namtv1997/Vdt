package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungDauViecPhongPhoiHopChoXuLyPhoPhongPhoiHopPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetDauViecPhongPhoHopChoXuLyTPPP(int id, String idChuyenVienPhoiHops,
                                            String tenChuyenVienPhoiHops,
                                            String hanXuLy);
}
