package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChoDuyetLV3;
import com.vpdt.vpdt.model.VanBanChoXuLyLV3;

import java.util.ArrayList;

public interface VanBanChoDuyetLV3Presenter extends BasePresenter {
    void getAllVBChoDuyetTPDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoDuyetTPDonViCapHai(String nam);

    ArrayList<VanBanChoDuyetLV3> VAN_BAN_CHO_DUYET_LV_3_ARRAY_LIST();
}
