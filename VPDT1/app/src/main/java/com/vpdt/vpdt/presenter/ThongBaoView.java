package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface ThongBaoView extends BaseView<ThongBaoPresenter> {
    Context gContext();

    void getAllThongBaoSuccess();

    void onGetCountVBSuccess(Response<Integer> response);

    void UpdateThongBaoSuccess();
}
