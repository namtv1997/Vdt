package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanNguoiDungXuLy;

import java.util.ArrayList;

public interface VanBanNguoiDungXuLyPresenter extends BasePresenter {
    void getAllVBNguoiDungXuLy(String nam, boolean isRefresh);

    void countAllVBNguoiDungXuLy(String nam);

    ArrayList<VanBanNguoiDungXuLy> VAN_BAN_NGUOI_DUNG_XU_LY_ARRAY_LIST();
}
