package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DonThuKNTC;

import java.util.ArrayList;

public interface DonThuKNTC_Presenter extends BasePresenter {
    void getalldonthukntchoanthanh(String nam, boolean isRefresh);

    void getalldonthukntcchuahoanthanh(String nam, boolean isRefresh);

    void countdonthukntchoanthanh(String nam);

    void countdonthukntcchuahoanthanh(String nam);

    ArrayList<DonThuKNTC> donThuKNTC();
}
