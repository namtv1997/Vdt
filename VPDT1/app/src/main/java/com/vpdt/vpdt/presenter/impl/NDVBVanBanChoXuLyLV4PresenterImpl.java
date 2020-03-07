package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBVanBanChoXuLyLV4Presenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoXuLyLV4View;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBVanBanChoXuLyLV4PresenterImpl extends BasePresenterImpl<NDVBVanBanChoXuLyLV4View> implements NDVBVanBanChoXuLyLV4Presenter {
    public NDVBVanBanChoXuLyLV4PresenterImpl(NDVBVanBanChoXuLyLV4View view) {
        super(view);
    }

    @Override
    public void getAllChuyenVienDonViCapHai(String nam) {
//        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllChuyenVienDonViCapHai(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiamdocVaPhoGiamdoc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponsePhongBan) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhongBan.getData() != null) {

                            if (arrayListResponsePhongBan.getStatus() == 1) {

                                getView().onGetChuyenVienSuccess(arrayListResponsePhongBan.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void duyetVBChoXuLyPPChuTriDonViCapHai(String nam, int id, int idChuyenVien, String chiDaoChuyenVien,
                                                  String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoXuLyPPChuTriDonViCapHai(token, nam, id, idChuyenVien, chiDaoChuyenVien, idChuyenVienPhoiHops, chiDaoChuyenVienPhoiHops, hanXuLy)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });

    }

    @Override
    public void duyetVBChoXuLyPPhoiHopDonViCapHai(String nam, int id, int idChuyenVien, String chiDaoChuyenVien, String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoXuLyPPhoiHopDonViCapHai(token, nam, id, idChuyenVien, chiDaoChuyenVien, idChuyenVienPhoiHops, chiDaoChuyenVienPhoiHops, hanXuLy)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });
    }

    @Override
    public void duyetVBPhoiHopChoXuLyDonViCapHai(String nam, int id, int CT_PH, String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBPhoiHopChoXuLyDonViCapHai(token, nam, id, CT_PH, idChuyenVienPhoiHops, chiDaoChuyenVienPhoiHops, hanXuLy)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });
    }
}
