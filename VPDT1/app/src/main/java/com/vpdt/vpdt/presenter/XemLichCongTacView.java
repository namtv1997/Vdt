package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.LichCongTac;

import java.util.ArrayList;

public interface XemLichCongTacView extends BaseView<XemLichCongTacPresenter> {
    Context gContext();

    void ongetlistCB_lanhdaocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetTuanSuccess(ArrayList<String> stringArrayList);

    void onGetLichCongTacSuccess(ArrayList<LichCongTac> lichCongTacArrayList);
}
