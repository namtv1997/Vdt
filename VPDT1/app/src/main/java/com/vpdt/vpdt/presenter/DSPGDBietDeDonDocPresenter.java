package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.TheoDoiDonDoc;

import java.util.ArrayList;

public interface DSPGDBietDeDonDocPresenter extends BasePresenter {
    void getallvbtheodoidondoc(String nam, boolean isRefresh);

    void countallvbtheodoidondoc(String nam);

    ArrayList<TheoDoiDonDoc> xemdebietArraylist();
}
