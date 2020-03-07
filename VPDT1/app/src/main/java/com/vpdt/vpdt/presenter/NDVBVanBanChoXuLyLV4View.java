package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVBVanBanChoXuLyLV4View extends BaseView<NDVBVanBanChoXuLyLV4Presenter> {
    Context gContext();

    void onGetChuyenVienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetDuyetSuccess();
}
