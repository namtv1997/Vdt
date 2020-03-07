package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanPhoiHopChoXuLy;

import java.util.ArrayList;

public interface VanBanPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllVBPhoiHopChoXuLy(String nam, boolean isRefresh);

    void countAllVBPhoiHopChoXuLy(String nam);

    ArrayList<VanBanPhoiHopChoXuLy> VAN_BAN_PHOI_HOP_CHO_XU_LY_ARRAY_LIST();
}
