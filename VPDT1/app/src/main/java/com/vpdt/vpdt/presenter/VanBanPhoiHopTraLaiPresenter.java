package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanPhoiHopTraLai;

import java.util.ArrayList;

public interface VanBanPhoiHopTraLaiPresenter extends BasePresenter {
    void getAllVBPhoiHopTraLai(String nam, boolean isRefresh);

    void countAllVBPhoiHopTraLai(String nam);

    ArrayList<VanBanPhoiHopTraLai> VAN_BAN_PHOI_HOP_TRA_LAI_ARRAY_LIST();
}
