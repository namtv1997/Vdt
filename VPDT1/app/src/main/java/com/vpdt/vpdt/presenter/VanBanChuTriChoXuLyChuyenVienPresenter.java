package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyChuyenVien;

import java.util.ArrayList;

public interface VanBanChuTriChoXuLyChuyenVienPresenter extends BasePresenter {
    void getAllChuTriChoXuLyCV(String nam, boolean isRefresh);

    void countAllChuTriChoXuLyCV(String nam);

    ArrayList<VanBanChuTriChoXuLyChuyenVien> VAN_BAN_CHU_TRI_CHO_XU_LY_CHUYEN_VIEN_ARRAY_LIST();
}
