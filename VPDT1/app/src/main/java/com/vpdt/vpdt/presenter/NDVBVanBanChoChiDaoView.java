package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DSVB_DaChiDao;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface NDVBVanBanChoChiDaoView extends BaseView<NDVBVanBanChoChiDaoPresenter> {
    Context gContext();

    void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void onGetDuyetSuccess();
}
