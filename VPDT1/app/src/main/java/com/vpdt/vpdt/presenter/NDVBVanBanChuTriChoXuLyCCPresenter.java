package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBVanBanChuTriChoXuLyCCPresenter extends BasePresenter {
    void getAllTruongPhongBan(String nam);

    void traLaiVBChuTriChoXuLyCC(String nam, int id, String yKien);

    void guiLenVBChuTriChoXuLyCC(String nam, int id, int idLanhDao, String yKien);
}
