package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GMDaHoanThanhChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetPresenter;
import com.vpdt.vpdt.presenter.GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetPresenterImpl extends BasePresenterImpl<GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetView> implements GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GMDaHoanThanhChoLanhDaoPhongPheDuyet> gmDaHoanThanhChoLanhDaoPhongPheDuyetArrayList = new ArrayList<>();

    public GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetPresenterImpl(GiayMoiDaHoanThanhChoLanhDaoPhongPheDuyetView view) {
        super(view);
    }

    @Override
    public void getAllGMDaHoanThanhChoLDPheDuyet(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            gmDaHoanThanhChoLanhDaoPhongPheDuyetArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMDaHoanThanhChoLDPheDuyet(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GMDaHoanThanhChoLanhDaoPhongPheDuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GMDaHoanThanhChoLanhDaoPhongPheDuyet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                gmDaHoanThanhChoLanhDaoPhongPheDuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countAllGMDaHoanThanhChoLDPheDuyet(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMDaHoanThanhChoLDPheDuyet(token, nam)
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
    public ArrayList<GMDaHoanThanhChoLanhDaoPhongPheDuyet> GM_DA_HOAN_THANH_CHO_LANH_DAO_PHONG_PHE_DUYET_ARRAY_LIST() {
        return gmDaHoanThanhChoLanhDaoPhongPheDuyetArrayList;
    }
}
