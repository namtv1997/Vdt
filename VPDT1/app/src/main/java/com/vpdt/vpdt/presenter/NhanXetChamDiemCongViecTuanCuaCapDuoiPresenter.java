package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter extends BasePresenter {
    void getDanhSachCB_CTtuan(String nam, int tuan, int idphong);

    void getDanhSachChuyenVien_CTtuan(String nam, int tuan, int idphong);

    void getAllTuan(String nam);
}
