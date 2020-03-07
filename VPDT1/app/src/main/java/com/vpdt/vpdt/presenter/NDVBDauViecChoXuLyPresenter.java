package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDauViecChoXuLyPresenter extends BasePresenter {
    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void duyetdauviec(int id, int id_phogiamdoc, String noidung_pho_giam_doc, int id_phong_chu_tri, String phong_phoi_hops, String noidung_phoi_hop, String han_xu_ly);
}
