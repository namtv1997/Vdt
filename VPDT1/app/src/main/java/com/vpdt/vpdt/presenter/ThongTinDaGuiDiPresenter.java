package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanGuiDi;

import java.util.ArrayList;

public interface ThongTinDaGuiDiPresenter extends BasePresenter {
    void getallvanbanguidi(String nam, boolean isRefresh);

    void countallvanbanguidi(String nam);

    ArrayList<VanBanGuiDi> vanBanGuiDiArrayList();
}
