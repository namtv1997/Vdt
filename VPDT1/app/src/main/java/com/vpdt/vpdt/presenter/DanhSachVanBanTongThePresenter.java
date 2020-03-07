package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;

import java.util.ArrayList;

public interface DanhSachVanBanTongThePresenter extends BasePresenter {
    void getAllVBTongTheDonViCapHai(String nam, boolean isRefresh);

    void countAllVBTongTheDonViCapHai(String nam);

    ArrayList<VanBanTongTheDonViCapHai> VAN_BAN_TONG_THE_DON_VI_CAP_HAI_ARRAY_LIST();
}
