package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface SoanBaoCaoPresenter extends BasePresenter {
    void getAllPhongBan();

    void getAllCanBoByIdPhongBan(int id);

    void createsoanbaocao(int id_vb, String ketluan, String dexuat, String chidao_phongchutri, String nguoinhans, String phongbans);
}
