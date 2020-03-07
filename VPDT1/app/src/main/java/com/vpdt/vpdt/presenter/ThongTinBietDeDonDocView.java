package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.PhongBan;

import java.util.ArrayList;

public interface ThongTinBietDeDonDocView extends BaseView<ThongTinBietDeDonDocPresenter> {
    Context gContext();

    void onGetPhongBanSuccess(ArrayList<PhongBan> phongBan);
}
