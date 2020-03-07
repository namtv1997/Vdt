package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.Response;

public interface BaoCaoKetQuaCuocHopDaGuiDiView extends BaseView<BaoCaoKetQuaCuocHopDaGuiDi_Presenter> {
    Context gContext();

    void onGetDataSuccess();

    void onGetCountVBSuccess(Response<Integer> response);
}
