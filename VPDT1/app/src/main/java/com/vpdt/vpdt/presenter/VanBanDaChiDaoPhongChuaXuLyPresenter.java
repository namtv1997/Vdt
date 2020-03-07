package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDaChiDaoPhongChuaXuLy;

import java.util.ArrayList;

public interface VanBanDaChiDaoPhongChuaXuLyPresenter extends BasePresenter {
    void getAllVBDaChiDaoPhongChuaXuLyDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaChiDaoPhongChuaXuLyDonViCapHai(String nam);

    ArrayList<VanBanDaChiDaoPhongChuaXuLy> VAN_BAN_DA_CHI_DAO_PHONG_CHUA_XU_LY_ARRAY_LIST();
}
