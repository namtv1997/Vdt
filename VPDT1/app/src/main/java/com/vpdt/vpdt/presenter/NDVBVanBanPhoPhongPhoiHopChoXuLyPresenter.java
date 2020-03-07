package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanPhoPhongPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllChuyenVien();

    void duyetVBPhoPhongPhoiHopChoXuLy(int id, int idPhoPhong, String idPhoiHop, String idChuyenVienPhoiHops,
                                       String chiDaoChuTri, String hanXuLy);
}
