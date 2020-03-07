package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhongChuTri;
import com.vpdt.vpdt.model.PhongChuTriChoXL;

import java.util.ArrayList;

public interface VanBanGiaoPhongChuChiChoXuLyPresenter extends BasePresenter {
    void getAllPhongChuTriChoXuLy(String nam, boolean isRefresh);

    void coutAllPhongChuTriChoXuLy(String nam);

    ArrayList<PhongChuTriChoXL> PHONG_CHU_TRI_ARRAY_LIST();
}
