package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanPhoiHopDaChiDao;

import java.util.ArrayList;

public interface VanBanPhoiHopDaChiDaoPresenter extends BasePresenter {
    void getAllVBPhongPhoiHopDaChiDao(String nam, boolean isRefresh);

    void countAllVBPhongPhoiHopDaChiDao(String nam);

    ArrayList<VanBanPhoiHopDaChiDao> VAN_BAN_PHOI_HOP_DA_CHI_DAO_ARRAY_LIST();
}
