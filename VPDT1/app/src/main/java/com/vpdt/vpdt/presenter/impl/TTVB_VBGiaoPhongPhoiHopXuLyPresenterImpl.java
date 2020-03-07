package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVbphongPhoiHopChoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVB_VBGiaoPhongPhoiHopXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVB_VBGiaoPhongPhoiHopXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVB_VBGiaoPhongPhoiHopXuLyPresenterImpl extends BasePresenterImpl<TTVB_VBGiaoPhongPhoiHopXuLyView> implements TTVB_VBGiaoPhongPhoiHopXuLyPresenter {
    public TTVB_VBGiaoPhongPhoiHopXuLyPresenterImpl(TTVB_VBGiaoPhongPhoiHopXuLyView view) {
        super(view);
    }

    @Override
    public void getVBPhongPhoiHopChoXuLyById(int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getVBPhongPhoiHopChoXuLyById(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""), id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailVbphongPhoiHopChoXuLy>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailVbphongPhoiHopChoXuLy> detailVbphongPhoiHopChoXuLyResponse) {
                        Util.getIns().hideLoadding();
                        if (detailVbphongPhoiHopChoXuLyResponse.getData() != null) {

                            if (detailVbphongPhoiHopChoXuLyResponse.getStatus() == 1) {

                                getView().ongetVBPhongPhoiHopChoXuLyByIdSuccess(detailVbphongPhoiHopChoXuLyResponse.getData());

                            }
                        }
                    }
                });
    }

    @Override
    public void hoanThanhVBPhongPhoiHopChoXuLy(int id, String ketQua) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().hoanThanhVBPhongPhoiHopChoXuLy(token, id, ketQua, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                            getView().duyetVanBanSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void xoaKQPhongTL(String id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().xoaKQPhongTL(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""), id)
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
                            getView().xoaKQPhongTLSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
