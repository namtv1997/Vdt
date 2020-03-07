package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DauViecChoXuLy;

import java.util.ArrayList;


public interface DauViecChoXuLyPresenter extends BasePresenter {
    void getalldauviec(String nam, int trang_thai, boolean isRefresh);

    void countalldauviec(String nam, int trang_thai);

    ArrayList<DauViecChoXuLy> DAU_VIEC_CHO_XU_LY_ARRAY_LIST();

}
