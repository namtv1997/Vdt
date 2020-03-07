package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChoXuLyLV3;
import com.vpdt.vpdt.model.VanBanChoXuLyVBChuTriLV4;

import java.util.ArrayList;

public interface VanBanChoXuLyVBChuTriLV4Presenter extends BasePresenter {
    void getAllVBChoXuLyPPChuTriDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoXuLyPPChuTriDonViCapHai(String nam);

    void getAllVBChoXuLyPPPhoiHopDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoXuLyPPPhoiHopDonViCapHai(String nam);

    void getAllVBDaXuLyPPChuTriDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaXuLyPPChuTriDonViCapHai(String nam);

    void getAllVBDaXuLyPPPhoiHopDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaXuLyPPPhoiHopDonViCapHai(String nam);

    ArrayList<VanBanChoXuLyVBChuTriLV4> VAN_BAN_CHO_XU_LY_VB_CHU_TRI_LV_4_ARRAY_LIST();
}
