package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter;
import com.vpdt.vpdt.presenter.NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenterImpl extends BasePresenterImpl<NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopView> implements NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenter {
    public NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopPresenterImpl(NoiDungDauViecPhongChuTriChoXuLyPhoPhongPhoiHopView view) {
        super(view);
    }

    @Override
    public void getAllChuyenVien() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllChuyenVien(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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
                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetChuyenvienSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void duyetDauViecPhongChuTriChoXuLyTPPP(int id, String idChuyenVienPhoiHops, String tenChuyenVienPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetDauViecPhongChuTriChoXuLyTPPP(token, id, idChuyenVienPhoiHops, tenChuyenVienPhoiHops, hanXuLy, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
