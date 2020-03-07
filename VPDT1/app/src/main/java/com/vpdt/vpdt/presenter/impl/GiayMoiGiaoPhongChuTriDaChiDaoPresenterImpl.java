package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GMPhongChuTriDaChiDao;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiGiaoPhongChuTriDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.GiayMoiGiaoPhongChuTriDaChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiGiaoPhongChuTriDaChiDaoPresenterImpl extends BasePresenterImpl<GiayMoiGiaoPhongChuTriDaChiDaoView> implements GiayMoiGiaoPhongChuTriDaChiDaoPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GMPhongChuTriDaChiDao> gmPhongChuTriDaChiDaoArrayList = new ArrayList<>();

    public GiayMoiGiaoPhongChuTriDaChiDaoPresenterImpl(GiayMoiGiaoPhongChuTriDaChiDaoView view) {
        super(view);
    }

    @Override
    public void getAllGMGiaoPhongChuTriDaChiDao(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            gmPhongChuTriDaChiDaoArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMGiaoPhongChuTriDaChiDao(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GMPhongChuTriDaChiDao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<GMPhongChuTriDaChiDao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                gmPhongChuTriDaChiDaoArrayList.addAll(arrayListResponse.getData());
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
    public void countAllGMGiaoPhongChuTriDaChiDao(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMGiaoPhongChuTriDaChiDao(token, nam)
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
    public ArrayList<GMPhongChuTriDaChiDao> GM_PHONG_CHU_TRI_DA_CHI_DAO_ARRAY_LIST() {
        return gmPhongChuTriDaChiDaoArrayList;
    }
}
