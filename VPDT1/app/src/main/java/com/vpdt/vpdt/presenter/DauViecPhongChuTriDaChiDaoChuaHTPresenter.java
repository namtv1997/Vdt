package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface DauViecPhongChuTriDaChiDaoChuaHTPresenter extends BasePresenter {
    void getAllDauViecPhongChuTriDaChiDao(String nam, boolean isPhoPhongPP);

    void getAllDauViecPhongChuTriDaXuLyTPCC(String nam);

    void getAllDauViecDaChiDaoTruongPhongPhoHopCT(String nam);
}
