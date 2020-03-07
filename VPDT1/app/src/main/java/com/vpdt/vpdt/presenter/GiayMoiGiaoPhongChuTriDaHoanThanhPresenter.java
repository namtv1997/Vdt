package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMPhongChuTriDaHoanThanh;

import java.util.ArrayList;

public interface GiayMoiGiaoPhongChuTriDaHoanThanhPresenter extends BasePresenter {
    void getAllGMGiaoPhongChuTriDaHoanThanh(String nam, boolean isRefresh);

    void countAllGMGiaoPhongChuTriDaHoanThanh(String nam);

    ArrayList<GMPhongChuTriDaHoanThanh> GM_PHONG_CHU_TRI_DA_HOAN_THANH_ARRAY_LIST();
}
