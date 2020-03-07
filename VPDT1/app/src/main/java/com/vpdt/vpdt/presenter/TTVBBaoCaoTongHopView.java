package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailBaoCaoTongHop;

public interface TTVBBaoCaoTongHopView extends BaseView<TTVBBaoCaoTongHopPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailBaoCaoTongHop detailBaoCaoTongHop);
}
