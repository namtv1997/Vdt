package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanPhoiHopDaChiDao;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanPhoiHopDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.VanBanPhoiHopDaChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanPhoiHopDaChiDaoPresenterImpl extends BasePresenterImpl<VanBanPhoiHopDaChiDaoView> implements VanBanPhoiHopDaChiDaoPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanPhoiHopDaChiDao> vanBanPhoiHopDaChiDaoArrayList = new ArrayList<>();

    public VanBanPhoiHopDaChiDaoPresenterImpl(VanBanPhoiHopDaChiDaoView view) {
        super(view);
    }

    @Override
    public void getAllVBPhongPhoiHopDaChiDao(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanPhoiHopDaChiDaoArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllVBPhongPhoiHopDaChiDao(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanPhoiHopDaChiDao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanPhoiHopDaChiDao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanPhoiHopDaChiDaoArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBPhongPhoiHopDaChiDao(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().countAllVBPhongPhoiHopDaChiDao(token, nam)
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
    public ArrayList<VanBanPhoiHopDaChiDao> VAN_BAN_PHOI_HOP_DA_CHI_DAO_ARRAY_LIST() {
        return vanBanPhoiHopDaChiDaoArrayList;
    }
}
