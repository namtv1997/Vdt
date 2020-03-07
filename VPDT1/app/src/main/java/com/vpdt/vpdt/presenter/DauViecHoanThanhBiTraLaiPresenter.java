package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DauViecHoanThanhBiTraLai;

import java.util.ArrayList;

public interface DauViecHoanThanhBiTraLaiPresenter extends BasePresenter {
    void getAllDauViecHoanThanhBiTraLai(String nam, boolean isRefresh);

    void countAllDauViecHoanThanhBiTraLai(String nam);

    ArrayList<DauViecHoanThanhBiTraLai> DAU_VIEC_HOAN_THANH_BI_TRA_LAI_ARRAY_LIST();
}
