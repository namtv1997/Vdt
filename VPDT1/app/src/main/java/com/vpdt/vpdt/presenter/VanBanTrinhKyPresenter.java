package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DataVanBanDi;

import java.util.ArrayList;

public interface VanBanTrinhKyPresenter extends BasePresenter {
    void getallvanban(String nam, int trang_thai, boolean isRefresh);

    void countvanban(String nam, int trang_thai);

    ArrayList<DataVanBanDi> dataVanBanDiArrayList();
}
