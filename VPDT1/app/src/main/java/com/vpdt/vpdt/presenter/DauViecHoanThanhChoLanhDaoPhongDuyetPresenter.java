package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DauViecHoanThanhChoLanhDaoPhongDuyet;

import java.util.ArrayList;

public interface DauViecHoanThanhChoLanhDaoPhongDuyetPresenter extends BasePresenter {
    void getAllDauViecHoanThanhChoLDDuyet(String nam, boolean isRefresh);

    void countDauViecHoanThanhChoLDDuyet(String nam);

    ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet> DAU_VIEC_HOAN_THANH_CHO_LANH_DAO_PHONG_DUYET_ARRAY_LIST();
}
