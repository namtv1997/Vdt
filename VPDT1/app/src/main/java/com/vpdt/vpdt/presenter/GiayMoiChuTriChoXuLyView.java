package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface GiayMoiChuTriChoXuLyView extends BaseView<GiayMoiChuTriChoXuLyPresenter> {
    Context gContext();

    void onGetDataSuccess();

    void onGetCountVBSuccess(Response<Integer> response);
}
