package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanChoChiDaoLV2;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanChoChiDaoLV2Presenter;
import com.vpdt.vpdt.presenter.VanBanChoChiDaoLV2View;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanChoChiDaoLV2PresenterImpl extends BasePresenterImpl<VanBanChoChiDaoLV2View> implements VanBanChoChiDaoLV2Presenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanChoChiDaoLV2> deXuatCongViecPhoiHopChoDuyetArrayList = new ArrayList<>();

    public VanBanChoChiDaoLV2PresenterImpl(VanBanChoChiDaoLV2View view) {
        super(view);
    }

    @Override
    public void getAllVBChoChiDaoDonViCapHaiPhong(String nam, boolean isRefresh) {
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
        NetworkModule.getService().getAllVBChoChiDaoDonViCapHaiPhong(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanChoChiDaoLV2>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanChoChiDaoLV2>> arrayListResponse) {
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
    public void countAllVBChoChiDaoDonViCapHaiPhong(String nam) {
        // Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBChoChiDaoDonViCapHaiPhong(token, nam)
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
    public void getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String nam, boolean isRefresh) {
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
        NetworkModule.getService().getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanChoChiDaoLV2>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanChoChiDaoLV2>> arrayListResponse) {
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
    public void countAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String nam) {
// Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(token, nam)
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
    public ArrayList<VanBanChoChiDaoLV2> VAN_BAN_CHO_CHI_DAO_LV_2_ARRAY_LIST() {
        return deXuatCongViecPhoiHopChoDuyetArrayList;
    }
}
