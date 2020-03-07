package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiayMoiGiaoChuTriChoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiGiaoChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.GiayMoiGiaoChuTriChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiGiaoChuTriChoXuLyPresenterImpl extends BasePresenterImpl<GiayMoiGiaoChuTriChoXuLyView> implements GiayMoiGiaoChuTriChoXuLyPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GiayMoiGiaoChuTriChoXuLy> giayMoiGiaoChuTriChoXuLyArrayList = new ArrayList<>();

    public GiayMoiGiaoChuTriChoXuLyPresenterImpl(GiayMoiGiaoChuTriChoXuLyView view) {
        super(view);
    }

    @Override
    public void getAllGMChuTriChoXuLyCV(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            giayMoiGiaoChuTriChoXuLyArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMChuTriChoXuLyCV(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiayMoiGiaoChuTriChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<GiayMoiGiaoChuTriChoXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                giayMoiGiaoChuTriChoXuLyArrayList.addAll(arrayListResponse.getData());
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
    public void countAllGMChuTriChoXuLyCV(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMChuTriChoXuLyCV(token, nam)
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
    public ArrayList<GiayMoiGiaoChuTriChoXuLy> GIAY_MOI_GIAO_CHU_TRI_CHO_XU_LY_ARRAY_LIST() {
        return giayMoiGiaoChuTriChoXuLyArrayList;
    }
}
