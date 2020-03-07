package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.VanBanPhoPhongBietDeDonDoc;

import java.util.ArrayList;

public interface VanBanPhoPhongBietDeDonDocPresenter extends BasePresenter {
    void getAllVBPhoPhongBietDeDonDoc(String nam, boolean isRefresh);

    void countAllVBPhoPhongBietDeDonDoc(String nam);

    ArrayList<VanBanPhoPhongBietDeDonDoc> VAN_BAN_PHO_PHONG_BIET_DE_DON_DOC_ARRAY_LIST();
}
