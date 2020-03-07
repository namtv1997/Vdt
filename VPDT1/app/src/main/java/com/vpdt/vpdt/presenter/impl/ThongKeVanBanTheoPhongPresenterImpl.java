package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.ThongKeTheoPhong;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ThongKeVanBanTheoPhongPresenter;
import com.vpdt.vpdt.presenter.ThongKeVanBanTheoPhongView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThongKeVanBanTheoPhongPresenterImpl extends BasePresenterImpl<ThongKeVanBanTheoPhongView> implements ThongKeVanBanTheoPhongPresenter {
    public ThongKeVanBanTheoPhongPresenterImpl(ThongKeVanBanTheoPhongView view) {
        super(view);
    }

    @Override
    public void getThongKeTheoPhong(String nam, String idlanhdao, String ngaynhaptu, String ngaynhapden) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getThongKeTheoPhong(token, uid, nam, idlanhdao, ngaynhaptu, ngaynhapden).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ThongKeTheoPhong>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<ThongKeTheoPhong>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().onGetDaDaSuccess(arrayListResponse.getData());

                            }
                        }
                    }

                });
    }
}
