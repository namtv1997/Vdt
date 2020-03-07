package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DSVB_ChoSoCuaSo;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.LoaiVanBan_Nhap;
import com.vpdt.vpdt.model.NguoiKy_nhap;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.SelectNoiDuThao;

import java.util.ArrayList;

public interface NhapVanBanDiView extends BaseView<NhapVanBanDiPresenter> {
    Context gContext();

    void NhapVanBanDiSuccess(DSVB_ChoSoCuaSo dsvb_choSoCuaSo);

    void getAllLoaiVanBanSuccess(ArrayList<LoaiVanBan_Nhap> khuVucArrayList);

    void getgetallnoiduthaoSuccess(ArrayList<SelectNoiDuThao> selectNoiDuThaoArrayList);

    void onGetLanhDaoPhongSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc);

    void onGetallNguoiKySuccess(ArrayList<NguoiKy_nhap> giamdocVaPhoGiamdoc);

    void onGetKyHieuSuccess(Response<String> response);

    void onGetChucvuSuccess(Response<String> response);

    void onCapNhatSuccess();
}
