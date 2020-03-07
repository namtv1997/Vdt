package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBVanBanCongTacDangChoXuLyPresenter extends BasePresenter {
    void luuketqua(int id_vb, String ketqua, int luuvaokho, String chammuon, int hoanthanh);

    void getDetailVBChuyenVienChuTriXuLy(int id);

    void xoaKQPhongTL(String id);
}
