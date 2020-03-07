package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.NDVB_QuanTrong;

public interface NDVB_QuanTrongView extends BaseView<NDVB_QuanTrong_Presenter> {
    Context gContext();

    void onGetDataSuccess(NDVB_QuanTrong ndvb_quanTrong);

    void onGetBoQuanTrongSuccess();
}
