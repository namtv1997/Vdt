package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriChoXuLy;

import java.util.ArrayList;

public interface DauViecPhongPhoiHopChoXuLyView extends BaseView<DauViecPhongPhoiHopChoXuLyPresenter> {
    Context gContext();

    void onGetAllDauViecPhongPhoHopChoXuLySuccess(ArrayList<DanhSachDauViecPhongChuTriChoXuLy> danhSachDauViecQuaHanCuaPhongArrayList);
}
