package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DetailVanBanTheoLanhDao;

import java.util.ArrayList;

public interface ClickVanBanThongKeVBTheoLDCDPresenter extends BasePresenter {
    void getVB_TKVB_theoLD(String nam, int dunghan, int dalam, int idPgd, int idphongban, boolean isRefresh);

    ArrayList<DetailVanBanTheoLanhDao> detailVanBanTheoLanhDaoArraylist();
}
