package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMPhoiHopChoXL;

import java.util.ArrayList;

public interface GiayMoiPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllGMPhoiHopChoXuLy(String nam, boolean isRefresh);

    void countAllGMPhoiHopChoXuLy(String nam);

    ArrayList<GMPhoiHopChoXL> GM_PHOI_HOP_CHO_XL_ARRAY_LIST();
}
