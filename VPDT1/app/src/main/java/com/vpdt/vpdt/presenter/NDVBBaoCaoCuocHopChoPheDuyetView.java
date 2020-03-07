package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;

public interface NDVBBaoCaoCuocHopChoPheDuyetView extends BaseView<NDVBBaoCaoCuocHopChoPheDuyetPresenter> {
    Context gContext();

    void duyetBaoCaoCuocHopChoDuyetSuccess();

    void tuChoiBaoCaoCuocHopChoDuyetSuccess();
}
