package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VBPhoPhongPhoiHopChoXL;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VBPhoPhongPhoiHopChoXLPresenter;
import com.vpdt.vpdt.presenter.VBPhoPhongPhoiHopChoXLView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VBPhoPhongPhoiHopChoXLPresenterImpl extends BasePresenterImpl<VBPhoPhongPhoiHopChoXLView> implements VBPhoPhongPhoiHopChoXLPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VBPhoPhongPhoiHopChoXL> vbPhoPhongPhoiHopChoXLArrayList = new ArrayList<>();

    public VBPhoPhongPhoiHopChoXLPresenterImpl(VBPhoPhongPhoiHopChoXLView view) {
        super(view);
    }

    @Override
    public void getAllVBPhoPhongPhoiHopChoXuLy(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vbPhoPhongPhoiHopChoXLArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }

        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBPhoPhongPhoiHopChoXuLy(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VBPhoPhongPhoiHopChoXL>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<VBPhoPhongPhoiHopChoXL>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vbPhoPhongPhoiHopChoXLArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBPhoPhongPhoiHopChoXuLy(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().countAllVBPhoPhongPhoiHopChoXuLy(token, nam)
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
    public ArrayList<VBPhoPhongPhoiHopChoXL> VB_PHO_PHONG_PHOI_HOP_CHO_XLS() {
        return vbPhoPhongPhoiHopChoXLArrayList;
    }
}
