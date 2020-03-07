package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMGiaoPhoiHopChoXuLy;
import com.vpdt.vpdt.model.GiayMoiChoXuLy;

import java.util.ArrayList;

public interface GiayMoiChoXuLyPresenter extends BasePresenter {
    void getAllGMPhongChoXuLyCC(String nam, boolean isRefresh);

    void countAllGMPhongChoXuLyCC(String nam);

    void getAllGMDaXuLyCC(String nam, boolean isRefresh);

    void countAllGMDaXuLyCC(String nam);

    ArrayList<GiayMoiChoXuLy> GIAY_MOI_CHO_XU_LY_ARRAY_LIST();
}
