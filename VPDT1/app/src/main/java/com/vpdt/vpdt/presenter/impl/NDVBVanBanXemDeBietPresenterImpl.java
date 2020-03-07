package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBVanBanXemDeBietPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanXemDeBietView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBVanBanXemDeBietPresenterImpl extends BasePresenterImpl<NDVBVanBanXemDeBietView> implements NDVBVanBanXemDeBietPresenter {
    public NDVBVanBanXemDeBietPresenterImpl(NDVBVanBanXemDeBietView view) {
        super(view);
    }

    @Override
    public void getdetailvanbanbyid(int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getdetailvanbanbyid(token, id, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailVanBanDi>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailVanBanDi> dsvb_daChiDaoResponse) {
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
