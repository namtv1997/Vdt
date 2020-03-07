package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBDauViecChoXuLyPresenter extends BasePresenter {
    void getdauviecdetail(int id);

    void hoanThanhDauViec(int id, String noiDungHoanThanh);
}
