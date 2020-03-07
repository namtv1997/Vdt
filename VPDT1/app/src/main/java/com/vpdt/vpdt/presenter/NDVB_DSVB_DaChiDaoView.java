package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface NDVB_DSVB_DaChiDaoView extends BaseView<NDVB_DSVB_DaChiDaoPresenter> {
    Context gContext();

    void onGetDataSuccess(DSVB_DaChiDao dsvbDaChiDao);

    void onGetDataPhongSTCSuccess(DSVB_DaChiDao dsvbDaChiDao);

    void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void onGetDuyetVanBanLanhDaoDaChiDao();

    void onGetDuyetduyetvbstcphoihopdachidao();

    void onGetCongViecSuccess();
}
