package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanChoXuLyGQ;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBDetailVanBanChoXuLyGQPresenter;
import com.vpdt.vpdt.presenter.TTVBDetailVanBanChoXuLyGQView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBDetailCanbanChoXuLyGQPresenterImpl extends BasePresenterImpl<TTVBDetailVanBanChoXuLyGQView> implements TTVBDetailVanBanChoXuLyGQPresenter {
    public TTVBDetailCanbanChoXuLyGQPresenterImpl(TTVBDetailVanBanChoXuLyGQView view) {
        super(view);
    }

    @Override
    public void getDetailVanBanChoXuLyGQ(String nam, int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDetailVanBanChoXuLyGQ(token, nam, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailVanBanChoXuLyGQ>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailVanBanChoXuLyGQ> dsvb_dachidaoResponse) {
                        Util.getIns().hideLoadding();
                        if (dsvb_dachidaoResponse.getData() != null) {

                            if (dsvb_dachidaoResponse.getStatus() == 1) {

                                getView().onGetDaTaSuccess(dsvb_dachidaoResponse.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void hoanThanhVBChoXuLyGQ(int id, String nam, String noiDung) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().hoanThanhVBChoXuLyGQ(token, id, nam, noiDung)
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
                            getView().hoanThanhSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void chamMuonVBChoXuLyGQ(int id, String nam, String noiDung) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().chamMuonVBChoXuLyGQ(token, id, nam, noiDung)
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
                            getView().chamMuonSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
