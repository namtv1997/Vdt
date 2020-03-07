package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBVanBanChoChiDaoPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoChiDaoView;
import com.vpdt.vpdt.presenter.NDVBVanBanChoXuLyLV3Presenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoXuLyLV3View;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBVanBanChoXuLyLV3PresenterImpl extends BasePresenterImpl<NDVBVanBanChoXuLyLV3View> implements NDVBVanBanChoXuLyLV3Presenter {
    public NDVBVanBanChoXuLyLV3PresenterImpl(NDVBVanBanChoXuLyLV3View view) {
        super(view);
    }

    @Override
    public void getAllPhoPhongDonViCapHai(String nam) {
//        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllPhoPhongDonViCapHai(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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

                                getView().onGetPhoPhongSuccess(arrayListResponseGiamDoc.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void getAllChuyenVienDonViCapHai(String nam) {
//        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllChuyenVienDonViCapHai(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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
                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponsePhongBan) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhongBan.getData() != null) {

                            if (arrayListResponsePhongBan.getStatus() == 1) {

                                getView().onGetChuyenVienSuccess(arrayListResponsePhongBan.getData());

                            }
                        }

                    }
                });

    }

    @Override
    public void duyetVBChoXuLyTPChuTriDonViCapHai(String nam, int id, int idPhoPhong, String chiDaoPhoPhong, String idPhoPhongPhoiHops,
                                                  String chiDaoPhoPhongPhoiHops, int idChuyenVien, String chiDaoChuyenVien,
                                                  String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoXuLyTPChuTriDonViCapHai(token, nam, id, idPhoPhong, chiDaoPhoPhong, idPhoPhongPhoiHops,
                chiDaoPhoPhongPhoiHops, idChuyenVien, chiDaoChuyenVien, idChuyenVienPhoiHops, chiDaoChuyenVienPhoiHops, hanXuLy)
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
    public void duyetVBChoXuLyTPPhoiHopDonViCapHai(String nam, int id, int idPhoPhong, String chiDaoPhoPhong, String idPhoPhongPhoiHops, String chiDaoPhoPhongPhoiHops, int idChuyenVien, String chiDaoChuyenVien, String idChuyenVienPhoiHops, String chiDaoChuyenVienPhoiHops, String hanXuLy) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBChoXuLyTPPhoiHopDonViCapHai(token, nam, id, idPhoPhong, chiDaoPhoPhong, idPhoPhongPhoiHops,
                chiDaoPhoPhongPhoiHops, idChuyenVien, chiDaoChuyenVien, idChuyenVienPhoiHops, chiDaoChuyenVienPhoiHops, hanXuLy)
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
