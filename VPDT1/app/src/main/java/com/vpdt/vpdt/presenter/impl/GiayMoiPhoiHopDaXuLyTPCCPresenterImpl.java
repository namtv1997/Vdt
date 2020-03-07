package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiayMoiChoXuLy;
import com.vpdt.vpdt.model.GiayMoiPhoiHopDaXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiChoXuLyPresenter;
import com.vpdt.vpdt.presenter.GiayMoiChoXuLyView;
import com.vpdt.vpdt.presenter.GiayMoiPhoiHopDaXuLyTPCCPresenter;
import com.vpdt.vpdt.presenter.GiayMoiPhoiHopDaXuLyTPCCView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiPhoiHopDaXuLyTPCCPresenterImpl extends BasePresenterImpl<GiayMoiPhoiHopDaXuLyTPCCView> implements GiayMoiPhoiHopDaXuLyTPCCPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GiayMoiPhoiHopDaXuLy> baoCaoCuocHopChoPheDuyetArrayList = new ArrayList<>();

    public GiayMoiPhoiHopDaXuLyTPCCPresenterImpl(GiayMoiPhoiHopDaXuLyTPCCView view) {
        super(view);
    }

    @Override
    public void getAllGMPhoiHopDaChiDaoCC(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            baoCaoCuocHopChoPheDuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }

        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMPhoiHopDaChiDaoCC(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiayMoiPhoiHopDaXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiayMoiPhoiHopDaXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                baoCaoCuocHopChoPheDuyetArrayList.addAll(arrayListResponse.getData());
                                getView().onGetDataSuccess();
                                page++;
                                if (arrayListResponse.getData().size() < size) {
                                    isLoadmore = false;
                                }
                            }
                        }

                    }
                });
    }

    @Override
    public void countAllGMPhoiHopDaChiDaoCC(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMPhoiHopDaChiDaoCC(token, nam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Integer> response) {
                        Util.getIns().hideLoadding();
                        getView().onGetCountVBSuccess(response);

                    }
                });
    }

    @Override
    public ArrayList<GiayMoiPhoiHopDaXuLy> GIAY_MOI_PHOI_HOP_DA_XU_LY_ARRAY_LIST() {
        return baoCaoCuocHopChoPheDuyetArrayList;
    }
}
