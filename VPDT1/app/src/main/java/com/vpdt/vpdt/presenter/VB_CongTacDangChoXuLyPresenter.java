package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhongChuTri;
import com.vpdt.vpdt.model.PhongChuTriChoXL;

import java.util.ArrayList;

public interface VB_CongTacDangChoXuLyPresenter extends BasePresenter {

    void getAllVBCongTacDangChoXuLyPhong(String nam, boolean isRefresh);

    void countAllVBCongTacDangChoXuLyPhong(String nam);

    ArrayList<PhongChuTriChoXL> PHONG_CHU_TRI_ARRAY_LIST();
}
