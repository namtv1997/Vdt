package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.BaoCaoCuocHopChoPheDuyet;

import java.util.ArrayList;

public interface BaoCaoCuocHopChoPheDuyetPresenter extends BasePresenter {
    void getAllBaoCaoCuocHopChoDuyet(String nam, boolean isRefresh);

    void countAllBaoCaoCuocHopChoDuyet(String nam);

    ArrayList<BaoCaoCuocHopChoPheDuyet> BAO_CAO_CUOC_HOP_CHO_PHE_DUYET_ARRAY_LIST();
}
