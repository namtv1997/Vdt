package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DSDauViecPhongChuTriDaXuLyCC;
import com.vpdt.vpdt.model.DauViecPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.DauViecPhongPhoiHopChoXuLyCC;

import java.util.ArrayList;

public interface DauViecPhongChuTriChoXuLyCCView extends BaseView<DauViecPhongChuTriChoXuLyCCPresenter> {
    Context gContext();

    void onGetSuccess(ArrayList<DauViecPhongChuTriChoXuLy> dauViecPhongChuTriChoXuLyArrayList);

    void onGetPhoiHopSuccess(ArrayList<DauViecPhongPhoiHopChoXuLyCC> dauViecPhongPhoiHopChoXuLyCCArrayList);

    void onGetDSChuTriSuccess(ArrayList<DSDauViecPhongChuTriDaXuLyCC> dsDauViecPhongChuTriDaXuLyCCArrayList);
}
