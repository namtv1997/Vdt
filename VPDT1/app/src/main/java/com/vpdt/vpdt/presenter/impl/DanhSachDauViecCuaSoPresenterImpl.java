package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailDauViecCuaSo;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachDauViecCuaSoPresenter;
import com.vpdt.vpdt.presenter.DanhSachDauViecCuaSoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachDauViecCuaSoPresenterImpl extends BasePresenterImpl<DanhSachDauViecCuaSoView> implements DanhSachDauViecCuaSoPresenter {
    public DanhSachDauViecCuaSoPresenterImpl(DanhSachDauViecCuaSoView view) {
        super(view);
    }

    @Override
    public void gettkdauviec() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().gettkdauviec(token, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailDauViecCuaSo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<DetailDauViecCuaSo> detailLichHopResponse) {
                        Util.getIns().hideLoadding();
                        if (detailLichHopResponse.getData() != null) {

                            if (detailLichHopResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(detailLichHopResponse.getData());

                            }
                        }

                    }
                });
    }
}
