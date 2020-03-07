package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSKienNghiHDND;

import java.util.ArrayList;

public interface DSKienNghiHDND_Presenter extends BasePresenter {
    void getallkiennghi(String nam, boolean isRefresh);

    void countallkiennghi(String nam);

    void getalltaileuhopphong(String nam, boolean isRefresh);

    void countalltaileuhopphong(String nam);

    void getalltaileuhop(String nam, boolean isRefresh);

    void countalltaileuhop(String nam);

    ArrayList<DSKienNghiHDND> dsKienNghiHDNDS();
}
