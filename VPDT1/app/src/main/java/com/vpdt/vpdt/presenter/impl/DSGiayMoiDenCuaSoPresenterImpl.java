package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DSGiayMoiDenCuaSo;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DSGiayMoiDenCuaSoPresenter;
import com.vpdt.vpdt.presenter.DSGiayMoiDenCuaSoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DSGiayMoiDenCuaSoPresenterImpl extends BasePresenterImpl<DSGiayMoiDenCuaSoView> implements DSGiayMoiDenCuaSoPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DSGiayMoiDenCuaSo> dsGiayMoiDenCuaSoArrayList = new ArrayList<>();

    public DSGiayMoiDenCuaSoPresenterImpl(DSGiayMoiDenCuaSoView view) {
        super(view);
    }

    @Override
    public void getallgiaymoi(String nam, boolean isRefresh, int type) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            dsGiayMoiDenCuaSoArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallgiaymoi(token, nam, uid, type, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DSGiayMoiDenCuaSo>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DSGiayMoiDenCuaSo>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                dsGiayMoiDenCuaSoArrayList.addAll(arrayListResponse.getData());
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
    public void countgiaymoi(String nam, int type) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countgiaymoi(token, nam, uid, type)
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
    public ArrayList<DSGiayMoiDenCuaSo> dsGiayMoiDenCuaSoArrayList() {
        return dsGiayMoiDenCuaSoArrayList;
    }
}
