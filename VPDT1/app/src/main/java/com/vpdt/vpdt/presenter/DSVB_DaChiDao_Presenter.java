package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSVB_DaChiDao;

import java.util.ArrayList;

public interface DSVB_DaChiDao_Presenter extends BasePresenter {
    void getallvblanhdaodachidao(String nam, boolean isRefresh);

    void countvblanhdaodachidao(String nam);

    void getallvbstcphoihopdachidao(String nam, boolean isRefresh);

    void countvbstcphoihopdachidao(String nam);

    ArrayList<DSVB_DaChiDao> dsvbDaChiDao();

}
