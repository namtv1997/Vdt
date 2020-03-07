package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.BaoCaoKetQuaCuocHop;

import java.util.ArrayList;

public interface BaoCaoKetQuaCuocHop_Presenter extends BasePresenter {
    void getallbaocaokequacuochopdaxem(String nam, boolean isRefresh);

    void getallbaocaokequacuochopmoi(String nam, boolean isRefresh);

    void countbaocaokequacuochopdaxem(String nam);

    void countbaocaokequacuochopmoi(String nam);

    ArrayList<BaoCaoKetQuaCuocHop> baoCaoKetQuaCuocHops();
}
