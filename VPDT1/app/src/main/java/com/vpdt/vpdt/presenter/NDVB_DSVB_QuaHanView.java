package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DSVB_QuaHan;

public interface NDVB_DSVB_QuaHanView extends BaseView<NDVB_DSVB_QuaHanPresenter> {
    Context gContext();

    void onGetDataSuccess(DSVB_QuaHan dsvb_quaHan);

    void themHanGiaiQuyetVBQuaHan();

    void tuChoiHanGiaiQuyetVBQuaHan();

    void tuChoiTPVBQuaHan();
}
