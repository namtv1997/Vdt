package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVBDaDeXuatGiaHanGiaiQuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenterImpl extends BasePresenterImpl<NDVB_DSVBDaDeXuatGiaHanGiaiQuyetView> implements NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenter {
    public NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenterImpl(NDVB_DSVBDaDeXuatGiaHanGiaiQuyetView view) {
        super(view);
    }

    @Override
    public void themHanVBDaDeXuatGiaHanGiaQuyet(int id, String hanDeXuat, String lyDo) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().themHanVBDaDeXuatGiaHanGiaQuyet(token, id, hanDeXuat, lyDo,
                PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                            getView().themHanVBDaDeXuatGiaHanGiaQuyet();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
