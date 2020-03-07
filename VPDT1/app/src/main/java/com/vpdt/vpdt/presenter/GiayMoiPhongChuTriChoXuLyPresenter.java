package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMPhongChuTriChoXuLy;

import java.util.ArrayList;

public interface GiayMoiPhongChuTriChoXuLyPresenter extends BasePresenter {
    void getAllGMPhongChuTriChoXuLy(String nam, boolean isRefresh);

    void countAllGMPhongChuTriChoXuLy(String nam);

    ArrayList<GMPhongChuTriChoXuLy> GM_PHONG_CHU_TRI_CHO_XU_LY_ARRAY_LIST();
}
