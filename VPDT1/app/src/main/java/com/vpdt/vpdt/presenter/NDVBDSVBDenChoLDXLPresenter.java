package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDSVBDenChoLDXLPresenter extends BasePresenter {
    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void getbyidvbdenchoxuly(int id_vb);

    void chonDeLuuVanBan(int id_vb);

    void duyetvbdenchoxuly(int id_vb, int id_phogiamdoc, int id_phongchutri,
                           String id_phong_phoihops, String chidao_phogiamdoc,
                           String chidao_phongchutri, boolean phogiamdocthammuu,
                           String han_giai_quyet, boolean is_vbquantrong);

    void luuketqua(int id_vb, String ketqua, int luuvaokho, String chammuon, int hoanthanh);

    void themNoidungVBChuaPhanLoai(int id, String hanNoiDung, String noiDung, String nam);
}
