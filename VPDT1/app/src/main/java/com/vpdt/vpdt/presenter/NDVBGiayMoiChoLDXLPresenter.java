package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBGiayMoiChoLDXLPresenter extends BasePresenter {
    void getgiaymoicholanhdaoxulybyid(int id_giaymoi);

    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void duyetgiaymoicholanhdaoxuly(int id_giaymoi, int id_phogiamdoc, int id_phongchutri,
                                    String id_phong_phoihops, String chidao_phogiamdoc,
                                    String chidao_phongchutri, boolean giamdoc_duhop,
                                    boolean phong_duhop, String han_giai_quyet, boolean is_vbquantrong);
}
