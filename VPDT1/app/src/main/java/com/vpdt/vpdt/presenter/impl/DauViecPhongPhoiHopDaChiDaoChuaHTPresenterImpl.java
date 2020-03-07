package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriDaChiDaoChuaHT;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DauViecPhongPhoiHopDaChiDaoChuaHTPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongPhoiHopDaChiDaoChuaHTView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DauViecPhongPhoiHopDaChiDaoChuaHTPresenterImpl extends BasePresenterImpl<DauViecPhongPhoiHopDaChiDaoChuaHTView> implements DauViecPhongPhoiHopDaChiDaoChuaHTPresenter {
    public DauViecPhongPhoiHopDaChiDaoChuaHTPresenterImpl(DauViecPhongPhoiHopDaChiDaoChuaHTView view) {
        super(view);
    }

    @Override
    public void getAllDauViecPhongPhoHopDaChiDao(String nam, boolean isPhoPhongPP) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongPhoHopDaChiDao(token, nam, isPhoPhongPP).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().ongetAllDauViecPhongPhoHopDaChiDaoSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }
}
