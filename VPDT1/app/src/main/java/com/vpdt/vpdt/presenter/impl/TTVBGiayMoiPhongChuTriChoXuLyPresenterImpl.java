package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailGiayMoiPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBGiayMoiPhongChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.TTVBGiayMoiPhongChuTriChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBGiayMoiPhongChuTriChoXuLyPresenterImpl extends BasePresenterImpl<TTVBGiayMoiPhongChuTriChoXuLyView> implements TTVBGiayMoiPhongChuTriChoXuLyPresenter {
    public TTVBGiayMoiPhongChuTriChoXuLyPresenterImpl(TTVBGiayMoiPhongChuTriChoXuLyView view) {
        super(view);
    }

    @Override
    public void getDetailGMChuyenVienChuTriXuLy(int id) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDetailGMChuyenVienChuTriXuLy(token, id, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailGiayMoiPhongChuTriChoXuLy>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailGiayMoiPhongChuTriChoXuLy> dsvb_dachidaoResponse) {
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
    public void hoanThanhGMChuyenVienChuTriXuLy(int id, String ketQua, String tenFileBaoCao) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().hoanThanhGMChuyenVienChuTriXuLy(token, id, ketQua, tenFileBaoCao, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                            getView().hoanThanhGMChuyenVienChuTriXuLySuccess();
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
