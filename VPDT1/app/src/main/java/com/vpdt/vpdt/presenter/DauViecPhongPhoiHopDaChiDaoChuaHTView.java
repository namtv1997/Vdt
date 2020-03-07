package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriDaChiDaoChuaHT;

import java.util.ArrayList;

public interface DauViecPhongPhoiHopDaChiDaoChuaHTView extends BaseView<DauViecPhongPhoiHopDaChiDaoChuaHTPresenter> {
    Context gContext();

    void ongetAllDauViecPhongPhoHopDaChiDaoSuccess(ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT> danhSachDauViecPhongChuTriDaChiDaoChuaHTArrayList);
}
