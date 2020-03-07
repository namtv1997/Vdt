package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface ChiTietDauViecPhongPhoiHopChoXuLyCVPHPresenter extends BasePresenter {
    void getChiTietDauViecPH(int id);

    void hoanThanhDauViecPHCT(int id, String noiDungHoanThanh);
}
