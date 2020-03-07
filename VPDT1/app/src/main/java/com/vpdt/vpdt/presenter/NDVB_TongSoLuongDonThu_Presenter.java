package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_TongSoLuongDonThu_Presenter extends BasePresenter {
    void getbyiddonthukntc(int id_vb);

    void luuketqua(int id_vb, String ketqua, int luuvaokho, String chammuon, int hoanthanh);

    void xoaKQPhongTL(String id);
}
