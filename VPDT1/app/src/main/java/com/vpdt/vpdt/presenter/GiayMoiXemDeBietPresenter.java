package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiXemDeBiet;

import java.util.ArrayList;

public interface GiayMoiXemDeBietPresenter extends BasePresenter {
    void getallgiaymoixemdebiet(String nam, boolean isRefresh);

    void countallgiayxemdebiet(String nam);

    ArrayList<GiayMoiXemDeBiet> giaymoixemdebietArraylist();
}
