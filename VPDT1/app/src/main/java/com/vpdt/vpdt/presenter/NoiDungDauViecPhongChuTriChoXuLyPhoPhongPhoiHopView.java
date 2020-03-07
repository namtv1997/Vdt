package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopView extends BaseView<NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter> {
    Context gContext();

    void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onDuyetSuccess();
}
