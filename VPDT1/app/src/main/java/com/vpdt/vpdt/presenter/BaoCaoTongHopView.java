package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.BaoCaoTongHop;
import com.vpdt.vpdt.model.PhongBaoCaoTongHop;

import java.util.ArrayList;

public interface BaoCaoTongHopView extends BaseView<BaoCaoTongHopPresenter> {
    Context gContext();

    void onGetDaDaSuccess(ArrayList<BaoCaoTongHop> baoCaoTongHopArrayList);

    void onGetPhongBaoCaoTongHopSuccess(ArrayList<PhongBaoCaoTongHop> phongBaoCaoTongHops);
}
