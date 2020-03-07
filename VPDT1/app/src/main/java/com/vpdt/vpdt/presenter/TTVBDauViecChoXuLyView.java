package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailDauViec1;

public interface TTVBDauViecChoXuLyView extends BaseView<TTVBDauViecChoXuLyPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailDauViec1 detailDauViec);

    void onHoanThanhSuccess();
}
