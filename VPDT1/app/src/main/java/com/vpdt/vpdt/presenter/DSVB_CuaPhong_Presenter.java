package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSVBCuaPhong;

import java.util.ArrayList;

public interface DSVB_CuaPhong_Presenter extends BasePresenter {
    void getDSVB_cuaPhong(String nam, boolean isRefresh);

    void countDSVB_cuaPhong(String nam);

    ArrayList<DSVBCuaPhong> dsvbCuaPhongs();
}
