package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanPhoiHopChoXuLyChuyenVien;

import java.util.ArrayList;

public interface VanBanPhoiHopChoXuLyChuyenVienPresenter extends BasePresenter {
    void getAllVBPhoiHopChoXuLyCV(String nam, boolean isRefresh);

    void countAllVBPhoiHopChoXuLyCV(String nam);

    ArrayList<VanBanPhoiHopChoXuLyChuyenVien> VAN_BAN_PHOI_HOP_CHO_XU_LY_CHUYEN_VIEN_ARRAY_LIST();
}
