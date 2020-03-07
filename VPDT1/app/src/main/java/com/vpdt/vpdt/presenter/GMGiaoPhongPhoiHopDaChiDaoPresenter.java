package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMGiaoPhongPhoiHopDaChiDao;

import java.util.ArrayList;

public interface GMGiaoPhongPhoiHopDaChiDaoPresenter extends BasePresenter {
    void getAllGMGiaoPhongPhoiHopDaChiDao(String nam, boolean isRefresh);

    void countAllGMGiaoPhongPhoiHopDaChiDao(String nam);


    ArrayList<GMGiaoPhongPhoiHopDaChiDao> GM_GIAO_PHONG_PHOI_HOP_DA_CHI_DAOS();
}
