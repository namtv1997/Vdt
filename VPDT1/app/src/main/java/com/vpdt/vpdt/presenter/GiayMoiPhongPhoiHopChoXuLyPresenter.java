package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMPhongChuTriChoXuLy;

import java.util.ArrayList;

public interface GiayMoiPhongPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllGMPhongPhoiHopChoXuLy(String nam, boolean isRefresh);

    void countAllGMPhongPhoiHopChoXuLy(String nam);

    ArrayList<GMPhongChuTriChoXuLy> GM_PHONG_CHU_TRI_CHO_XU_LY_ARRAY_LIST();
}
