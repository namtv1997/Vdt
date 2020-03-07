package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface MainPresenter extends BasePresenter {
    void getCanBoDetail();

    void getAllTK_noiden();

    void countThongBao(int trangThai);

    void getMenu(String nam, String key, String is_right);

    void getMenuLeft(String nam);

    void logOut();

    void getThongBaoHome();
}
