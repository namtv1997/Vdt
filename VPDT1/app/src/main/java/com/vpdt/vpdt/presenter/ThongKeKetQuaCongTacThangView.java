package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.MucDanhGia;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.ThongKeKetQuaCongTacThang;

import java.util.ArrayList;

public interface ThongKeKetQuaCongTacThangView extends BaseView<ThongKeKetQuaCongTacThang_Presenter> {
    Context gContext();

//    void onGetDataSuccess(ArrayList<ThongKeKetQuaCongTacThang> thongKeKetQuaCongTacThangs);
//
//    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);
//
//    void onGetCanBoSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans);
//
//    void onGetMucDanhGiaSuccess(ArrayList<MucDanhGia> mucDanhGias);
}
