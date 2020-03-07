package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.PhanLoaiCongChucCuaPhongTheoThang;

import java.util.ArrayList;

public interface PhanLoaiCongChucCuaPhongTheoThangView extends BaseView<PhanLoaiCongChucCuaPhongTheoThangPresenter> {
    Context gContext();

    void onGetPhanLoaiCongChucTeoThangSuccess(ArrayList<PhanLoaiCongChucCuaPhongTheoThang> phanLoaiCongChucCuaPhongTheoThangs);
}
