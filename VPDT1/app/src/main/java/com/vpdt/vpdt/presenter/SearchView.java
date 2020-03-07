package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.KhuVuc;
import com.vpdt.vpdt.model.LoaiVanBan_Nhap;
import com.vpdt.vpdt.model.NguoiKy_nhap;

import java.util.ArrayList;

public interface SearchView extends BaseView<SearchPresenter> {
    Context gContext();

    void getAllLoaiVanBanSuccess(ArrayList<LoaiVanBan_Nhap> khuVucArrayList);

    void onGetallNguoiKySuccess(ArrayList<NguoiKy_nhap> giamdocVaPhoGiamdoc);

    void getAllChucVuSuccess(ArrayList<KhuVuc> khuVucArrayList);
}
