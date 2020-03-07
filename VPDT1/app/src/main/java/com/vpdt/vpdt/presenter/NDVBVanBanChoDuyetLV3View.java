package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBVanBanChoDuyetLV3View extends BaseView<NDVBVanBanChoDuyetLV3Presenter> {
    Context gContext();

    void onGetDuyetSuccess();
}
