package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBo;

import java.util.ArrayList;

public interface ThongTinMoiPresenter extends BasePresenter {
    void getallvanbanThongTinNoiBo(String nam, int trang_thai, boolean isRefresh);

    void countvanbanThongTinNoiBo(String nam, int trang_thai);

    ArrayList<TraoDoiThongTinNoiBo> traoDoiThongTinNoiBoArrayList();
}
