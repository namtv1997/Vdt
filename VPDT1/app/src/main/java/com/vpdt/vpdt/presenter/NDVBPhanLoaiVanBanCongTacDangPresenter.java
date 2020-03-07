package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBPhanLoaiVanBanCongTacDangPresenter extends BasePresenter {
    void getAllGiamDoc();

    void getAllPhoGiamDoc();

    void getAllPhongBan();

    void themNoidungVBCTDChuaPhanLoai(int id, String hanNoiDung, String noiDung);

    void duyetVBCTDChuaPhanLoai(int id, int idGiamDoc, int idPhoGiamDoc, int idPhongChuTri
            , String hanGiaiQuyet, String idPhongPhoiHop, String chiDaoGiamDoc,
                                String chiDaoPhoGiamDoc, String chiChuTri, int isVBQT);
}
