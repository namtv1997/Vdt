package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBVanBanDaTrinhKyView extends BaseView<NDVBVanBanDaTrinhKyPresenter> {
    Context gContext();

    void onXoaDuLieuSuccess();
}
