package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanChoChiDao;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongThePresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongTheView;
import com.vpdt.vpdt.presenter.VanBanChoChiDaoPresenter;
import com.vpdt.vpdt.presenter.VanBanChoChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanChoChiDaoPresenterImpl extends BasePresenterImpl<VanBanChoChiDaoView> implements VanBanChoChiDaoPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanChoChiDao> deXuatCongViecPhoiHopChoDuyetArrayList = new ArrayList<>();

    public VanBanChoChiDaoPresenterImpl(VanBanChoChiDaoView view) {
        super(view);
    }

    @Override
    public void getAllVBChoChiDaoDonViCapHai(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            deXuatCongViecPhoiHopChoDuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBChoChiDaoDonViCapHai(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanChoChiDao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanChoChiDao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                deXuatCongViecPhoiHopChoDuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBChoChiDaoDonViCapHai(String nam) {
        // Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBChoChiDaoDonViCapHai(token, nam)
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
    public ArrayList<VanBanChoChiDao> VAN_BAN_CHO_CHI_DAO_ARRAY_LIST() {
        return deXuatCongViecPhoiHopChoDuyetArrayList;
    }
}
