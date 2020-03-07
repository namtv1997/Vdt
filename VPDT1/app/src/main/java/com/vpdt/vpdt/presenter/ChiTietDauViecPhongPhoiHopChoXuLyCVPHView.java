package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailDauViecPhongCT;

public interface ChiTietDauViecPhongPhoiHopChoXuLyCVPHView extends BaseView<ChiTietDauViecPhongPhoiHopChoXuLyCVPHPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailDauViecPhongCT detailDauViecPhongCT);

    void onHoanThanhSuccess();
}
