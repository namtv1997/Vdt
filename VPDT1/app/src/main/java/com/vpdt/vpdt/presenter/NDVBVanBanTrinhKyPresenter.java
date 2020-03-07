package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanTrinhKyPresenter extends BasePresenter {
    void getvanbanbyid(int id);

    void dongyvanban(int id_vb);

    void tralaivanban(int id_vb, String y_kien);
}
