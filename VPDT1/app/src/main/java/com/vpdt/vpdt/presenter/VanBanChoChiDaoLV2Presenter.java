package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChoChiDao;
import com.vpdt.vpdt.model.VanBanChoChiDaoLV2;

import java.util.ArrayList;

public interface VanBanChoChiDaoLV2Presenter extends BasePresenter {
    void getAllVBChoChiDaoDonViCapHaiPhong(String nam, boolean isRefresh);

    void countAllVBChoChiDaoDonViCapHaiPhong(String nam);

    void getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String nam, boolean isRefresh);

    void countAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String nam);

    ArrayList<VanBanChoChiDaoLV2> VAN_BAN_CHO_CHI_DAO_LV_2_ARRAY_LIST();
}
