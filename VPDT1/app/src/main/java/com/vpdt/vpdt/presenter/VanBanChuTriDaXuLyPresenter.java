package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDiDaXuly;

import java.util.ArrayList;

public interface VanBanChuTriDaXuLyPresenter extends BasePresenter {
    void getVBdi_daxuly_tp(String nam, boolean isRefresh);

    void countVBdi_daxuly_tp(String nam);

    void xoavb_trinhky(int idvb);

    ArrayList<VanBanDiDaXuly> VAN_BAN_DI_DA_XULY_ARRAY_LIST();
}
