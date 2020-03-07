package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.ThongBao;

import java.util.ArrayList;

public interface ThongBaoPresenter extends BasePresenter {
    void getAllThongBao(boolean isRefresh);

    void UpdateThongBao(int id);

    void countThongBao(int trangThai);

    ArrayList<ThongBao> THONG_BAO_ARRAY_LIST();
}
