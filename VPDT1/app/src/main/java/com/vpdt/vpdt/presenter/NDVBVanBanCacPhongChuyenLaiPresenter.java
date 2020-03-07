package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanCacPhongChuyenLaiPresenter extends BasePresenter {
    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void duyetAllVanBanChuyenLai(int id, int idGiamDoc, int idPhoGiamDoc, int idPhongChuTri
            , String hanGiaiQuyet, String idPhongPhoiHop, String chiDaoGiamDoc,
                                 String chiDaoPhoGiamDoc, String chiChuTri, int isVBQT);
}
