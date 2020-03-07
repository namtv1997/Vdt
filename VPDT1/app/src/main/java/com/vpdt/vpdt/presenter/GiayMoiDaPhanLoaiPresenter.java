package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiDaPhanLoai;

import java.util.ArrayList;

public interface GiayMoiDaPhanLoaiPresenter extends BasePresenter {
    void getAllGMDaPhanLoai(String nam, boolean isRefresh);

    void countAllGMDaPhanLoai(String nam);

    ArrayList<GiayMoiDaPhanLoai> GIAY_MOI_DA_PHAN_LOAI_ARRAY_LIST();
}
