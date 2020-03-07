package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBGiayMoiLanhDaoDaChiDaoPresenter extends BasePresenter {
    void getgiaymoilanhdaodachidaobyid(int id_giaymoi);

    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void duyetgiaymoilanhdaodaxuly(int id_giaymoi, int id_giamdoc, int id_phogiamdoc, int id_phongchutri,
                                   String id_phong_phoihops, String chidao_phogiamdoc, String chidao_giamdoc,
                                   String chidao_phongchutri, boolean giamdoc_duhop,
                                   boolean phong_duhop, String han_giai_quyet, boolean is_vbquantrong);
}
