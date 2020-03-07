package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.PhongChuTriChuyenVienChoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DauViecPhongPhoiHopChoXuLyCVPHPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongPhoiHopChoXuLyCVPHView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DauViecPhongPhoiHopChoXuLyCVPHPresenterImpl extends BasePresenterImpl<DauViecPhongPhoiHopChoXuLyCVPHView> implements DauViecPhongPhoiHopChoXuLyCVPHPresenter {

    public DauViecPhongPhoiHopChoXuLyCVPHPresenterImpl(DauViecPhongPhoiHopChoXuLyCVPHView view) {
        super(view);
    }

    @Override
    public void getAllDauViecPhongPhoHopChoXuLyCV(String nam, boolean isChuyenVienPH) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongPhoHopChoXuLyCV(token, nam, isChuyenVienPH).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhongChuTriChuyenVienChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhongChuTriChuyenVienChoXuLy>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }
}