package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

import java.util.ArrayList;

public interface NDVBVanBanChuTriChoXuLyPresenter extends BasePresenter {
    void getCBxem_choxl();

    void tralaivanban_tp(int id_vb, String y_kien);

    void guilen(int id_vb, String id_ld,
                ArrayList<String> id_ld1, String y_kien);
}
