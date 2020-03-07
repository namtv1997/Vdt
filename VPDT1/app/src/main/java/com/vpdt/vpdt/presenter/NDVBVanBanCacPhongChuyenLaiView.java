package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface NDVBVanBanCacPhongChuyenLaiView extends BaseView<NDVBVanBanCacPhongChuyenLaiPresenter> {
    Context gContext();

    void onGetGiamdoccSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhoGiamdocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void duyetVBCTDChuaPhanLoai();
}
