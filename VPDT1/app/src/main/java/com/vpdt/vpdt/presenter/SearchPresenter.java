package com.vpdt.vpdt.presenter;

import com.vpdt.vpdt.base.BasePresenter;
import com.vpdt.vpdt.model.BaoCaoCuocHopChoPheDuyet;

import java.util.ArrayList;

public interface SearchPresenter extends BasePresenter {
    void getAllLoaiVanBan(String nam);
    void getAllNguoiKy();
    void getAllChucVu();
}
