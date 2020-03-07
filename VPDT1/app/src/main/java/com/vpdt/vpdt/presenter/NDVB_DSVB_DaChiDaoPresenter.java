package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_DSVB_DaChiDaoPresenter extends BasePresenter {
    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void getbyidvblanhdaodachidao(int id_vb);

    void getbyidvbstcphoihopdachidao(int id_vb);

    void duyetvbdenLanhdaodachidao(int id_vb, int id_phogiamdoc, int id_phongchutri,
                                   String id_phong_phoihops, String chidao_phogiamdoc,
                                   String chidao_phongchutri, boolean phogiamdocthammuu,
                                   String han_giai_quyet, boolean is_vbquantrong);

    void duyetvbstcphoihopdachidao(int id_vb, int id_phogiamdoc, int id_phongchutri,
                                   String id_phong_phoihops, String chidao_phogiamdoc,
                                   String chidao_phongchutri, boolean phogiamdocthammuu,
                                   String han_giai_quyet, boolean is_vbquantrong);

    void luuketqua(int id_vb, String ketqua, int luuvaokho, String chammuon, int hoanthanh);

}