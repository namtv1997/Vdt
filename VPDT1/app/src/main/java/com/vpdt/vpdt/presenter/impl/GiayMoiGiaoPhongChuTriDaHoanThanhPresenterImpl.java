package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GMPhongChuTriDaHoanThanh;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiGiaoPhongChuTriDaHoanThanhPresenter;
import com.vpdt.vpdt.presenter.GiayMoiGiaoPhongChuTriDaHoanThanhView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiGiaoPhongChuTriDaHoanThanhPresenterImpl extends BasePresenterImpl<GiayMoiGiaoPhongChuTriDaHoanThanhView> implements GiayMoiGiaoPhongChuTriDaHoanThanhPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GMPhongChuTriDaHoanThanh> gmPhongChuTriDaHoanThanhArrayList = new ArrayList<>();

    public GiayMoiGiaoPhongChuTriDaHoanThanhPresenterImpl(GiayMoiGiaoPhongChuTriDaHoanThanhView view) {
        super(view);
    }

    @Override
    public void getAllGMGiaoPhongChuTriDaHoanThanh(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            gmPhongChuTriDaHoanThanhArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMGiaoPhongChuTriDaHoanThanh(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GMPhongChuTriDaHoanThanh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GMPhongChuTriDaHoanThanh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                gmPhongChuTriDaHoanThanhArrayList.addAll(arrayListResponse.getData());
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
    public void countAllGMGiaoPhongChuTriDaHoanThanh(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMGiaoPhongChuTriDaHoanThanh(token, nam)
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
    public ArrayList<GMPhongChuTriDaHoanThanh> GM_PHONG_CHU_TRI_DA_HOAN_THANH_ARRAY_LIST() {
        return gmPhongChuTriDaHoanThanhArrayList;
    }
}
