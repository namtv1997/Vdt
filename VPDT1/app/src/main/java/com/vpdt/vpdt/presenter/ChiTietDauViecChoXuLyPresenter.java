package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface ChiTietDauViecChoXuLyPresenter extends BasePresenter {
    void getChiTietDauViecPHCT(int id, String nam);

    void hoanThanhDauViecPHCT(int id, String noiDungHoanThanh);
}
