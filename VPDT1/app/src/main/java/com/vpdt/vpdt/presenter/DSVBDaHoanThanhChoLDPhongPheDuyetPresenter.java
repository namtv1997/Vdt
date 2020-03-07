package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanHoanThanhChoLanhDaoPhongPheDuyet;

import java.util.ArrayList;

public interface DSVBDaHoanThanhChoLDPhongPheDuyetPresenter extends BasePresenter {
    void getAllVBDaHoanThanhChoLDPheDuyet(String nam, int trang_thai, boolean isRefresh);

    void countAllVBDaHoanThanhChoLDPheDuyet(String nam, int trang_thai);

    ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet> VAN_BAN_HOAN_THANH_CHO_LANH_DAO_PHONG_PHE_DUYET_ARRAY_LIST();
}
