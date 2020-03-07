package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongPhoiHop;

import java.util.ArrayList;

public interface SoLuongVanBanGiaoPhongPhoiHopPresenter extends BasePresenter {
    void getAllVBPhongPhoiHop(String nam, boolean isRefresh);

    void countAllVBPhongPhoiHop(String nam);

    void tuChoiVBPhongPhoiHop(int id, String noiDungTuChoi);

    ArrayList<SoLuongVanBanGiaoPhongPhoiHop> SO_LUONG_VAN_BAN_GIAO_PHONG_PHOI_HOP_ARRAY_LIST();
}
