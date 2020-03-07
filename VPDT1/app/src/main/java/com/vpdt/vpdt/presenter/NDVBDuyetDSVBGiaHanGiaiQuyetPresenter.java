package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDuyetDSVBGiaHanGiaiQuyetPresenter extends BasePresenter {
    void getbyidvbgiahangiaquyet(int id_vb);

    void duyetvbgiahangiaquyet(int id_vb, String handexuat);

    void tuchoihangiaiquetvanban(int id_vb, String lydo);

    void duyetVBGiaHanGiaQuyetCB(int id_vb, String ly_do, String hanGiaiQuyet);

    void duyetVBGiaHanGiaQuyetTP(int id_vb, String ly_do, String hanGiaiQuyet);

}
