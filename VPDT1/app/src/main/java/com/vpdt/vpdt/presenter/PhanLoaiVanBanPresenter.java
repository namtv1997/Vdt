package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.PhanLoaiVanBan;

import java.util.ArrayList;

public interface PhanLoaiVanBanPresenter extends BasePresenter {
    void getAllVanBanChuaPhanLoai(String nam, boolean isRefresh);

    void countAllVanBanChuaPhanLoai(String nam);

    ArrayList<PhanLoaiVanBan> PHAN_LOAI_VAN_BAN_ARRAY_LIST();
}
