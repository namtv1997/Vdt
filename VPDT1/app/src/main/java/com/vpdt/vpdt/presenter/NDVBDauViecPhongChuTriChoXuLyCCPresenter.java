package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDauViecPhongChuTriChoXuLyCCPresenter extends BasePresenter {
    void getAllPhongBanChiCuc();

    void duyetDauViecPhongChuTriChoXuLyCC(String nam, int id, int idPhongBan, String tenPhongBan, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy);

    void duyetDauViecPhongChuTriDaXuLyCC(String nam, int id, int idPhongBan, String tenPhongBan, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy);

    void duyetDauViecPhongPhoHopChoXuLyCC(String nam, int id, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy);

    void duyetDauViecPhongPhoHopDaXuLyCC(String nam, int id, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy);
}
