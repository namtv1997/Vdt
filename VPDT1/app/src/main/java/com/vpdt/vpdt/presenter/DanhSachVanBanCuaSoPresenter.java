package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DetailVanBanDiTongThe;

import java.util.ArrayList;

public interface DanhSachVanBanCuaSoPresenter extends BasePresenter {
    void getallvbditongthe(int loai, int kieu, String nam, boolean isRefresh);

    void countvbditongthe(int kieu, int loai, String nam);

    ArrayList<DetailVanBanDiTongThe> detailVanBanDiTongTheArrayList();
}
