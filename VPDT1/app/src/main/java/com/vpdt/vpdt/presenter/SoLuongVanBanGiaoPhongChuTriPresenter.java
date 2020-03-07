package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongChuTri;

import java.util.ArrayList;

public interface SoLuongVanBanGiaoPhongChuTriPresenter extends BasePresenter {
    void getAllVBGiaoPhongChuTri(String nam, boolean isRefresh);

    void countAllVBGiaoPhongChuTri(String nam);

    ArrayList<SoLuongVanBanGiaoPhongChuTri> SO_LUONG_VAN_BAN_GIAO_PHONG_CHU_TRI_ARRAY_LIST();
}
