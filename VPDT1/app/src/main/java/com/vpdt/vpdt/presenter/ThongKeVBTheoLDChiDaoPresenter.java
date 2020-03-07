package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface ThongKeVBTheoLDChiDaoPresenter extends BasePresenter {
    void getsoluongvb_Theo_PGD(String nam);

    void getsoluongvb_Theo_PGD_select(String idUser, String nam);

    void getsoluongvb_Theo_Phongban(String nam);
}
