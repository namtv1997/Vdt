package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface NDVBVanBanChoXuLyLV3View extends BaseView<NDVBVanBanChoXuLyLV3Presenter> {
    Context gContext();

    void onGetChuyenVienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetPhoPhongSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetDuyetSuccess();
}
