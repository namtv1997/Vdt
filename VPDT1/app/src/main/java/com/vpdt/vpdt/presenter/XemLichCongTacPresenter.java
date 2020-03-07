package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface XemLichCongTacPresenter extends BasePresenter {
    void getAllTuan(String nam);

    void getlistCB_lanhdao();

    void getLichCongTac(int soTuan, String nam, int id_lanhdao);
}
