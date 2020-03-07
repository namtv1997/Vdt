package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DataVanBanDi;

public interface NDVBVanBanTrinhKyView extends BaseView<NDVBVanBanTrinhKyPresenter> {
    Context gContext();

    void onGetDataSuccess(DataVanBanDi dataVanBanDi);

    void tralaivanbanSucess();

    void dongyvanbanSucess();
}
