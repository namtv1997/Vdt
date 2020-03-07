package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.DauViecDeXuat;
import com.vpdt.vpdt.model.DeXuatGiaHanChoDuyet;

import java.util.ArrayList;

public interface DanhSachDauViecDeXuatGiaHanPresenter extends BasePresenter {
    void getalldauviecdexuatgiahan(String nam, int trang_thai, boolean isRefresh);

    void coutalldauviecdexuatgiahan(String nam, int trang_thai);

    void getAllDauViecDeXuatGiaHanChoDuyetCV(String nam, int trang_thai, boolean isRefresh);

    void countAllDauViecDeXuatGiaHanChoDuyetCV(String nam, int trang_thai);

    ArrayList<DeXuatGiaHanChoDuyet> deXuatGiaHanChoDuyetArrayList();

    ArrayList<DauViecDeXuat> dauviecdexuatArraylist();
}
