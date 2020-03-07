package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GMGiaoPhoiHopChoXuLy;

import java.util.ArrayList;

public interface GMGiaoPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllGMPhoiHopChoXuLyCV(String nam, boolean isRefresh);

    void countAllGMPhoiHopChoXuLyCV(String nam);

    ArrayList<GMGiaoPhoiHopChoXuLy> GM_GIAO_PHOI_HOP_CHO_XU_LY_ARRAY_LIST();
}
