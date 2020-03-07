package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DanhSachDauViecQuaHanCuaPhong;

import java.util.ArrayList;

public interface DanhSachDauViecQuaHanCuaPhongView extends BaseView<DanhSachDauViecQuaHanCuaPhongPresenter> {
    Context gContext();

    void onGetDanhSachDauViecQuaHanCuaPhongSuccess(ArrayList<DanhSachDauViecQuaHanCuaPhong> danhSachDauViecQuaHanCuaPhongArrayList);
}
