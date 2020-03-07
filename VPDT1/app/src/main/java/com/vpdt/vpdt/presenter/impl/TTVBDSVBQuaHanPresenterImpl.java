package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanQuahan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBDSVBQuaHanPresenter;
import com.vpdt.vpdt.presenter.TTVBDSVBQuaHanView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBDSVBQuaHanPresenterImpl extends BasePresenterImpl<TTVBDSVBQuaHanView> implements TTVBDSVBQuaHanPresenter {
    public TTVBDSVBQuaHanPresenterImpl(TTVBDSVBQuaHanView view) {
        super(view);
    }

    @Override
    public void getDetailbyidvbquahandolanhdaochidao(int id_vb) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getDetailbyidvbquahandolanhdaochidao(token, id_vb, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailVanBanQuahan>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailVanBanQuahan> dsvb_daChiDaoResponse) {
                        Util.getIns().hideLoadding();
                        if (dsvb_daChiDaoResponse.getData() != null) {

                            if (dsvb_daChiDaoResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(dsvb_daChiDaoResponse.getData());

                            }
                        }

                    }
                });

    }
}
