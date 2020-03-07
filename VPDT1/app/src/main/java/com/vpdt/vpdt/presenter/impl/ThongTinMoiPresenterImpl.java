package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBo;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ThongTinMoiPresenter;
import com.vpdt.vpdt.presenter.ThongTinMoiView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThongTinMoiPresenterImpl extends BasePresenterImpl<ThongTinMoiView> implements ThongTinMoiPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<TraoDoiThongTinNoiBo> traoDoiThongTinNoiBoArrayList = new ArrayList<>();

    public ThongTinMoiPresenterImpl(ThongTinMoiView view) {
        super(view);
    }

    @Override
    public void getallvanbanThongTinNoiBo(String nam, int trang_thai, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            traoDoiThongTinNoiBoArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallvanbanThongTinNoiBo(token, nam, uid, trang_thai, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TraoDoiThongTinNoiBo>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<TraoDoiThongTinNoiBo>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                traoDoiThongTinNoiBoArrayList.addAll(arrayListResponse.getData());
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
    public void countvanbanThongTinNoiBo(String nam, int trang_thai) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countvanbanThongTinNoiBo(token, nam, uid, trang_thai)
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
    public ArrayList<TraoDoiThongTinNoiBo> traoDoiThongTinNoiBoArrayList() {
        return traoDoiThongTinNoiBoArrayList;
    }
}
