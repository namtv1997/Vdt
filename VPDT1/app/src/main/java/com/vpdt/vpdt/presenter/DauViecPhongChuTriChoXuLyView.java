package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriChoXuLy;

import java.util.ArrayList;

public interface DauViecPhongChuTriChoXuLyView extends BaseView<DauViecPhongChuTriChoXuLyPresenter> {
    Context gContext();

    void onGetDanhSachDauViecQuaHanCuaPhongSuccess(ArrayList<DanhSachDauViecPhongChuTriChoXuLy> danhSachDauViecQuaHanCuaPhongArrayList);
}
