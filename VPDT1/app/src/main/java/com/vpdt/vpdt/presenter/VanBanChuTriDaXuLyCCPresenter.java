package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyCC;
import com.vpdt.vpdt.model.VanBanChuTriDaXuLyCC;

import java.util.ArrayList;

public interface VanBanChuTriDaXuLyCCPresenter extends BasePresenter {
    void getAllVBChuTriDaXuLyCC(String nam, boolean isRefresh);

    void countAllVBChuTriDaXuLyCC(String nam);

    void DeleteVBChuTriDaXuLyCC(String nam, int idvb);

    ArrayList<VanBanChuTriDaXuLyCC> VAN_BAN_CHU_TRI_DA_XU_LY_CC_ARRAY_LIST();
}
