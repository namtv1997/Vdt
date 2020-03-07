package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanGiaoPhongPhoiHop;

import java.util.ArrayList;

public interface VanBanGiaoPhongPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllVBPhongPhoiHopChoXuLy(String nam, boolean isRefresh);

    void coutAllVBPhongPhoiHopChoXuLy(String nam);

    ArrayList<VanBanGiaoPhongPhoiHop> VAN_BAN_GIAO_PHONG_PHOI_HOP_ARRAY_LIST();
}
