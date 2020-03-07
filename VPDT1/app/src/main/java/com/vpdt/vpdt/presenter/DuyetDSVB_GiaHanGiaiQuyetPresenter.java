package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiaHanGiaiQuyet;

import java.util.ArrayList;

public interface DuyetDSVB_GiaHanGiaiQuyetPresenter extends BasePresenter {
    void getallvbgiahangiaiquyet(String nam, boolean isRefresh);

    void countvbgiahangiaiquyet(String nam);

    ArrayList<GiaHanGiaiQuyet> giaHanGiaiQuyets();
}
