package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiayMoiPhongPhoiHopChoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiPhoPhongPhoiHopChoXuLyPresenter;
import com.vpdt.vpdt.presenter.GiayMoiPhoPhongPhoiHopChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiPhoPhongPhoiHopChoXuLyPresenterImpl extends BasePresenterImpl<GiayMoiPhoPhongPhoiHopChoXuLyView> implements GiayMoiPhoPhongPhoiHopChoXuLyPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GiayMoiPhongPhoiHopChoXuLy> giayMoiPhongPhoiHopChoXuLyArrayList = new ArrayList<>();


    public GiayMoiPhoPhongPhoiHopChoXuLyPresenterImpl(GiayMoiPhoPhongPhoiHopChoXuLyView view) {
        super(view);
    }

    @Override
    public void getAllGMPhoPhongPhoiHopChoXuLy(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            giayMoiPhongPhoiHopChoXuLyArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMPhoPhongPhoiHopChoXuLy(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiayMoiPhongPhoiHopChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<GiayMoiPhongPhoiHopChoXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                giayMoiPhongPhoiHopChoXuLyArrayList.addAll(arrayListResponse.getData());
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
    public void countAllGMPhoPhongPhoiHopChoXuLy(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMPhoPhongPhoiHopChoXuLy(token, nam)
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
    public ArrayList<GiayMoiPhongPhoiHopChoXuLy> GIAY_MOI_PHONG_PHOI_HOP_CHO_XU_LY_ARRAY_LIST() {
        return giayMoiPhongPhoiHopChoXuLyArrayList;
    }
}
