package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanQuahan;

public interface TTVBDSVBQuaHanView extends BaseView<TTVBDSVBQuaHanPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailVanBanQuahan detailVanBanQuahan);
}
