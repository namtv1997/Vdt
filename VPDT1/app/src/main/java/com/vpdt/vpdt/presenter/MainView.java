package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.CanBo;
import com.vpdt.vpdt.model.Contact;
import com.vpdt.vpdt.model.MenuLeft;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTheoLoaiNoiDen;

import java.util.ArrayList;

public interface MainView extends BaseView<MainPresenter> {
    Context gContext();

    void onGetDataSuccess(ArrayList<Contact> contacts);

    void onGetMenuLeftSuccess(ArrayList<MenuLeft> menuLefts);

    void onGetThongBaoSuccess(String s);

    void ongetAllTK_noidenSuccess(ArrayList<VanBanTheoLoaiNoiDen> vanBanTheoLoaiNoiDenArrayList);

    void onGetDataCanBoSuccess(CanBo canBo);

    void onLogOutSuccess();

    void onGetDataFail();

    void onGetCountVBSuccess(Response<Integer> response);
}