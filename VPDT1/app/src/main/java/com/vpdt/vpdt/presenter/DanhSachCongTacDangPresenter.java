package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;

import java.util.ArrayList;

public interface DanhSachCongTacDangPresenter extends BasePresenter {
    void getallvbdentongthe(int kieu, int loai, String nam, boolean isRefresh);

    void countvbden(int kieu, int loai, String nam);

    ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList();
}
