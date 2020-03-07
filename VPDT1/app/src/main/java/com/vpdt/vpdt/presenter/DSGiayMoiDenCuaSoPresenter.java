package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSGiayMoiDenCuaSo;

import java.util.ArrayList;

public interface DSGiayMoiDenCuaSoPresenter extends BasePresenter {
    void getallgiaymoi(String nam, boolean isRefresh, int type);

    void countgiaymoi(String nam, int type);

    ArrayList<DSGiayMoiDenCuaSo> dsGiayMoiDenCuaSoArrayList();
}
