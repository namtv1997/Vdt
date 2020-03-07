package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface GMGiaoPhongPhoiHopDaChiDaoView extends BaseView<GMGiaoPhongPhoiHopDaChiDaoPresenter> {
    Context gContext();

    void onGetDataSuccess();

    void onGetCountVBSuccess(Response<Integer> response);

}
