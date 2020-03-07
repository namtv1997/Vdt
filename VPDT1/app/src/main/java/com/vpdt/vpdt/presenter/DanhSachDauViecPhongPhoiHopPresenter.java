package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DanhSachDauViecPhongPhoiHop;

import java.util.ArrayList;

public interface DanhSachDauViecPhongPhoiHopPresenter extends BasePresenter {
    void getAllDauViecPhongPhoiHop(String nam, boolean isRefresh);

    void getAllDauViecPhongChuTri(String nam, boolean isRefresh);

    ArrayList<DanhSachDauViecPhongPhoiHop> DANH_SACH_DAU_VIEC_PHONG_PHOI_HOP_ARRAY_LIST();
}
