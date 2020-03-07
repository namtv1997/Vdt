package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanCacPhongChuyenLai;

import java.util.ArrayList;

public interface VanBanCacPhongChuyenLaiPresenter extends BasePresenter {
    void getAllVanBanChuyenLai(String nam, boolean isRefresh);

    void countAllVanBanChuyenLai(String nam);

    ArrayList<VanBanCacPhongChuyenLai> VAN_BAN_CAC_PHONG_CHUYEN_LAIS();
}
