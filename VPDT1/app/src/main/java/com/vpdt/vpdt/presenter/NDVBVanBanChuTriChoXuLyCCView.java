package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVBVanBanChuTriChoXuLyCCView extends BaseView<NDVBVanBanChuTriChoXuLyCCPresenter> {
    Context gContext();

    void onGetTruongPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void tralaiSuccess();

    void guilenSuccess();
}
