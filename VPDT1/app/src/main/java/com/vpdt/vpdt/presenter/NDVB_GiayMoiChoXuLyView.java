package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVB_GiayMoiChoXuLyView extends BaseView<NDVB_GiayMoiChoXuLyPresenter> {
    Context gContext();

    void onGetTruongPhongChiCucSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetChiCucPhoSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void duyetVBPhongChuTriChoXuLyCC();
}
