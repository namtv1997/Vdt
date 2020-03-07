package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVB_DeXuatCongViecPhoiHopChoDuyetPresenter extends BasePresenter {
    void getDetailVBChuyenVienChuTriXuLy(int id);

    void xoaKQPhongTL(String id);

    void luuketqua(int id_vb, String ketqua, int luuvaokho, String chammuon, int hoanthanh);
}
