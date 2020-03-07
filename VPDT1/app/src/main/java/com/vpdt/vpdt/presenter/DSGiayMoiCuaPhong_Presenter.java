package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiCuaPhong;

import java.util.ArrayList;

public interface DSGiayMoiCuaPhong_Presenter extends BasePresenter {
    void getDSGM_cuaPhong(String nam, int kieu, boolean isRefresh);

    void countDSGM_cuaPhong(String nam, int kieu);

    ArrayList<GiayMoiCuaPhong> dsvbCuaPhongs();
}
