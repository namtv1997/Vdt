package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhongChuTriDaChiDao;

import java.util.ArrayList;

public interface VanBanSTCPhoiHopDaChiDaoPresenter extends BasePresenter {
    void getAllVBSTCPhoiHopDaChiDaoPhong(String nam, boolean isRefresh);

    void countAllVBSTCPhoiHopDaChiDaoPhong(String nam);

    ArrayList<PhongChuTriDaChiDao> PHONG_CHU_TRI_DA_CHI_DAO_ARRAY_LIST();
}
