package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDiChuaXuLy;

import java.util.ArrayList;

public interface VanBanChuTriChoXuLyPresenter extends BasePresenter {
    void getVBdi_chuaxuly_tp(String nam, boolean isRefresh);

    void countVBdi_chuaxuly_tp(String nam);

    ArrayList<VanBanDiChuaXuLy> VAN_BAN_DI_CHUA_XU_LY_ARRAY_LIST();
}
