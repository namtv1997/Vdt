package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMDaHoanThanhChoLanhDaoPhongPheDuyet;

import java.util.ArrayList;

public interface GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetPresenter extends BasePresenter {
    void getAllGMDaHoanThanhChoLDPheDuyet(String nam, boolean isRefresh);

    void countAllGMDaHoanThanhChoLDPheDuyet(String nam);

    ArrayList<GMDaHoanThanhChoLanhDaoPhongPheDuyet> GM_DA_HOAN_THANH_CHO_LANH_DAO_PHONG_PHE_DUYET_ARRAY_LIST();
}
