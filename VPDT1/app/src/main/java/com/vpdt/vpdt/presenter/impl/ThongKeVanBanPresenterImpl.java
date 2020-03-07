package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ThongKeVanBanPresenter;
import com.vpdt.vpdt.presenter.ThongKeVanBanView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThongKeVanBanPresenterImpl extends BasePresenterImpl<ThongKeVanBanView> implements ThongKeVanBanPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList = new ArrayList<>();

    public ThongKeVanBanPresenterImpl(ThongKeVanBanView view) {
        super(view);
    }

    @Override
    public void getVB_thongKetheoPhong(String nam, int ma, int sangtao, String idlanhdao, int chuagiaquyet, int dagiaiquyet, String ngaynhaptu, String ngaynhapden, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            detailVanBanDenTongTheArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getVB_thongKetheoPhong(token, uid, nam, ma, sangtao, idlanhdao, chuagiaquyet, dagiaiquyet, ngaynhaptu, ngaynhapden)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DetailVanBanDenTongThe>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DetailVanBanDenTongThe>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                detailVanBanDenTongTheArrayList.addAll(arrayListResponse.getData());
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
    public ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList() {
        return detailVanBanDenTongTheArrayList;
    }
}
