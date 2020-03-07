package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiayMoiXemDeBiet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiXemDeBietPresenter;
import com.vpdt.vpdt.presenter.GiayMoiXemDeBietView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiXemDeBietPresenterImpl extends BasePresenterImpl<GiayMoiXemDeBietView> implements GiayMoiXemDeBietPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GiayMoiXemDeBiet> giayMoiXemDeBietArrayList = new ArrayList<>();

    public GiayMoiXemDeBietPresenterImpl(GiayMoiXemDeBietView view) {
        super(view);
    }

    @Override
    public void getallgiaymoixemdebiet(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            giayMoiXemDeBietArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallgiaymoixemdebiet(token, nam, uid, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiayMoiXemDeBiet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiayMoiXemDeBiet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                giayMoiXemDeBietArrayList.addAll(arrayListResponse.getData());
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
    public void countallgiayxemdebiet(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countallgiayxemdebiet(token, nam, uid)
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
    public ArrayList<GiayMoiXemDeBiet> giaymoixemdebietArraylist() {
        return giayMoiXemDeBietArrayList;
    }
}
