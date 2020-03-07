package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VBPhoPhongPhoiHopChoXL;

import java.util.ArrayList;

public interface VBPhoPhongPhoiHopChoXLPresenter extends BasePresenter {
    void getAllVBPhoPhongPhoiHopChoXuLy(String nam, boolean isRefresh);

    void countAllVBPhoPhongPhoiHopChoXuLy(String nam);

    ArrayList<VBPhoPhongPhoiHopChoXL> VB_PHO_PHONG_PHOI_HOP_CHO_XLS();
}
