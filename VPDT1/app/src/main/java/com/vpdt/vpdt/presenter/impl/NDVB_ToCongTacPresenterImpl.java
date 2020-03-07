package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.NDVB_ToCongTac;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVB_ToCongTacView;
import com.vpdt.vpdt.presenter.NDVB_ToCongTac_Presenter;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVB_ToCongTacPresenterImpl extends BasePresenterImpl<NDVB_ToCongTacView> implements NDVB_ToCongTac_Presenter {
    public NDVB_ToCongTacPresenterImpl(NDVB_ToCongTacView view) {
        super(view);
    }


    @Override
    public void getbyidtocongtac(int id_vb) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getbyidtocongtac(token, id_vb, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<NDVB_ToCongTac>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<NDVB_ToCongTac> toCongTacResponse) {
                        Util.getIns().hideLoadding();
                        if (toCongTacResponse.getData() != null) {

                            if (toCongTacResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(toCongTacResponse.getData());

                            }
                        }

                    }
                });
    }

}
