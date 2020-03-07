package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DSVB_QuaHan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DSVB_QuaHanDoLanhDaoChiDaoView;
import com.vpdt.vpdt.presenter.DSVB_QuaHanDoLanhDaoChiDao_Presenter;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DSVB_QuaHanDoLanhDaoChiDao_PresenterImpl extends BasePresenterImpl<DSVB_QuaHanDoLanhDaoChiDaoView> implements DSVB_QuaHanDoLanhDaoChiDao_Presenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    private ArrayList<DSVB_QuaHan> arrayList = new ArrayList<>();

    public DSVB_QuaHanDoLanhDaoChiDao_PresenterImpl(DSVB_QuaHanDoLanhDaoChiDaoView view) {
        super(view);
    }

    @Override
    public void getallvbquahandolanhdaochidao(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            arrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallvbquahandolanhdaochidao(token, nam, uid, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DSVB_QuaHan>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DSVB_QuaHan>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {
                            if (arrayListResponse.getStatus() == 1) {
                                arrayList.addAll(arrayListResponse.getData());
                                getView().onGetListDanhBa();
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
    public void countvbquahandolanhdaochidao(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countvbquahandolanhdaochidao(token, nam, uid)
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
    public ArrayList<DSVB_QuaHan> getListDSVB_QuaHan() {
        return arrayList;
    }


}
