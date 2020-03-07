package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBGiayMoiLanhDaoDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBGiayMoiLanhDaoDaChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBGiayMoiLanhDaoDaChiDaoPresenterImpl extends BasePresenterImpl<NDVBGiayMoiLanhDaoDaChiDaoView> implements NDVBGiayMoiLanhDaoDaChiDaoPresenter {
    public NDVBGiayMoiLanhDaoDaChiDaoPresenterImpl(NDVBGiayMoiLanhDaoDaChiDaoView view) {
        super(view);
    }

    @Override
    public void getgiaymoilanhdaodachidaobyid(int id_giaymoi) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getgiaymoilanhdaodaxulybyid(token, id_giaymoi, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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

                                getView().onGetGiamdocVaPhoGiamdocSuccess(arrayListResponsePhoGiamDoc.getData());

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
    public void duyetgiaymoilanhdaodaxuly(int id_giaymoi, int id_giamdoc, int id_phogiamdoc, int id_phongchutri,
                                          String id_phong_phoihops, String chidao_phogiamdoc, String chidao_giamdoc,
                                          String chidao_phongchutri, boolean giamdoc_duhop,
                                          boolean phong_duhop, String han_giai_quyet, boolean is_vbquantrong) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetgiaymoilanhdaodaxuly(token, uid, id_giaymoi, id_giamdoc, id_phogiamdoc, id_phongchutri,
                id_phong_phoihops, chidao_phogiamdoc, chidao_giamdoc, chidao_phongchutri,
                giamdoc_duhop, phong_duhop, han_giai_quyet, is_vbquantrong, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                            getView().onGetDuyetGiayMoiLanhDaoDaChiDao();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
