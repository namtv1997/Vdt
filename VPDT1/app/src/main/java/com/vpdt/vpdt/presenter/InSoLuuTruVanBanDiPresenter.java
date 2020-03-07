package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.InSoLuuTruVanbanDi;

import java.util.ArrayList;

public interface InSoLuuTruVanBanDiPresenter extends BasePresenter {
    void getVBdi_InSoLuuTru(String nam, String soditu, String sodiden, String tungay, String denngay, int loaiso, String ngaymoitu, String ngaymoiden, boolean isRefresh);

    void countVBdi_Insoluutru(String nam, String soditu, String sodiden, String tungay, String denngay, int loaiso, String ngaymoitu, String ngaymoiden);

    ArrayList<InSoLuuTruVanbanDi> inSoLuuTruVanbanDiArrayList();
}
