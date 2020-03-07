package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailDauViec1;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBDauViecChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBDauViecChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBDauViecChoXuLyPresenterImpl extends BasePresenterImpl<TTVBDauViecChoXuLyView> implements TTVBDauViecChoXuLyPresenter {
    public TTVBDauViecChoXuLyPresenterImpl(TTVBDauViecChoXuLyView view) {
        super(view);
    }

    @Override
    public void getdauviecdetail(int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getdauviecdetail(token, id, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailDauViec1>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailDauViec1> dsvb_daChiDaoResponse) {
                        Util.getIns().hideLoadding();
                        if (dsvb_daChiDaoResponse.getData() != null) {

                            if (dsvb_daChiDaoResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(dsvb_daChiDaoResponse.getData());

                            }
                        }
                    }
                });
    }

    @Override
    public void hoanThanhDauViec(int id, String noiDungHoanThanh) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().hoanThanhDauViec(token, id, noiDungHoanThanh, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
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
                            getView().onHoanThanhSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
