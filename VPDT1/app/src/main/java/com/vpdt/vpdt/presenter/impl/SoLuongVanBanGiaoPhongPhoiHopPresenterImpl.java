package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongPhoiHop;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongPhoiHopPresenter;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongPhoiHopView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SoLuongVanBanGiaoPhongPhoiHopPresenterImpl extends BasePresenterImpl<SoLuongVanBanGiaoPhongPhoiHopView> implements SoLuongVanBanGiaoPhongPhoiHopPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<SoLuongVanBanGiaoPhongPhoiHop> soLuongVanBanGiaoPhongPhoiHopArrayList = new ArrayList<>();

    public SoLuongVanBanGiaoPhongPhoiHopPresenterImpl(SoLuongVanBanGiaoPhongPhoiHopView view) {
        super(view);
    }

    @Override
    public void getAllVBPhongPhoiHop(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            soLuongVanBanGiaoPhongPhoiHopArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBPhongPhoiHop(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<SoLuongVanBanGiaoPhongPhoiHop>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<SoLuongVanBanGiaoPhongPhoiHop>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                soLuongVanBanGiaoPhongPhoiHopArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBPhongPhoiHop(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBPhongPhoiHop(token, nam)
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
    public void tuChoiVBPhongPhoiHop(int id, String noiDungTuChoi) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().tuChoiVBPhongPhoiHop(token, id, noiDungTuChoi, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().onTuChoiSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public ArrayList<SoLuongVanBanGiaoPhongPhoiHop> SO_LUONG_VAN_BAN_GIAO_PHONG_PHOI_HOP_ARRAY_LIST() {
        return soLuongVanBanGiaoPhongPhoiHopArrayList;
    }
}
