package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDaPhanLoai;

import java.util.ArrayList;

public interface VanBanDaPhanLoaiPresenter extends BasePresenter {
    void getAllVanBanDaPhanLoai(String nam, boolean isRefresh);

    void countAllVanBanDaPhanLoai(String nam);

    ArrayList<VanBanDaPhanLoai> VAN_BAN_DA_PHAN_LOAI_ARRAY_LIST();
}
