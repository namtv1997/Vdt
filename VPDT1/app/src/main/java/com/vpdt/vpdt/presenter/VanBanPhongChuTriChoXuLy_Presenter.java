package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhongChuTriChoXuLyCC;
import com.vpdt.vpdt.model.VanBanDenChoXuLy;

import java.util.ArrayList;

public interface VanBanPhongChuTriChoXuLy_Presenter extends BasePresenter {
    void getAllVBPhongChuTriChoXuLyCC(String nam, boolean isRefresh);

    void countAllVBPhongChuTriChoXuLyCC(String nam);

    ArrayList<PhongChuTriChoXuLyCC> PHONG_CHU_TRI_CHO_XU_LY_CC_ARRAY_LIST();
}
