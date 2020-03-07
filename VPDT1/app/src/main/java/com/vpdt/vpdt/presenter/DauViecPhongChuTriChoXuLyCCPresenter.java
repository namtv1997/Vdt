package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface DauViecPhongChuTriChoXuLyCCPresenter extends BasePresenter {
    void getAllDauViecPhongChuTriChoXuLyCC(String nam, boolean isPhoPhongPP);

    void getAllDauViecPhongPhoHopChoXuLyCC(String nam, boolean isPhoPhongPP);

    void getAllDauViecPhongChuTriDaXuLyCC(String nam, boolean isPhoPhongPP);

    void getAllDauViecPhongPhoHopDaXuLyCC(String nam, boolean isPhoPhongPP);
}
