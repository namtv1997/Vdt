package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.ThongKeTheoPhong;

import java.util.ArrayList;

public interface BaoCaoDauCongViecCaNhanView extends BaseView<BaoCaoDauCongViecCaNhanPresenter> {
    Context gContext();

    void onGetDaDaSuccess(ArrayList<ThongKeTheoPhong> thongKeTheoPhongArrayList);
}
