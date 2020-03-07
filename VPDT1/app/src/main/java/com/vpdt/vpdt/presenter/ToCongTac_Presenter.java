package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.ToCongTac;

import java.util.ArrayList;

public interface ToCongTac_Presenter extends BasePresenter {
    void getalltocongtachoanthanh(String nam, boolean isRefresh);

    void getalltocongtacchuahoanthanh(String nam, boolean isRefresh);

    void counttocongtachoanthanh(String nam);

    void counttocongtacchuahoanthanh(String nam);

    ArrayList<ToCongTac> toCongTac();
}
