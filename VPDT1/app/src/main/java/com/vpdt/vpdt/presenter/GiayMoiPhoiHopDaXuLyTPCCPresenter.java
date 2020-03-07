package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiChoXuLy;
import com.vpdt.vpdt.model.GiayMoiPhoiHopDaXuLy;

import java.util.ArrayList;

public interface GiayMoiPhoiHopDaXuLyTPCCPresenter extends BasePresenter {
    void getAllGMPhoiHopDaChiDaoCC(String nam, boolean isRefresh);

    void countAllGMPhoiHopDaChiDaoCC(String nam);

    ArrayList<GiayMoiPhoiHopDaXuLy> GIAY_MOI_PHOI_HOP_DA_XU_LY_ARRAY_LIST();
}
