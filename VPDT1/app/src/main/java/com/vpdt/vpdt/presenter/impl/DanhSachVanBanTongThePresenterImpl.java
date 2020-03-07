package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DeXuatCongViecPhoiHopChoDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongThePresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongTheView;
import com.vpdt.vpdt.presenter.DeXuatCongViecPhoiHopChoDuyetPresenter;
import com.vpdt.vpdt.presenter.DeXuatCongViecPhoiHopChoDuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachVanBanTongThePresenterImpl extends BasePresenterImpl<DanhSachVanBanTongTheView> implements DanhSachVanBanTongThePresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanTongTheDonViCapHai> deXuatCongViecPhoiHopChoDuyetArrayList = new ArrayList<>();

    public DanhSachVanBanTongThePresenterImpl(DanhSachVanBanTongTheView view) {
        super(view);
    }

    @Override
    public void getAllVBTongTheDonViCapHai(String nam, boolean isRefresh) {
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
        NetworkModule.getService().getAllVBTongTheDonViCapHai(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanTongTheDonViCapHai>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanTongTheDonViCapHai>> arrayListResponse) {
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
    public void countAllVBTongTheDonViCapHai(String nam) {
        // Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBTongTheDonViCapHai(token, nam)
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
    public ArrayList<VanBanTongTheDonViCapHai> VAN_BAN_TONG_THE_DON_VI_CAP_HAI_ARRAY_LIST() {
        return deXuatCongViecPhoiHopChoDuyetArrayList;
    }
}
