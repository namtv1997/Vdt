package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DeXuatCongViecPhoiHopChoDuyet;

import java.util.ArrayList;

public interface DeXuatCongViecPhoiHopChoDuyetPresenter extends BasePresenter {
    void getAllDeXuatCVChoDuyet(String nam, boolean isRefresh);

    void countAllDeXuatCVChoDuyet(String nam);

    ArrayList<DeXuatCongViecPhoiHopChoDuyet> DE_XUAT_CONG_VIEC_PHOI_HOP_CHO_DUYET_ARRAY_LIST();
}
