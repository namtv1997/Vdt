package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DataVanBanDi;

import java.util.ArrayList;

public interface VanBanXemDeBietPresenter extends BasePresenter {
    void getallvanbanxemdebiet(String nam, boolean isRefresh);

    void coutvanbanxemdebiet(String nam);

    ArrayList<DataVanBanDi> dataVanBanDiArrayList();
}
