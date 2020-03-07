package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSVB_QuanTrong;

import java.util.ArrayList;

public interface DSVB_QuanTrong_Presenter extends BasePresenter {
    void getallvbquantronghoanthanh(String nam, boolean isRefresh);

    void getallvbquantrongchuahoanthanh(String nam, boolean isRefresh);

    void countvbquantronghoanthanh(String nam);

    void countvbquantrongchuahoanthanh(String nam);

    ArrayList<DSVB_QuanTrong> dsvb_quanTrong();
}
