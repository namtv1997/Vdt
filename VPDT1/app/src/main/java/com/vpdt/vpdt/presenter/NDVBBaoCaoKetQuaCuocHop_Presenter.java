package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBBaoCaoKetQuaCuocHop_Presenter extends BasePresenter {
    void getgiaymoibyid(int id_vb);

    void getAllCanBoPhong();

    void duyettuchoibaocaokequacuochop(int id, int id_noidung, int id_vb, String ykien, int type);

    void chuyenTiepKeQuaBaoCaoCuocHop(int id, int id_noidung, int id_vb, String idCanBoNhans, String noiDungChuyen);
}
