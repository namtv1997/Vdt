package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;


public interface NDVBBaoCaoKetQuaCuocHopView extends BaseView<NDVBBaoCaoKetQuaCuocHop_Presenter> {
    Context gContext();

    void onGetDataSuccess(DetailGiayMoi detailGiayMoi);

    void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void duyettuchoibaocaokequacuochopSuccess();

    void chuyenTiepKeQuaBaoCaoCuocHopSuccess();
}
