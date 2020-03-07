package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NoiDungDauViecHoanThanhBiTraLaiPresenter extends BasePresenter {
    void duyetDauViecHoanThanhBiTraLai(int id, int idLanhDao, String hanVanBan);

    void traLaiDauViecHoanThanhBiTraLai(int id, String noiDungTraLai);
}
