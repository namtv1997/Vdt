package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailDauViecCuaSo;

public interface DanhSachDauViecCuaSoView extends BaseView<DanhSachDauViecCuaSoPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailDauViecCuaSo detailDauViecCuaSo);
}
