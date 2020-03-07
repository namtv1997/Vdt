package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

import java.util.ArrayList;

public interface TTVBGiayMoiChoLDXLPresenter extends BasePresenter {
    void getgiaymoicholanhdaoxulybyid(int id_giaymoi);

    void xacnhanhoanthanhcv(int id_vb, String id_tk, String ketqua, ArrayList<String> linkfile);
}
