package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DSVB_DaChiDao;

import java.util.ArrayList;

public interface DSVBCongTacDangChoLDXuLyPresenter extends BasePresenter {
    void getallvbcongtacdangchoxuly(String nam, boolean isRefresh);

    void Countvbcongtacdangchoxuly(String nam);

    ArrayList<DSVB_DaChiDao> dsvb_daChiDaos();
}
