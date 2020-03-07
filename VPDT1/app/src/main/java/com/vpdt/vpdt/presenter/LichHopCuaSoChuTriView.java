package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailLichHop;

import java.util.ArrayList;

public interface LichHopCuaSoChuTriView extends BaseView<LichHopCuaSoChuTriPresenter> {
    Context gContext();

    void onGetDataSuccess(DetailLichHop detailLichHop);

    void onGetTuanSuccess(ArrayList<String> stringArrayList);
}
