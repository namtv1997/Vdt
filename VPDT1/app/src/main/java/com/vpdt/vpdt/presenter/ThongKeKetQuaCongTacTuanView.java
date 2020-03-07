package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.PhongBanKeHoachDanhGia;
import com.vpdt.vpdt.model.ThongKeKetQuaCongTacTuan;

import java.util.ArrayList;

public interface ThongKeKetQuaCongTacTuanView extends BaseView<ThongKeKetQuaCongTacTuan_Presenter> {
    Context gContext();

//    void onGetDataSuccess(ArrayList<ThongKeKetQuaCongTacTuan> thongKeKetQuaCongTacTuans);
//
//    void onGetPhongBanSuccess(ArrayList<PhongBanKeHoachDanhGia> phongBanKeHoachDanhGias);
//
//    void onGetCanBoSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans);
//
//    void onGetTuanSuccess(ArrayList<String> stringArrayList);
}
