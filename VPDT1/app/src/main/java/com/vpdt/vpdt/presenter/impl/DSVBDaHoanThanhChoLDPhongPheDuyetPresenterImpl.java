package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanHoanThanhChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DSVBDaHoanThanhChoLDPhongPheDuyetPresenter;
import com.vpdt.vpdt.presenter.DSVBDaHoanThanhChoLDPhongPheDuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl extends BasePresenterImpl<DSVBDaHoanThanhChoLDPhongPheDuyetView> implements DSVBDaHoanThanhChoLDPhongPheDuyetPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet> vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList = new ArrayList<>();

    public DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl(DSVBDaHoanThanhChoLDPhongPheDuyetView view) {
        super(view);
    }

    @Override
    public void getAllVBDaHoanThanhChoLDPheDuyet(String nam, int trang_thai, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBDaHoanThanhChoLDPheDuyet(token, nam, trang_thai, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBDaHoanThanhChoLDPheDuyet(String nam, int trang_thai) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBDaHoanThanhChoLDPheDuyet(token, nam, trang_thai)
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
    public ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet> VAN_BAN_HOAN_THANH_CHO_LANH_DAO_PHONG_PHE_DUYET_ARRAY_LIST() {
        return vanBanHoanThanhChoLanhDaoPhongPheDuyetArrayList;
    }
}
