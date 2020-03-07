package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.InSoLuuTruVanBanDen;

import java.util.ArrayList;

public interface InSoLuuTruVanBanDenPresenter extends BasePresenter {
    void getInSoLuuTru_den(String nam, String sodentu, String sodenden, String ngaynhaptu, String ngaynhapden, boolean isRefresh);

    void countInSoLuuTru_den(String nam, String sodentu, String sodenden, String ngaynhaptu, String ngaynhapden);

    ArrayList<InSoLuuTruVanBanDen> inSoLuuTruVanBanDenArrayList();
}
