package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DSDauViecPhongChuTriDaXuLyCC;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.DauViecPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.DauViecPhongPhoiHopChoXuLyCC;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyCCPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyCCView;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DauViecPhongChuTriChoXuLyCCPresenterImpl extends BasePresenterImpl<DauViecPhongChuTriChoXuLyCCView> implements DauViecPhongChuTriChoXuLyCCPresenter {
    public DauViecPhongChuTriChoXuLyCCPresenterImpl(DauViecPhongChuTriChoXuLyCCView view) {
        super(view);
    }

    @Override
    public void getAllDauViecPhongChuTriChoXuLyCC(String nam, boolean isPhoPhongPP) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongChuTriChoXuLyCC(token, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DauViecPhongChuTriChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DauViecPhongChuTriChoXuLy>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllDauViecPhongPhoHopChoXuLyCC(String nam, boolean isPhoPhongPP) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongPhoHopChoXuLyCC(token, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DauViecPhongPhoiHopChoXuLyCC>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DauViecPhongPhoiHopChoXuLyCC>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetPhoiHopSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllDauViecPhongChuTriDaXuLyCC(String nam, boolean isPhoPhongPP) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongChuTriDaXuLyCC(token, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DSDauViecPhongChuTriDaXuLyCC>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DSDauViecPhongChuTriDaXuLyCC>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetDSChuTriSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllDauViecPhongPhoHopDaXuLyCC(String nam, boolean isPhoPhongPP) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongPhoHopDaXuLyCC(token, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DauViecPhongPhoiHopChoXuLyCC>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DauViecPhongPhoiHopChoXuLyCC>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetPhoiHopSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }
}
