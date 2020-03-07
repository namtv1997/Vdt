package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVB_VanBanDaChiDaoChuaHTPresenter;
import com.vpdt.vpdt.presenter.NDVB_VanBanDaChiDaoChuaHTView;
import com.vpdt.vpdt.presenter.NDVB_VanBanPhongChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVB_VanBanPhongChuTriChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVB_VanBanDaChiDaoChuaHTPresenterImpl extends BasePresenterImpl<NDVB_VanBanDaChiDaoChuaHTView> implements NDVB_VanBanDaChiDaoChuaHTPresenter {
    public NDVB_VanBanDaChiDaoChuaHTPresenterImpl(NDVB_VanBanDaChiDaoChuaHTView view) {
        super(view);
    }

    @Override
    public void getAllTruongPhongChiCuc(String nam) {
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllTruongPhongChiCuc(token, nam).
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

                                getView().onGetTruongPhongChiCucSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllChiCucPho(String nam) {
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllChiCucPho(token, nam).
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

                                getView().onGetChiCucPhoSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void duyetVBDaChiDaoChuaHoanThanhCC(String nam, int id, int idChiCuc, int idChiCucPho, int idTruongPhong, String idTruongPhongPPs, String chiDaoChiCucPho, String chiDaoChuTri, String hanGiaiQuyet) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBDaChiDaoChuaHoanThanhCC(token, nam, id, idChiCuc, idChiCucPho, idTruongPhong, idTruongPhongPPs, chiDaoChiCucPho, chiDaoChuTri, hanGiaiQuyet)
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
                            getView().duyetVBPhongChuTriChoXuLyCC();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void duyetVBDaChiDaoSTCPhoiHopCC(String nam, int id, int idChiCuc, int idChiCucPho, int idTruongPhong, String idTruongPhongPPs, String chiDaoChiCucPho, String chiDaoChuTri, String hanGiaiQuyet) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyetVBDaChiDaoSTCPhoiHopCC(token, nam, id, idChiCuc, idChiCucPho, idTruongPhong, idTruongPhongPPs, chiDaoChiCucPho, chiDaoChuTri, hanGiaiQuyet)
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
                            getView().duyetVBPhongChuTriChoXuLyCC();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

}
