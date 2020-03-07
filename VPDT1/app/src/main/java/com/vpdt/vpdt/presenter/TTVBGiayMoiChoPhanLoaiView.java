package com.vpdt.vpdt.presenter;

import android.content.Context;

import com.vpdt.vpdt.base.BaseView;
import com.vpdt.vpdt.model.DoMat;
import com.vpdt.vpdt.model.GiayMoiCapNhat;
import com.vpdt.vpdt.model.KhuVuc;

import java.util.ArrayList;

public interface TTVBGiayMoiChoPhanLoaiView extends BaseView<TTVBGiayMoiChoPhanLoaiPresenter> {
    Context gContext();

    void getDoKhanSuccess(ArrayList<DoMat> doMatArrayList);

    void getDoMatSuccess(ArrayList<DoMat> doMatArrayList);

    void getGMCapNhatSucsess(GiayMoiCapNhat giayMoiCapNhat);

    void getKhuVucSuccess(ArrayList<KhuVuc> khuVucArrayList);

    void getAllLoaiVanBanSuccess(ArrayList<KhuVuc> khuVucArrayList);

    void getAllChucVuSuccess(ArrayList<KhuVuc> khuVucArrayList);

    void getAllNguoiKyVBSuccess(ArrayList<KhuVuc> khuVucArrayList);

    void getAllLinhVucSuccess(ArrayList<KhuVuc> khuVucArrayList);

    void getAllDonViSuccess(ArrayList<KhuVuc> khuVucArrayList);

    void capNhatSuccess();

}
