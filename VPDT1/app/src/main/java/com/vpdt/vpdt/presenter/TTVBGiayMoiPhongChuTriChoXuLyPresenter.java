package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBGiayMoiPhongChuTriChoXuLyPresenter extends BasePresenter {
    void getDetailGMChuyenVienChuTriXuLy(int id);

    void hoanThanhGMChuyenVienChuTriXuLy(int id, String ketQua, String tenFileBaoCao);

    void xoaKQPhongTL(String id);
}
