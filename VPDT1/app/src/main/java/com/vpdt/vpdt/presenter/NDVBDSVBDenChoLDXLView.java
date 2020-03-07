package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.VanBanDenChoXuLy;

import java.util.ArrayList;

public interface NDVBDSVBDenChoLDXLView extends BaseView<NDVBDSVBDenChoLDXLPresenter> {
    Context gContext();

    void onGetDataSuccess(VanBanDenChoXuLy dsvb_daChiDao);

    void onGetGiamdocVaPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void onGetDuyetVanBandenchoxuly();

    void onchonDeLuuVanBanchoxuly();

    void onGetCongViecSuccess();

    void onGetThemNoiDungSuccess();

}
