package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DSVB_TheoPhong;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DSVB_TheoPhongPresenter;
import com.vpdt.vpdt.presenter.DSVB_TheoPhongView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DSVB_TheoPhongPresenterImpl extends BasePresenterImpl<DSVB_TheoPhongView> implements DSVB_TheoPhongPresenter {
    public DSVB_TheoPhongPresenterImpl(DSVB_TheoPhongView view) {
        super(view);
    }

    @Override
    public void thongke(String nam, String ngaybatdau, String ngayketthuc) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().Thongke(token, nam, uid, ngaybatdau, ngayketthuc).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DSVB_TheoPhong>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DSVB_TheoPhong>> arrayListResponse) {
                        Util.getIns().hideLoadding();
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
