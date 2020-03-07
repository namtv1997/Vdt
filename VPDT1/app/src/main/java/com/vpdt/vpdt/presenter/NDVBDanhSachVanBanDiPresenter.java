package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDanhSachVanBanDiPresenter extends BasePresenter {
    void duyetVBDiDonViCapHai(String nam, int id, String ngayVBDi);

    void deleteVBDiDonViCapHai(String nam, int idvb);

}
