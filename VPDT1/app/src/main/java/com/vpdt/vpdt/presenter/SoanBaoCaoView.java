package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface SoanBaoCaoView extends BaseView<SoanBaoCaoPresenter> {
    Context gContext();

    void onGetCanBoByidPhongBanSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans);

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);

    void duyetSoanBaoCaoSuccess();
}

