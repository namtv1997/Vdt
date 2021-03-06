package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanGiaoPhongPhoiHop;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanGiaoPhongPhoiHopChoXuLyPresenter;
import com.vpdt.vpdt.presenter.VanBanGiaoPhongPhoiHopChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanGiaoPhongPhoiHopChoXuLyPresenterImpl extends BasePresenterImpl<VanBanGiaoPhongPhoiHopChoXuLyView> implements
        VanBanGiaoPhongPhoiHopChoXuLyPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanGiaoPhongPhoiHop> vanBanGiaoPhongPhoiHopArrayList = new ArrayList<>();

    public VanBanGiaoPhongPhoiHopChoXuLyPresenterImpl(VanBanGiaoPhongPhoiHopChoXuLyView view) {
        super(view);
    }

    @Override
    public void getAllVBPhongPhoiHopChoXuLy(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanGiaoPhongPhoiHopArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBPhongPhoiHopChoXuLy(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanGiaoPhongPhoiHop>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanGiaoPhongPhoiHop>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanGiaoPhongPhoiHopArrayList.addAll(arrayListResponse.getData());
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
    public void coutAllVBPhongPhoiHopChoXuLy(String nam) {
        // Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().coutAllVBPhongPhoiHopChoXuLy(token, nam)
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
    public ArrayList<VanBanGiaoPhongPhoiHop> VAN_BAN_GIAO_PHONG_PHOI_HOP_ARRAY_LIST() {
        return vanBanGiaoPhongPhoiHopArrayList;
    }
}
