package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanPhoiHopChoXuLyLV4;

import java.util.ArrayList;

public interface VanBanPhoiHopChoXuLyLV4Presenter extends BasePresenter {
    void getAllVBPhoiHopChoXuLyDonViCapHai(String nam, boolean isRefresh);

    void countAllVBPhoiHopChoXuLyDonViCapHai(String nam);

    void getAllVBPhoiHopDaXuLyDonViCapHai(String nam, boolean isRefresh);

    void countAllVBPhoiHopDaXuLyDonViCapHai(String nam);

    ArrayList<VanBanPhoiHopChoXuLyLV4> VAN_BAN_PHOI_HOP_CHO_XU_LY_LV_4_ARRAY_LIST();
}
