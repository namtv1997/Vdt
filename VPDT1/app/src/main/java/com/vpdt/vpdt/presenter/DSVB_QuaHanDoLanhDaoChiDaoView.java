package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface DSVB_QuaHanDoLanhDaoChiDaoView extends BaseView<DSVB_QuaHanDoLanhDaoChiDao_Presenter> {
    Context gContext();

    void onGetCountVBSuccess(Response<Integer> response);

    void onGetListDanhBa();
}
