package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.BaoCaoKetQuaDaGuiDi;

import java.util.ArrayList;

public interface BaoCaoKetQuaCuocHopDaGuiDi_Presenter extends BasePresenter {
    void getallbaocaosoanthaodagui(String nam, boolean isRefresh);

    void countbaocaosoanthaodagui(String nam);

    ArrayList<BaoCaoKetQuaDaGuiDi> baoCaoKetQuaDaGuiDis();
}
