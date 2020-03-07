package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailVbphongPhoiHopChoXuLy;

public interface TTVB_VBGiaoPhongPhoiHopXuLyView extends BaseView<TTVB_VBGiaoPhongPhoiHopXuLyPresenter> {
    Context gContext();

    void ongetVBPhongPhoiHopChoXuLyByIdSuccess(DetailVbphongPhoiHopChoXuLy detailVbphongPhoiHopChoXuLy);

    void xoaKQPhongTLSuccess();

    void duyetVanBanSuccess();
}
