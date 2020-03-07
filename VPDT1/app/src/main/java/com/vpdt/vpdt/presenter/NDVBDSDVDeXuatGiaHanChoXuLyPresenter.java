package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDSDVDeXuatGiaHanChoXuLyPresenter extends BasePresenter {
    void tuchoigiahan(int id, int id_vb, String ngay_dexuat, String ly_do);

    void dongygiahan(int id, int id_vb, String ngay_dexuat, String ykien_chidao);

    void deXuatGiaHanDauViecChoDuyetCV(int id, String ngayDeXuat, String lyDoDeXuat, int idDeXuat);
}
