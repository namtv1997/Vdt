package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanGuiDi;

public interface TTVBThongTinDaGuiView extends BaseView<TTVBThongTinDaGuiPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailVanBanGuiDi detailVanBanGuiDi);
}
