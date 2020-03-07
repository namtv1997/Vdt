package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface NDVBDanhSachVanBanDiView extends BaseView<NDVBDanhSachVanBanDiPresenter> {
    Context gContext();

    void onGetDuyetSuccess();

    void onGetXoaSuccess();
}
