package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVB_VBGiaoPhongPhoiHopXuLyPresenter extends BasePresenter {
    void getVBPhongPhoiHopChoXuLyById(int id);

    void hoanThanhVBPhongPhoiHopChoXuLy(int id, String ketQua);

    void xoaKQPhongTL(String id);
}
