package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DeatailDauSoCuaSo;

import java.util.ArrayList;

public interface DanhSachVanBanChoSoCuaSoPresenter extends BasePresenter {
    void getDSVB_ChoSo_CuaSo(String nam, boolean isRefresh);

    void countVBdi_ChoSo(String nam);

    ArrayList<DeatailDauSoCuaSo> deatailDauSoCuaSos();
}
