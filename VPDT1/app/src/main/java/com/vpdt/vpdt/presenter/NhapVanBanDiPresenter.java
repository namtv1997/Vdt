package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

import java.util.ArrayList;

public interface NhapVanBanDiPresenter extends BasePresenter {
    void nhapVB_suaVB(int id_vb);

    void getAllLoaiVanBan();

    void getlanhdaophong();

    void getallnoiduthao();

    void getAllNguoiKy();

    void getgetSokyhieu(int id_lvb, int sovb, int id_noiduthao);

    void getchucvu(int id_lanhdao);

    void them_capnhapVB(int id_vb, int soVB,
                        String ngay_thang, String linhvuc,
                        int sotrang, String soden, String trichyeu,
                        String ykien, String id_loaivanban, String id_lanhdaophong, String id_phongduthao,
                        ArrayList<String> email,
                        String email_ngoai,
                        String ngaymoi, String giomoi, String diadiemmoi,
                        int id_nguoiky, String skyhieu, String chucvu, int duthao);
}
