package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyCC;
import com.vpdt.vpdt.model.VanBanDiDaXuly;

import java.util.ArrayList;

public interface VanBanChuTriChoXuLyCCPresenter extends BasePresenter {
    void getAllVBChuTriChoXuLyCC(String nam, boolean isRefresh);

    void countAllVBChuTriChoXuLyCC(String nam);

    ArrayList<VanBanChuTriChoXuLyCC> VAN_BAN_CHU_TRI_CHO_XU_LY_CC_ARRAY_LIST();
}
