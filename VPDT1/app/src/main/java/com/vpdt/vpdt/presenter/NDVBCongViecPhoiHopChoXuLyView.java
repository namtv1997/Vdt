package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVBCongViecPhoiHopChoXuLyView extends BaseView<NDVBCongViecPhoiHopChoXuLyPresenter> {
    Context gContext();

    void onGetNguoiKySuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void guiLenCVPhoiHopChoXuLy();

    void dongYCVPhoiHopChoXuLy();

    void traLaiCVPhoiHopChoXuLy();
}
