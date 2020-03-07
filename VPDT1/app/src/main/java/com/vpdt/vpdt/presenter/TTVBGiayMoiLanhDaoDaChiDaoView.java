package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailGiayMoi;

public interface TTVBGiayMoiLanhDaoDaChiDaoView extends BaseView<TTVBGiayMoiLanhDaoDaChiDaoPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailGiayMoi detailGiayMoi);
}
