package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMPhongChuTriDaChiDao;

import java.util.ArrayList;

public interface GiayMoiGiaoPhongChuTriDaChiDaoPresenter extends BasePresenter {
    void getAllGMGiaoPhongChuTriDaChiDao(String nam, boolean isRefresh);

    void countAllGMGiaoPhongChuTriDaChiDao(String nam);

    ArrayList<GMPhongChuTriDaChiDao> GM_PHONG_CHU_TRI_DA_CHI_DAO_ARRAY_LIST();
}
