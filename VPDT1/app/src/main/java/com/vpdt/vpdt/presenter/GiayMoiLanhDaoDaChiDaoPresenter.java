package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;

import java.util.ArrayList;

public interface GiayMoiLanhDaoDaChiDaoPresenter extends BasePresenter {
    void getallgiaymoilanhdaodaxuly(String nam, boolean isRefresh);

    void countgiaymoilanhdaodaxuly(String nam);

    ArrayList<GiayMoiChoLanhDaoXuLy> giayMoiChoLanhDaoXuLyArrayList();
}
