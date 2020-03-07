package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface VanBanGiaoPhongPhoiHopChoXuLyView extends BaseView<VanBanGiaoPhongPhoiHopChoXuLyPresenter> {
    Context gContext();

    void onGetDataSuccess();

    void onGetCountVBSuccess(Response<Integer> response);
}
