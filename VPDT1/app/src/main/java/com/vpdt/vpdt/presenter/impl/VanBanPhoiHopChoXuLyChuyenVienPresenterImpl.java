package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanPhoiHopChoXuLyChuyenVien;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanPhoiHopChoXuLyChuyenVienPresenter;
import com.vpdt.vpdt.presenter.VanBanPhoiHopChoXuLyChuyenVienView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanPhoiHopChoXuLyChuyenVienPresenterImpl extends BasePresenterImpl<VanBanPhoiHopChoXuLyChuyenVienView> implements VanBanPhoiHopChoXuLyChuyenVienPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanPhoiHopChoXuLyChuyenVien> vanBanPhoiHopChoXuLyChuyenViens = new ArrayList<>();

    public VanBanPhoiHopChoXuLyChuyenVienPresenterImpl(VanBanPhoiHopChoXuLyChuyenVienView view) {
        super(view);
    }

    @Override
    public void getAllVBPhoiHopChoXuLyCV(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanPhoiHopChoXuLyChuyenViens.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }

        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBPhoiHopChoXuLyCV(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanPhoiHopChoXuLyChuyenVien>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanPhoiHopChoXuLyChuyenVien>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanPhoiHopChoXuLyChuyenViens.addAll(arrayListResponse.getData());
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
    public void countAllVBPhoiHopChoXuLyCV(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBPhoiHopChoXuLyCV(token, nam)
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
    public ArrayList<VanBanPhoiHopChoXuLyChuyenVien> VAN_BAN_PHOI_HOP_CHO_XU_LY_CHUYEN_VIEN_ARRAY_LIST() {
        return vanBanPhoiHopChoXuLyChuyenViens;
    }
}
