package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSVB_QuaHan;

import java.util.ArrayList;

public interface DSVB_QuaHanDoLanhDaoChiDao_Presenter extends BasePresenter {
    void getallvbquahandolanhdaochidao(String nam, boolean isRefresh);

    void countvbquahandolanhdaochidao(String nam);

    ArrayList<DSVB_QuaHan> getListDSVB_QuaHan();
}
