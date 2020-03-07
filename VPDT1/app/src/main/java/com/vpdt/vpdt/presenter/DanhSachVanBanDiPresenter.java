package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DanhSachVanBanDi;

import java.util.ArrayList;

public interface DanhSachVanBanDiPresenter extends BasePresenter {
    void getAllVBDiDonViCapHai(String nam, int trangthai, boolean isRefresh);

    void countAllVBDiDonViCapHai(String nam, int trangthai);

    ArrayList<DanhSachVanBanDi> DANH_SACH_VAN_BAN_DI_ARRAY_LIST();
}
