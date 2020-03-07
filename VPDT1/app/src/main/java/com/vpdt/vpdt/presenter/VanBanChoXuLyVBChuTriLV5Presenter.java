package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChoXuLyLV5;
import com.vpdt.vpdt.model.VanBanChoXuLyVBChuTriLV4;

import java.util.ArrayList;

public interface VanBanChoXuLyVBChuTriLV5Presenter extends BasePresenter {
    void getAllVBChoXuLyCVChuTriDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoXuLyCVChuTriDonViCapHai(String nam);

    void getAllVBChoXuLyCVPhoiHopDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoXuLyCVPhoiHopDonViCapHai(String nam);

    void getAllVBDaXuLyCVChuTriDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaXuLyCVChuTriDonViCapHai(String nam);

    void getAllVBDaXuLyCVPhoiHopDonViCapHai(String nam, boolean isRefresh);

    void countAllVBDaXuLyCVPhoiHopDonViCapHai(String nam);

    void getAllVBPhoiHopChoXuLyCVDonViCapHai(String nam, boolean isRefresh);

    void countAllVBPhoiHopChoXuLyCVDonViCapHai(String nam);

    void getAllVBPhoiHopDaXuLyCVDonViCapHai(String nam, boolean isRefresh);

    void countAllVBPhoiHopDaXuLyCVDonViCapHai(String nam);

    ArrayList<VanBanChoXuLyLV5> VAN_BAN_CHO_XU_LY_LV_5_ARRAY_LIST();
}
