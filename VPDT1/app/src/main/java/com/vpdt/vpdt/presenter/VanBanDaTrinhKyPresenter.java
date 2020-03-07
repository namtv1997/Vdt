package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDaTrinhKy;

import java.util.ArrayList;

public interface VanBanDaTrinhKyPresenter extends BasePresenter {
    void getVBtrinhky(String nam, boolean isRefresh);

    void countVBtrinhky(String nam);

    ArrayList<VanBanDaTrinhKy> VAN_BAN_DA_TRINH_KY_ARRAY_LIST();
}
