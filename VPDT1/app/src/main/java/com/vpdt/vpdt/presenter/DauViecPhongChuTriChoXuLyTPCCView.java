package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DauViecPhongChuTriChoXuLyTPCC;

import java.util.ArrayList;

public interface DauViecPhongChuTriChoXuLyTPCCView extends BaseView<DauViecPhongChuTriChoXuLyTPCCPresenter> {
    Context gContext();

    void onGetSuccess(ArrayList<DauViecPhongChuTriChoXuLyTPCC> dauViecPhongChuTriChoXuLyTPCCArrayList);
}
