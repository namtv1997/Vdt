package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBThongTinMoiPresenter extends BasePresenter {
    void getdetailvanbanbyidThongTinNoiBo(int id_vb);

    void getAllPhongBan();

    void getAllCanBoByIdPhongBan(int id);
}
