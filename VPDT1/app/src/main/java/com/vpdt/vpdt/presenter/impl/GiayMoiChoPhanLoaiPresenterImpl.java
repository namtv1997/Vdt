package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanNguoiDungXuLy;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiChoPhanLoaiPresenter;
import com.vpdt.vpdt.presenter.GiayMoiChoPhanLoaiView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiChoPhanLoaiPresenterImpl extends BasePresenterImpl<GiayMoiChoPhanLoaiView> implements GiayMoiChoPhanLoaiPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanNguoiDungXuLy> vanBanNguoiDungXuLyArrayList = new ArrayList<>();

    public GiayMoiChoPhanLoaiPresenterImpl(GiayMoiChoPhanLoaiView view) {
        super(view);
    }

    @Override
    public void getAllGMChuaPhanLoai(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanNguoiDungXuLyArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllGMChuaPhanLoai(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanNguoiDungXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanNguoiDungXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanNguoiDungXuLyArrayList.addAll(arrayListResponse.getData());
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
    public void countAllGMChuaPhanLoai(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllGMChuaPhanLoai(token, nam)
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
    public ArrayList<VanBanNguoiDungXuLy> VAN_BAN_NGUOI_DUNG_XU_LY_ARRAY_LIST() {
        return vanBanNguoiDungXuLyArrayList;
    }
}
