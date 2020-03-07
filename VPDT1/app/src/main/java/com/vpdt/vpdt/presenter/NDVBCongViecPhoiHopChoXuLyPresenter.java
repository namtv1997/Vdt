package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBCongViecPhoiHopChoXuLyPresenter extends BasePresenter {
    void getAllCanBoPhong();

    void guiLenCVPhoiHopChoXuLy(int idVB, int IdPhongPhoiHop, int IdCBGiaQuyet, String yKien, String urlFileYeuCau);

    void dongYCVPhoiHopChoXuLy(int idVB, int IdPhongPhoiHop, String yKien, String urlFileTraLoi, String urlFileYeuCau);

    void traLaiCVPhoiHopChoXuLy(int idVB, int IdPhongPhoiHop, String yKien, String urlFileYeuCau);

    void traLaiDeXuatPhoiHopTPCC(String nam, int idVB, int IdPhongPhoiHop, String yKien, String urlFileYeuCau);
}
