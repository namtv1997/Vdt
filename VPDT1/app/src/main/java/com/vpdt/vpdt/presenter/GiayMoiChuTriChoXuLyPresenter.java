package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiChuTriChoXuLy;

import java.util.ArrayList;

public interface GiayMoiChuTriChoXuLyPresenter extends BasePresenter {
    void getAllGMChuTriChoXuLy(String nam, boolean isRefresh);

    void countAllGMChuTriChoXuLy(String nam);

    ArrayList<GiayMoiChuTriChoXuLy> GIAY_MOI_CHU_TRI_CHO_XU_LY_ARRAY_LIST();
}
