package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiDaXuLy;

import java.util.ArrayList;

public interface GiayMoiDaXulyPresenter extends BasePresenter {
    void getAllGMDaGiaiQuyet(String nam, boolean isRefresh);

    void countAllGMDaGiaiQuyet(String nam);

    ArrayList<GiayMoiDaXuLy> GIAY_MOI_DA_XU_LY_ARRAY_LIST();
}
