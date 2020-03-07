package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanDi;

public interface NDVBVanBanXemDeBietView extends BaseView<NDVBVanBanXemDeBietPresenter> {

    Context gContext();

    void onGetDataSuccess(DetailVanBanDi detailVanBanDi);
}
