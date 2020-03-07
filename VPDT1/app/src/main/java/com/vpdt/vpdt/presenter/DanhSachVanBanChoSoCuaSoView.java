package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface DanhSachVanBanChoSoCuaSoView extends BaseView<DanhSachVanBanChoSoCuaSoPresenter> {
    Context gContext();

    void ongetDSVB_ChoSo_CuaSoSuccess();

    void onGetCountVBSuccess(Response<Integer> response);
}
