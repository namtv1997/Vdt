package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriDaChiDaoChuaHT;

import java.util.ArrayList;

public interface DauViecPhongChuTriDaChiDaoChuaHTView extends BaseView<DauViecPhongChuTriDaChiDaoChuaHTPresenter> {
    Context gContext();

    void ongetAllDauViecPhongChuTriDaChiDaoSuccess(ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT> danhSachDauViecPhongChuTriDaChiDaoChuaHTArrayList);
}
