package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanDenChoXuLy;

import java.util.ArrayList;

public interface DSVB_ChoLanhDaoXuLy_Presenter extends BasePresenter {
    void getallvbdenchoxuly(String nam, boolean isRefresh);

    void countvbvbdenchoxuly(String nam);

    ArrayList<VanBanDenChoXuLy> dsvbDaChiDao();
}
