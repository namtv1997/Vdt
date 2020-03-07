package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanChoXuLyGQ;
import com.vpdt.vpdt.model.DetailVanBanPhoiHopTraLai;

public interface TTVBDetailVanBanChoXuLyGQView extends BaseView<TTVBDetailVanBanChoXuLyGQPresenter> {
    Context gContext();

    void onGetDaTaSuccess(DetailVanBanChoXuLyGQ detailVanBanChoXuLyGQ);

    void hoanThanhSuccess();

    void chamMuonSuccess();
}
