package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.BaoCaoTongHop;
import com.vpdt.vpdt.model.PhongBaoCaoTongHop;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.BaoCaoTongHopPresenter;
import com.vpdt.vpdt.presenter.BaoCaoTongHopView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BaoCaoTongHopPresenterImpl extends BasePresenterImpl<BaoCaoTongHopView> implements BaoCaoTongHopPresenter {
    public BaoCaoTongHopPresenterImpl(BaoCaoTongHopView view) {
        super(view);
    }

    @Override
    public void getBaoCaoTongHop(String nam, String ngaybd, String ngaykt, int idphong, int vbtt) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getBaoCaoTongHop(token, uid, nam, ngaybd, ngaykt, idphong, vbtt).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<BaoCaoTongHop>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<BaoCaoTongHop>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().onGetDaDaSuccess(arrayListResponse.getData());

                            }
                        }
                    }

                });
    }

//    @Override
//    public void getBaoCaoTongHop(String nam, String ngaybd, String ngaykt, int idphong, int vbtt) {
//
//    }

    @Override
    public void getphongBcaoTongHop() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getphongBcaoTongHop(token, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhongBaoCaoTongHop>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhongBaoCaoTongHop>> arrayListResponsePhongBan) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhongBan.getData() != null) {

                            if (arrayListResponsePhongBan.getStatus() == 1) {

                                getView().onGetPhongBaoCaoTongHopSuccess(arrayListResponsePhongBan.getData());

                            }
                        }

                    }
                });
    }
}
