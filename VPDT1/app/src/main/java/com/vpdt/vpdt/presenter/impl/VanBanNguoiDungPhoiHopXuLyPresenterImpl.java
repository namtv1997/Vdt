package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanNguoiDungPhoiHopXuLy;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanNguoiDungPhoiHopXuLyPresenter;
import com.vpdt.vpdt.presenter.VanBanNguoiDungPhoiHopXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanNguoiDungPhoiHopXuLyPresenterImpl extends BasePresenterImpl<VanBanNguoiDungPhoiHopXuLyView> implements VanBanNguoiDungPhoiHopXuLyPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanNguoiDungPhoiHopXuLy> vanBanNguoiDungPhoiHopXuLyArrayList = new ArrayList<>();

    public VanBanNguoiDungPhoiHopXuLyPresenterImpl(VanBanNguoiDungPhoiHopXuLyView view) {
        super(view);
    }

    @Override
    public void getAllVBNguoiDungPhoiHopXuLy(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanNguoiDungPhoiHopXuLyArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBNguoiDungPhoiHopXuLy(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanNguoiDungPhoiHopXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanNguoiDungPhoiHopXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanNguoiDungPhoiHopXuLyArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBNguoiDungPhoiHopXuLy(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBNguoiDungPhoiHopXuLy(token, nam)
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
    public ArrayList<VanBanNguoiDungPhoiHopXuLy> VAN_BAN_NGUOI_DUNG_PHOI_HOP_XU_LY_ARRAY_LIST() {
        return vanBanNguoiDungPhoiHopXuLyArrayList;
    }
}
