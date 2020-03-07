package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DauViecHoanThanhChoLanhDaoPhongDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DauViecHoanThanhChoLanhDaoPhongDuyetPresenter;
import com.vpdt.vpdt.presenter.DauViecHoanThanhChoLanhDaoPhongDuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DauViecHoanThanhChoLanhDaoPhongDuyetPresenterImpl extends BasePresenterImpl<DauViecHoanThanhChoLanhDaoPhongDuyetView> implements DauViecHoanThanhChoLanhDaoPhongDuyetPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet> dauViecHoanThanhChoLanhDaoPhongDuyetArrayList = new ArrayList<>();

    public DauViecHoanThanhChoLanhDaoPhongDuyetPresenterImpl(DauViecHoanThanhChoLanhDaoPhongDuyetView view) {
        super(view);
    }

    @Override
    public void getAllDauViecHoanThanhChoLDDuyet(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            dauViecHoanThanhChoLanhDaoPhongDuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllDauViecHoanThanhChoLDDuyet(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                dauViecHoanThanhChoLanhDaoPhongDuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countDauViecHoanThanhChoLDDuyet(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countDauViecHoanThanhChoLDDuyet(token, nam)
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
    public ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet> DAU_VIEC_HOAN_THANH_CHO_LANH_DAO_PHONG_DUYET_ARRAY_LIST() {
        return dauViecHoanThanhChoLanhDaoPhongDuyetArrayList;
    }
}
