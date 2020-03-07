package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface BaoCaoTongHopPresenter extends BasePresenter {
    void getBaoCaoTongHop(String nam, String ngaybd, String ngaykt, int idphong, int vbtt);

    void getphongBcaoTongHop();
}
