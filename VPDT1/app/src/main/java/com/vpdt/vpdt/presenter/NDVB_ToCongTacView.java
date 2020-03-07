package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.NDVB_ToCongTac;

public interface NDVB_ToCongTacView extends BaseView<NDVB_ToCongTac_Presenter> {
    Context gContext();

    void onGetDataSuccess(NDVB_ToCongTac ndvb_toCongTac);
}
