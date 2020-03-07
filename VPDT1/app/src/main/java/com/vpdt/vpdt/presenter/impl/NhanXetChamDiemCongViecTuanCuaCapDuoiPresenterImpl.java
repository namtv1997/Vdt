package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.NhanXetChamDiemCongViecTuanCuaCapDuoi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter;
import com.vpdt.vpdt.presenter.NhanXetChamDiemCongViecTuanCuaCapDuoiView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NhanXetChamDiemCongViecTuanCuaCapDuoiPresenterImpl extends BasePresenterImpl<NhanXetChamDiemCongViecTuanCuaCapDuoiView> implements NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter {
    public NhanXetChamDiemCongViecTuanCuaCapDuoiPresenterImpl(NhanXetChamDiemCongViecTuanCuaCapDuoiView view) {
        super(view);
    }

    @Override
    public void getDanhSachCB_CTtuan(String nam, int tuan, int idphong) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDanhSachCB_CTtuan(token, uid, nam, tuan, idphong)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi>> detailLichHopResponse) {
                        Util.getIns().hideLoadding();
                        if (detailLichHopResponse.getData() != null) {

                            if (detailLichHopResponse.getStatus() == 1) {

                                getView().onGetKeHoachCongTacTuanSuccess(detailLichHopResponse.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getDanhSachChuyenVien_CTtuan(String nam, int tuan, int idphong) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDanhSachChuyenVien_CTtuan(token, uid, nam, tuan, idphong)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi>> detailLichHopResponse) {
                        Util.getIns().hideLoadding();
                        if (detailLichHopResponse.getData() != null) {

                            if (detailLichHopResponse.getStatus() == 1) {

                                getView().onGetKeHoachCongTacTuan1Success(detailLichHopResponse.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllTuan(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllTuan(token, nam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<String>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<String>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        getView().onGetTuanSuccess(arrayListResponse.getData());
                    }
                });
    }
}
