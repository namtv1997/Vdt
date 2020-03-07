package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachDauViecPhongPhoiHop;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachDauViecPhongPhoiHopPresenter;
import com.vpdt.vpdt.presenter.DanhSachDauViecPhongPhoiHopView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachDauViecPhongPhoiHopPresenterImpl extends BasePresenterImpl<DanhSachDauViecPhongPhoiHopView> implements
        DanhSachDauViecPhongPhoiHopPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DanhSachDauViecPhongPhoiHop> danhSachDauViecPhongPhoiHopArrayList = new ArrayList<>();

    public DanhSachDauViecPhongPhoiHopPresenterImpl(DanhSachDauViecPhongPhoiHopView view) {
        super(view);
    }

    @Override
    public void getAllDauViecPhongPhoiHop(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            danhSachDauViecPhongPhoiHopArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }

        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllDauViecPhongPhoiHop(token, nam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachDauViecPhongPhoiHop>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachDauViecPhongPhoiHop>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                danhSachDauViecPhongPhoiHopArrayList.addAll(arrayListResponse.getData());
                                getView().onGetDataPhongPhoiHopSuccess();
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
    public void getAllDauViecPhongChuTri(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            danhSachDauViecPhongPhoiHopArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }

        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllDauViecPhongChuTri(token, nam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachDauViecPhongPhoiHop>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachDauViecPhongPhoiHop>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                danhSachDauViecPhongPhoiHopArrayList.addAll(arrayListResponse.getData());
                                getView().onGetDataPhongChuTriSuccess();
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
    public ArrayList<DanhSachDauViecPhongPhoiHop> DANH_SACH_DAU_VIEC_PHONG_PHOI_HOP_ARRAY_LIST() {
        return danhSachDauViecPhongPhoiHopArrayList;
    }


}
