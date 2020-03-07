package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.BaoCaoCuocHopChoPheDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.BaoCaoCuocHopChoPheDuyetPresenter;
import com.vpdt.vpdt.presenter.BaoCaoCuocHopChoPheDuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BaoCaoCuocHopChoPheDuyetPresenterImpl extends BasePresenterImpl<BaoCaoCuocHopChoPheDuyetView> implements BaoCaoCuocHopChoPheDuyetPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<BaoCaoCuocHopChoPheDuyet> baoCaoCuocHopChoPheDuyetArrayList = new ArrayList<>();

    public BaoCaoCuocHopChoPheDuyetPresenterImpl(BaoCaoCuocHopChoPheDuyetView view) {
        super(view);
    }

    @Override
    public void getAllBaoCaoCuocHopChoDuyet(String nam, boolean isRefresh) {
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
        NetworkModule.getService().getAllBaoCaoCuocHopChoDuyet(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<BaoCaoCuocHopChoPheDuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<BaoCaoCuocHopChoPheDuyet>> arrayListResponse) {
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
    public void countAllBaoCaoCuocHopChoDuyet(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllBaoCaoCuocHopChoDuyet(token, nam)
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
    public ArrayList<BaoCaoCuocHopChoPheDuyet> BAO_CAO_CUOC_HOP_CHO_PHE_DUYET_ARRAY_LIST() {
        return baoCaoCuocHopChoPheDuyetArrayList;
    }
}
