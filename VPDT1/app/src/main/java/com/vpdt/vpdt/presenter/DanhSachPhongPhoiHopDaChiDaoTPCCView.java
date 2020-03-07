package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DanhSachPhongPhoiHopDaChiDaoTPCC;
import com.vpdt.vpdt.model.DauViecPhongChuTriChoXuLyTPCC;

import java.util.ArrayList;

public interface DanhSachPhongPhoiHopDaChiDaoTPCCView extends BaseView<DanhSachPhongPhoiHopDaChiDaoTPCCPresenter> {
    Context gContext();

    void onGetSuccess(ArrayList<DanhSachPhongPhoiHopDaChiDaoTPCC> danhSachPhongPhoiHopDaChiDaoTPCCS);
}
