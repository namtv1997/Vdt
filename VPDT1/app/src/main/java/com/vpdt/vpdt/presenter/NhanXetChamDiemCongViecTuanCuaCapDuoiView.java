package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.NhanXetChamDiemCongViecTuanCuaCapDuoi;

import java.util.ArrayList;

public interface NhanXetChamDiemCongViecTuanCuaCapDuoiView extends BaseView<NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter> {
    Context gContext();

    void onGetTuanSuccess(ArrayList<String> stringArrayList);

    void onGetKeHoachCongTacTuanSuccess(ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi> nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList);

    void onGetKeHoachCongTacTuan1Success(ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi> nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList1);
}
