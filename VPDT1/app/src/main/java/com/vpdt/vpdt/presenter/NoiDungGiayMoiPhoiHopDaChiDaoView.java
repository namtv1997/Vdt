package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NoiDungGiayMoiPhoiHopDaChiDaoView extends BaseView<NoiDungGiayMoiPhoiHopDaChiDaoPresenter> {
    Context gContext();

    void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onDuyetSuccess();

    void onTuChoiSuccess();
}
