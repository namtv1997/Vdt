package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDao;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDaoTheoPhong;

import java.util.ArrayList;

public interface ThongKeVBTheoLDChiDaoView extends BaseView<ThongKeVBTheoLDChiDaoPresenter> {
    Context gContext();

    void getsoluongvb_Theo_PGDSuccess(ArrayList<ThongKeLanhDaoChiDao> thongKeLanhDaoChiDaos);

    void getsoluongvb_Theo_PGDSelectSuccess(ArrayList<ThongKeLanhDaoChiDao> thongKeLanhDaoChiDaos);

    void getsoluongvb_Theo_PhongbanSuccess(ArrayList<ThongKeLanhDaoChiDaoTheoPhong> thongKeLanhDaoChiDaoTheoPhongs);
}
