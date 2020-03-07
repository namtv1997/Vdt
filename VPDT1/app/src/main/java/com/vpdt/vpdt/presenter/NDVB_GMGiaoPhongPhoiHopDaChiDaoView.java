package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVB_GMGiaoPhongPhoiHopDaChiDaoView extends BaseView<NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenter> {
    Context gContext();

    void onGetPhoPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onDuyetSuccess();
}
