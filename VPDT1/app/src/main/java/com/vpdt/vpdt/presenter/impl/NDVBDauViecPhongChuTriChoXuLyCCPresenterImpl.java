package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.MucDanhGia;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyCCPresenter;
import com.vpdt.vpdt.presenter.NDVBDauViecPhongChuTriChoXuLyCCView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBDauViecPhongChuTriChoXuLyCCPresenterImpl extends BasePresenterImpl<NDVBDauViecPhongChuTriChoXuLyCCView> implements NDVBDauViecPhongChuTriChoXuLyCCPresenter {
    public NDVBDauViecPhongChuTriChoXuLyCCPresenterImpl(NDVBDauViecPhongChuTriChoXuLyCCView view) {
        super(view);
    }

    @Override
    public void getAllPhongBanChiCuc() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllPhongBanChiCuc(token).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<MucDanhGia>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<MucDanhGia>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetPhongBanChiCucSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }


    @Override
    public void duyetDauViecPhongChuTriChoXuLyCC(String nam, int id, int idPhongBan, String tenPhongBan, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetDauViecPhongChuTriChoXuLyCC(token, nam, id, idPhongBan, tenPhongBan, idPhongPhoiHops, tenPhongPhoiHop, hanXuLy)
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
                            getView().onDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void duyetDauViecPhongChuTriDaXuLyCC(String nam, int id, int idPhongBan, String tenPhongBan, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetDauViecPhongChuTriDaXuLyCC(token, nam, id, idPhongBan, tenPhongBan, idPhongPhoiHops, tenPhongPhoiHop, hanXuLy)
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
                            getView().onDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void duyetDauViecPhongPhoHopChoXuLyCC(String nam, int id, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetDauViecPhongPhoHopChoXuLyCC(token, nam, id, idPhongPhoiHops, tenPhongPhoiHop, hanXuLy)
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
                            getView().onDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void duyetDauViecPhongPhoHopDaXuLyCC(String nam, int id, String idPhongPhoiHops, String tenPhongPhoiHop, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetDauViecPhongPhoHopDaXuLyCC(token, nam, id, idPhongPhoiHops, tenPhongPhoiHop, hanXuLy)
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
                            getView().onDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
