package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ChuyenTiepPresenter;
import com.vpdt.vpdt.presenter.ChuyenTiepView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ChuyenTiepPresenterImpl extends BasePresenterImpl<ChuyenTiepView> implements ChuyenTiepPresenter {
    public ChuyenTiepPresenterImpl(ChuyenTiepView view) {
        super(view);
    }

//    @Override
//    public void getAllChuyenVien() {
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        NetworkModule.getService().getAllChuyenVien(token).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<GiamdocVaPhoGiamdoc>>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Util.getIns().hideLoadding();
//                    }
//
//                    @Override
//                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponsePhoGiamDoc) {
//                        Util.getIns().hideLoadding();
//                        if (arrayListResponsePhoGiamDoc.getData()!=null){
//
//                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {
//
//                                getView().onGetChuyenvienSuccess(arrayListResponsePhoGiamDoc.getData());
//
//                            }
//                        }
//
//                    }
//                });
//    }

    @Override
    public void getAllPhongBan() {
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllPhoPhongBan(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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
                                getView().onGetPhongBanSuccess(arrayListResponsePhoGiamDoc.getData());
                            }
                        }
                    }
                });
    }

    @Override
    public void getAllCanBoByIdPhongBan(int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllCanBoByIdPhongBan(token, id, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<CanBoByidPhongBan>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<CanBoByidPhongBan>> arrayListResponsePhongBan) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhongBan.getData() != null) {

                            if (arrayListResponsePhongBan.getStatus() == 1) {

                                getView().onGetCanBoByIdPhongBanSuccess(arrayListResponsePhongBan.getData());

                            }
                        }

                    }
                });
    }
}
