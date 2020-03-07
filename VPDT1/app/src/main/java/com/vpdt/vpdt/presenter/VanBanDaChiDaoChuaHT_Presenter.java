package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhongChuTriChoXuLyCC;
import com.vpdt.vpdt.model.VanBanDaChiDaoChuaHT;

import java.util.ArrayList;

public interface VanBanDaChiDaoChuaHT_Presenter extends BasePresenter {
    void getAllVBDaChiDaoChuaHoanThanhCC(String nam, boolean isRefresh);

    void countAllVBDaChiDaoChuaHoanThanhCC(String nam);

    void getAllVBDaChiDaoSTCPhoiHopCC(String nam, boolean isRefresh);

    void countAllVBDaChiDaoSTCPhoiHopCC(String nam);

    ArrayList<VanBanDaChiDaoChuaHT> VAN_BAN_DA_CHI_DAO_CHUA_HT_ARRAY_LIST();
}
