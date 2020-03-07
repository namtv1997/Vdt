package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_GMGiaoPhongPhoiHopDaChiDaoPresenter extends BasePresenter {
    void getAllPhoPhongBan();

    void getAllChuyenVien();

    void duyetAllGMGiaoPhongPhoiHopDaChiDao(int id, int idPhoPhong, String idPhoPhongPhoiHops,
                                            String idChuyenVienPhoiHops, String chiDao,
                                            String chiDaoChuTri, String hanGiaiQuyet);
}
