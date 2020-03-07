package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.XemDeBiet;

import java.util.ArrayList;

public interface DSVBXemDeBietPresenter extends BasePresenter {
    void getallvbxemdebiet(String nam, boolean isRefresh);

    void countallvbxemdebiet(String nam);

    ArrayList<XemDeBiet> xemdebietArraylist();
}
