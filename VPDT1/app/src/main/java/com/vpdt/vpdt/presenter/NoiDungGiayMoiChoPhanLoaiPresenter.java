package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungGiayMoiChoPhanLoaiPresenter extends BasePresenter {
    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void duyetGMChuaPhanLoai(int id, int idGiamDoc, int idPhoGiamDoc,
                             int idPhongChuTri, String hanGiaiQuyet,
                             String idPhongPhoiHop, String chiDaoGiamDoc,
                             String chiDaoPhoGiamDoc,
                             String chiChuTri, int giamDocDuHop, int PhongDuHop);

    void themNoidungGMChuaPhanLoai(int id, String noiDung,
                                   String ngayHop,
                                   String gioHop,
                                   String diaDiem);
}
