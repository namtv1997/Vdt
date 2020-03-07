package com.vpdt.vpdt.presenter.impl;


import android.content.Context;
import android.content.SharedPreferences;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DoiMatKhauPresenter;
import com.vpdt.vpdt.presenter.DoiMatKhauView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DoiMatKhauPresenterImpl extends BasePresenterImpl<DoiMatKhauView> implements DoiMatKhauPresenter {

    public DoiMatKhauPresenterImpl(DoiMatKhauView view) {
        super(view);
    }

    @Override
    public void doiMatKhau(String nam, String currenPassword, String newPassword) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().doiMatKhau(token, nam, currenPassword, newPassword)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onFailure();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().onSuccess();
                        } else {
                            getView().onFailure();
                        }
                    }
                });
    }

    @Override
    public void logOut() {
        Util.getIns().showLoadding(getView().gContext());
        String token_fire = PrefUtil.getString(getView().gContext(), Key.TOKEN_FIRE, "");
        if (token_fire == null || token_fire.isEmpty()) {
            token_fire = "null123456";
        }
        NetworkModule.getService().dangXuat(token_fire)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            SharedPreferences preferences = getView().gContext().getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = preferences.edit();
                            editor.remove(Key.Refresh_token);
                            editor.remove(Key.DATA_USER);
                            editor.clear();
                            editor.apply();
                            getView().onLogOutSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

}
