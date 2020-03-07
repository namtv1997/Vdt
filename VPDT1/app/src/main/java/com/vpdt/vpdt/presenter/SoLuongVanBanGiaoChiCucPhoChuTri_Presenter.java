package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoChiCucPhoChuTri;
import com.vpdt.vpdt.model.VanBanDaChiDaoChuaHT;

import java.util.ArrayList;

public interface SoLuongVanBanGiaoChiCucPhoChuTri_Presenter extends BasePresenter {
    void getAllVBGiaoPhongChuTriCC(String nam, boolean isRefresh);

    void countAllVBGiaoPhongChuTriCC(String nam);

    void getAllVBGiaoPhongC2CC(String nam, boolean isRefresh);

    void countAllVBGiaoPhongC2CC(String nam);

    ArrayList<SoLuongVanBanGiaoChiCucPhoChuTri> SO_LUONG_VAN_BAN_GIAO_CHI_CUC_PHO_CHU_TRI_ARRAY_LIST();
}
