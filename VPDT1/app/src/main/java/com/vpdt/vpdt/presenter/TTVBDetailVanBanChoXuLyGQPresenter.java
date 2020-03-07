package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;

public interface TTVBDetailVanBanChoXuLyGQPresenter extends BasePresenter {

    void getDetailVanBanChoXuLyGQ(String nam, int id);

    void hoanThanhVBChoXuLyGQ(int id, String nam, String noiDung);

    void chamMuonVBChoXuLyGQ(int id, String nam, String noiDung);
}
