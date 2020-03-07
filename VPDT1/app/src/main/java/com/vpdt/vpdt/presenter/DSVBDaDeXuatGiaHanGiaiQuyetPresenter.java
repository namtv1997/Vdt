package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDaDeXuatGiaHanGiaiQuyet;

import java.util.ArrayList;

public interface DSVBDaDeXuatGiaHanGiaiQuyetPresenter extends BasePresenter {
    void getAllVBDaDeXuatGiaHanGiaQuyet(String nam, boolean isRefresh);

    void countAllVBDaDeXuatGiaHanGiaQuyet(String nam);

    ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet> VAN_BAN_DA_DE_XUAT_GIA_HAN_GIAI_QUYET_ARRAY_LIST();
}
