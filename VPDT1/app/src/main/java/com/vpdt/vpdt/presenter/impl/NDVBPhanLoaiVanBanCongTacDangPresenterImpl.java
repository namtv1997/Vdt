package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBPhanLoaiVanBanCongTacDangPresenter;
import com.vpdt.vpdt.presenter.NDVBPhanLoaiVanBanCongTacDangView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBPhanLoaiVanBanCongTacDangPresenterImpl extends BasePresenterImpl<NDVBPhanLoaiVanBanCongTacDangView> implements NDVBPhanLoaiVanBanCongTacDangPresenter {
    public NDVBPhanLoaiVanBanCongTacDangPresenterImpl(NDVBPhanLoaiVanBanCongTacDangView view) {
        super(view);
    }

    @Override
    public void getAllGiamDoc() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllGiamDoc(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiamdocVaPhoGiamdoc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponseGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponseGiamDoc.getData() != null) {

                            if (arrayListResponseGiamDoc.getStatus() == 1) {

                                getView().onGetGiamdoccSuccess(arrayListResponseGiamDoc.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void getAllPhoGiamDoc() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllPhoGiamDoc(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiamdocVaPhoGiamdoc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetPhoGiamdocSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void getAllPhongBan() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllPhongBan(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhongBan>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhongBan>> arrayListResponsePhongBan) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhongBan.getData() != null) {

                            if (arrayListResponsePhongBan.getStatus() == 1) {

                                getView().onGetPhongBanSuccess(arrayListResponsePhongBan.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void themNoidungVBCTDChuaPhanLoai(int id, String hanNoiDung, String noiDung) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().themNoidungVBCTDChuaPhanLoai(token, id, hanNoiDung, noiDung, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                            getView().themNoidungVBCTDChuaPhanLoai();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void duyetVBCTDChuaPhanLoai(int id, int idGiamDoc, int idPhoGiamDoc, int idPhongChuTri, String hanGiaiQuyet, String idPhongPhoiHop, String chiDaoGiamDoc, String chiDaoPhoGiamDoc, String chiChuTri, int isVBQT) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBCTDChuaPhanLoai(token, id, idGiamDoc, idPhoGiamDoc, idPhongChuTri, hanGiaiQuyet, idPhongPhoiHop, chiDaoGiamDoc, chiDaoPhoGiamDoc, chiChuTri, isVBQT,
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
                            getView().duyetVBCTDChuaPhanLoai();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
