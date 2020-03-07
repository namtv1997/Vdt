package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVB_DSVB_QuaHanPresenter extends BasePresenter {
    void getbyidvbquahandolanhdaochidao(int id_vb);

    void themHanGiaiQuyetVBQuaHan(int id, String hanDeXuat, String ly_do);

    void tuChoiHanGiaiQuyetVBQuaHan(int id, String noiDungTuChoi, String ghiChu);

    void tuChoiTPVBQuaHan(int id, String noiDungTuChoi, String ghiChu);
}
