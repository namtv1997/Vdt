package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;

import java.util.ArrayList;

public interface ChuyenTiepView extends BaseView<ChuyenTiepPresenter> {
    Context gContext();

    void onGetPhongBanSuccess(ArrayList<GiamdocVaPhoGiamdoc> phongBan);

    void onGetCanBoByIdPhongBanSuccess(ArrayList<CanBoByidPhongBan> canBoByidPhongBans);
}
