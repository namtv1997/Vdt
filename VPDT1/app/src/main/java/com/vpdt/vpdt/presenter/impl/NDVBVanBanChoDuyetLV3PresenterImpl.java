package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBVanBanChoDuyetLV3Presenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoDuyetLV3View;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBVanBanChoDuyetLV3PresenterImpl extends BasePresenterImpl<NDVBVanBanChoDuyetLV3View> implements NDVBVanBanChoDuyetLV3Presenter {
    public NDVBVanBanChoDuyetLV3PresenterImpl(NDVBVanBanChoDuyetLV3View view) {
        super(view);
    }

    @Override
    public void duyetVBChoDuyetTPDonViCapHai(String nam, int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoDuyetTPDonViCapHai(token, nam, id)
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
