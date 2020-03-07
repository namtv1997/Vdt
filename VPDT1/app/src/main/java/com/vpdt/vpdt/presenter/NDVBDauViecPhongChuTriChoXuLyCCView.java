package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.MucDanhGia;

import java.util.ArrayList;

public interface NDVBDauViecPhongChuTriChoXuLyCCView extends BaseView<NDVBDauViecPhongChuTriChoXuLyCCPresenter> {
    Context gContext();

    void onGetPhongBanChiCucSuccess(ArrayList<MucDanhGia> mucDanhGias);

    void onDuyetSuccess();
}
