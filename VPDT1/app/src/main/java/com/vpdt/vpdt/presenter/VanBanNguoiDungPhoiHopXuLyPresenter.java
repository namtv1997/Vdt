package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanNguoiDungPhoiHopXuLy;

import java.util.ArrayList;

public interface VanBanNguoiDungPhoiHopXuLyPresenter extends BasePresenter {
    void getAllVBNguoiDungPhoiHopXuLy(String nam, boolean isRefresh);

    void countAllVBNguoiDungPhoiHopXuLy(String nam);

    ArrayList<VanBanNguoiDungPhoiHopXuLy> VAN_BAN_NGUOI_DUNG_PHOI_HOP_XU_LY_ARRAY_LIST();
}
