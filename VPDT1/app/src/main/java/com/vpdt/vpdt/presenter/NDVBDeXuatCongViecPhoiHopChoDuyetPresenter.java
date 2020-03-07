package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface NDVBDeXuatCongViecPhoiHopChoDuyetPresenter extends BasePresenter {
    void guiLenDeXuatCV(int idVB, int IdPhongPhoiHop, String yKien, String urlFileYeuCau);

    void traLaiDeXuatCV(int idVB, int IdPhongPhoiHop, String yKien, String urlFileYeuCau);

    void dongYDeXuatCV(int idVB, int IdPhongPhoiHop);

    void guiLenDeXuatCVTPCC(String nam, int idVB, int IdPhongPhoiHop, String yKien, String urlFileYeuCau);

    void traLaiDeXuatCVTPCC(String nam, int idVB, int IdPhongPhoiHop, String yKien, String urlFileYeuCau);
}
