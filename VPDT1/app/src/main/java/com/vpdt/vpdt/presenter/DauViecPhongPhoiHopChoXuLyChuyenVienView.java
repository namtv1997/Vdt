package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.PhongChuTriChuyenVienChoXuLy;

import java.util.ArrayList;

public interface DauViecPhongPhoiHopChoXuLyChuyenVienView extends BaseView<DauViecPhongPhoiHopChoXuLyChuyenVienPresenter> {
    Context gContext();

    void onGetAllDauViecPhongPhoiHopCVSuccess(ArrayList<PhongChuTriChuyenVienChoXuLy> phongChuTriChuyenVienChoXuLyArrayList);
}
