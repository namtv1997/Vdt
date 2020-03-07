package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanChoChiDao;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;

import java.util.ArrayList;

public interface VanBanChoChiDaoPresenter extends BasePresenter {
    void getAllVBChoChiDaoDonViCapHai(String nam, boolean isRefresh);

    void countAllVBChoChiDaoDonViCapHai(String nam);

    ArrayList<VanBanChoChiDao> VAN_BAN_CHO_CHI_DAO_ARRAY_LIST();
}
