package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface DanhSachVBSoThamMuuTrinhTPPresenter extends BasePresenter {
    void getVBdi_thammuu(String nam, String tungay, String denngay, int mapb);

    void getDSPhongban_solgvb(String nam, String tungay, String denngay, int mapb);
}
