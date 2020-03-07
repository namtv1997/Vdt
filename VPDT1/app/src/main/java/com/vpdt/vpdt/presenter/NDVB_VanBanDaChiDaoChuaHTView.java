package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVB_VanBanDaChiDaoChuaHTView extends BaseView<NDVB_VanBanDaChiDaoChuaHTPresenter> {
    Context gContext();

    void onGetTruongPhongChiCucSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetChiCucPhoSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void duyetVBPhongChuTriChoXuLyCC();
}
