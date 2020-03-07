package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiPhongPhoiHopChoXuLy;

import java.util.ArrayList;

public interface GiayMoiPhoPhongPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllGMPhoPhongPhoiHopChoXuLy(String nam, boolean isRefresh);

    void countAllGMPhoPhongPhoiHopChoXuLy(String nam);

    ArrayList<GiayMoiPhongPhoiHopChoXuLy> GIAY_MOI_PHONG_PHOI_HOP_CHO_XU_LY_ARRAY_LIST();
}
