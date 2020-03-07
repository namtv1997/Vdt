package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DetailDanhSachVanBanSoThamMuuTrinhThanhPho;

import java.util.ArrayList;

public interface DanhSachVBSoThamMuuTrinhTPView extends BaseView<DanhSachVBSoThamMuuTrinhTPPresenter> {
    Context gContext();

    void getDSPhongban_solgvb(ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> phongBanSoTaiChinhThamMuuTrinhThanhPhos);

    void ongetVBdi_thammuuSuccess(ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> detailDanhSachVanBanSoThamMuuTrinhThanhPhos);
}
