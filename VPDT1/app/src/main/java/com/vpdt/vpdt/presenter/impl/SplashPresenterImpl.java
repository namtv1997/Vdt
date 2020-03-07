package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.CanBo;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.SplashPresenter;
import com.vpdt.vpdt.presenter.SplashView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashPresenterImpl extends BasePresenterImpl<SplashView> implements SplashPresenter {


    public SplashPresenterImpl(SplashView view) {
        super(view);
    }

    @Override
    public void getCanBoDetail() {

        String token = PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getCanBo(token, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<CanBo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onGetDataFail();
                    }

                    @Override
                    public void onNext(Response<CanBo> userResponse) {
                        Util.getIns().hideLoadding();
                        if (userResponse.getStatus() == 1) {
                            PrefUtil.saveDataCanBo(userResponse.getData(), getView().gContext());
                            getView().onGetDataSuccess();
                        } else {
                            getView().onGetDataFail();
                        }

                    }

                });
    }
}
