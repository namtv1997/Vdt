package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DanhSachvanBanPhongChuTriLV3;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;

import java.util.ArrayList;

public interface DanhSachVanBanPhongChuTriLV3Presenter extends BasePresenter {
    void getAllVBDonViCapHai(String nam, int type, boolean isRefresh);

    void countAllVBDonViCapHai(String nam, int type);

    ArrayList<DanhSachvanBanPhongChuTriLV3> DANH_SACHVAN_BAN_PHONG_CHU_TRI_LV_3_ARRAY_LIST();
}
