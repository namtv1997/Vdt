package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;

import java.util.ArrayList;

public interface GiayMoiChoLanhDaoXuLyPresenter extends BasePresenter {
    void getallgiaymoicholanhdaoxuly(String nam, boolean isRefresh, String loaivanban, String sokyhieu,
                                     String donvi, String ngayky, String ngaynhap, String ngayden,
                                     String trichyeu, String nguoiky, String soden, String chucvu, String nguoinhap);

    void countgiaymoicholanhdaoxuly(String nam, String loaivanban, String sokyhieu,
                                    String donvi, String ngayky, String ngaynhap, String ngayden,
                                    String trichyeu, String nguoiky, String soden, String chucvu, String nguoinhap);

    ArrayList<GiayMoiChoLanhDaoXuLy> giayMoiChoLanhDaoXuLyArrayList();
}
