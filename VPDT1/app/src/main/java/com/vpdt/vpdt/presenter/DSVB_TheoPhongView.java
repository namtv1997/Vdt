package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DSVB_TheoPhong;

import java.util.ArrayList;

public interface DSVB_TheoPhongView extends BaseView<DSVB_TheoPhongPresenter> {
    Context gContext();

    void onGetDaDaSuccess(ArrayList<DSVB_TheoPhong> dsvb_theoPhongs);
}
