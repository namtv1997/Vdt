package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBDanhSachGiayMoiDenCuaSoPresenter;
import com.vpdt.vpdt.presenter.NDVBDanhSachGiayMoiDenCuaSoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBDanhSachGiayMoiDenCuaSoPresenterImpl extends BasePresenterImpl<NDVBDanhSachGiayMoiDenCuaSoView> implements NDVBDanhSachGiayMoiDenCuaSoPresenter {
    public NDVBDanhSachGiayMoiDenCuaSoPresenterImpl(NDVBDanhSachGiayMoiDenCuaSoView view) {
        super(view);
    }

    @Override
    public void getgiaymoibyid(int id_giaymoi) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getgiaymoibyid(token, id_giaymoi, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailGiayMoi>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailGiayMoi> detailGiayMoiResponse) {
                        Util.getIns().hideLoadding();
                        if (detailGiayMoiResponse.getData() != null) {

                            if (detailGiayMoiResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(detailGiayMoiResponse.getData());

                            }
                        }

                    }
                });
    }
}
