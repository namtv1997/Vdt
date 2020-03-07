package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiaHanGiaiQuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DuyetDSVB_GiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.DuyetDSVB_GiaHanGiaiQuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DuyetDSVB_GiaHanGiaiQuyetImpl extends BasePresenterImpl<DuyetDSVB_GiaHanGiaiQuyetView> implements DuyetDSVB_GiaHanGiaiQuyetPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GiaHanGiaiQuyet> giaHanGiaiQuyets = new ArrayList<>();

    public DuyetDSVB_GiaHanGiaiQuyetImpl(DuyetDSVB_GiaHanGiaiQuyetView view) {
        super(view);
    }

    @Override
    public void getallvbgiahangiaiquyet(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            giaHanGiaiQuyets.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }

        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallvbgiahangiaquyet(token, nam, uid, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiaHanGiaiQuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiaHanGiaiQuyet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
//                        isLoadmore = false;
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                giaHanGiaiQuyets.addAll(arrayListResponse.getData());
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
    public void countvbgiahangiaiquyet(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countvbgiahangiaquyet(token, nam, uid)
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
    public ArrayList<GiaHanGiaiQuyet> giaHanGiaiQuyets() {
        return giaHanGiaiQuyets;
    }
}
