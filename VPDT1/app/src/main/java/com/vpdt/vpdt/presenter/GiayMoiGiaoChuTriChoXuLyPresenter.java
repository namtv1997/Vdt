package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiGiaoChuTriChoXuLy;

import java.util.ArrayList;

public interface GiayMoiGiaoChuTriChoXuLyPresenter extends BasePresenter {
    void getAllGMChuTriChoXuLyCV(String nam, boolean isRefresh);

    void countAllGMChuTriChoXuLyCV(String nam);

    ArrayList<GiayMoiGiaoChuTriChoXuLy> GIAY_MOI_GIAO_CHU_TRI_CHO_XU_LY_ARRAY_LIST();
}
