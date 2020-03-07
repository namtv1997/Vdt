package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLy;

import java.util.ArrayList;

public interface VanBanChuTriChoXuLyPhoPhongPresenter extends BasePresenter {
    void getAllChuTriChoXuLy(String nam, boolean isRefresh);

    void countAllChuTriChoXuLy(String nam);

    ArrayList<VanBanChuTriChoXuLy> VAN_BAN_CHU_TRI_CHO_XU_LY_ARRAY_LIST();
}
