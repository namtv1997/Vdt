package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface NDVBGiayMoiLanhDaoDaChiDaoView extends BaseView<NDVBGiayMoiLanhDaoDaChiDaoPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailGiayMoi detailGiayMoi);

    void onGetGiamdoccSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void onGetDuyetGiayMoiLanhDaoDaChiDao();
}
