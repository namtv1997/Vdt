package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailDeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBVanBanCongTacDangChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBVanBanCongTacDangChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBVanBanCongTacDangChoXuLyPresenterImpl extends BasePresenterImpl<TTVBVanBanCongTacDangChoXuLyView> implements TTVBVanBanCongTacDangChoXuLyPresenter {
    public TTVBVanBanCongTacDangChoXuLyPresenterImpl(TTVBVanBanCongTacDangChoXuLyView view) {
        super(view);
    }

    @Override
    public void luuketqua(int id_vb, String ketqua, int luuvaokho, String chammuon, int hoanthanh) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().luuketqua(token, id_vb, uid, ketqua, luuvaokho, chammuon, hoanthanh, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                            getView().onGetCongViecSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());

                        }
                    }
                });
    }

    @Override
    public void getDetailVBChuyenVienChuTriXuLy(int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDetailVBChuyenVienChuTriXuLy(token, id, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailDeXuatCongViecPhoiHopChoDuyet>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailDeXuatCongViecPhoiHopChoDuyet> dsvb_dachidaoResponse) {
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
