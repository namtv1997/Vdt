package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChoChiDaoLV2;
import com.vpdt.vpdt.model.VanBanChoXuLyLV3;

import java.util.ArrayList;

public interface VanBanChoXuLyVBChuTriLV3Presenter extends BasePresenter {
    void getAllVBChoXuLyTPChuTriDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoXuLyTPChuTriDonViCapHai(String nam);

    void getAllVBChoXuLyTPPhoiHopDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoXuLyTPPhoiHopDonViCapHai(String nam);

    void getAllVBDaXuLyTPChuTriDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaXuLyTPChuTriDonViCapHai(String nam);

    void getAllVBDaXuLyTPPhoHopDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaXuLyTPPhoHopDonViCapHai(String nam);

    ArrayList<VanBanChoXuLyLV3> VAN_BAN_CHO_XU_LY_LV_3_ARRAY_LIST();
}
