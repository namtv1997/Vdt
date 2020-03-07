package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhanLoaiVanBanCongTacDang;

import java.util.ArrayList;

public interface PhanLoaiVanBanCongTacDangPresenter extends BasePresenter {
    void getAllVanBanCTDChuaPhanLoai(String nam, boolean isRefresh);

    void countAllVanBanCTDChuaPhanLoai(String nam);

    ArrayList<PhanLoaiVanBanCongTacDang> phanLoaiVanBanCongTacDangArrayList();
}
