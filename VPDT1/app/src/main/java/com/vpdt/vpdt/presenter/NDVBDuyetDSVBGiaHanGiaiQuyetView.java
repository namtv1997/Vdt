package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVanBanQuahan;


public interface NDVBDuyetDSVBGiaHanGiaiQuyetView extends BaseView<NDVBDuyetDSVBGiaHanGiaiQuyetPresenter> {

    Context gContext();

    void onGetDataSuccess(DetailVanBanQuahan dsvbDaChiDao);

    void tuChoiHanGiaiQuyet();

    void duyetHanGiaiQuyet();

    void duyetVBGiaHanGiaQuyetCB();

    void duyetVBGiaHanGiaQuyetTP();

}
