package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;

import java.util.ArrayList;

public interface ThongKeVanBanPresenter extends BasePresenter {
    void getVB_thongKetheoPhong(String nam, int ma, int sangtao, String idlanhdao, int chuagiaquyet, int dagiaiquyet, String ngaynhaptu, String ngaynhapden, boolean isRefresh);

    ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList();
}
