package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBVanBanChoChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBVanBanChoChiDaoPresenterImpl extends BasePresenterImpl<NDVBVanBanChoChiDaoView> implements NDVBVanBanChoChiDaoPresenter {
    public NDVBVanBanChoChiDaoPresenterImpl(NDVBVanBanChoChiDaoView view) {
        super(view);
    }

    @Override
    public void getAllTruongPhongDonViCapHai(String nam) {
//        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllTruongPhongDonViCapHai(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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

                                getView().onGetGiamdocVaPhoGiamdocSuccess(arrayListResponseGiamDoc.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void getAllPhongBanDonViCapHai(String nam) {
//        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllPhongBanDonViCapHai(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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
    public void duyetVBChoChiDaoDonViCapHai(String nam, int id, int idLanhDao, String tenLanhDao, int idPhongChuTri,
                                            String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoChiDaoDonViCapHai(token, nam, id, idLanhDao, tenLanhDao, idPhongChuTri,
                tenPhongChuTri, idPhongPhoiHops, tenPhongPhoiHops, hanXuLy)
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
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });

    }

    @Override
    public void duyetVBDaChiDaoPhongChuaXuLyDonViCapHai(String nam, int id, int idLanhDao, String tenLanhDao, int idPhongChuTri, String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBDaChiDaoPhongChuaXuLyDonViCapHai(token, nam, id, idLanhDao, tenLanhDao, idPhongChuTri,
                tenPhongChuTri, idPhongPhoiHops, tenPhongPhoiHops, hanXuLy)
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
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });
    }

    @Override
    public void duyetVBChoChiDaoDonViCapHaiPhong(String nam, int id, int idPhongChuTri, String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoChiDaoDonViCapHaiPhong(token, nam, id, idPhongChuTri,
                tenPhongChuTri, idPhongPhoiHops, tenPhongPhoiHops, hanXuLy)
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
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });
    }

    @Override
    public void duyetVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String nam, int id, int idLanhDao, String tenLanhDao, int idPhongChuTri, String tenPhongChuTri, String idPhongPhoiHops, String tenPhongPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(token, nam, id, idLanhDao, tenLanhDao, idPhongChuTri,
                tenPhongChuTri, idPhongPhoiHops, tenPhongPhoiHops, hanXuLy)
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
                            getView().onGetDuyetSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }

                    }
                });
    }
}
