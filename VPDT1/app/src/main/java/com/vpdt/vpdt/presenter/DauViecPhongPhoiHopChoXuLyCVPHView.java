package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.PhongChuTriChuyenVienChoXuLy;

import java.util.ArrayList;

public interface DauViecPhongPhoiHopChoXuLyCVPHView extends BaseView<DauViecPhongPhoiHopChoXuLyCVPHPresenter> {
    Context gContext();

    void onGetSuccess(ArrayList<PhongChuTriChuyenVienChoXuLy> phongChuTriChuyenVienChoXuLyArrayList);
}
