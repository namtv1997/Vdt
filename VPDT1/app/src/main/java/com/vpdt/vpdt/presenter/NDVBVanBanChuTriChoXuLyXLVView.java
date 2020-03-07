package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface NDVBVanBanChuTriChoXuLyXLVView extends BaseView<NDVBVanBanChuTriChoXuLyXLVBPresenter> {
    Context gContext();

    void onGetChuyenvienSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void duyetVanBanSuccess();

    void tuChoiVBChuTriChoXuLySuccess();

    void themHanVBChuTriChoXuLySuccess();
}
