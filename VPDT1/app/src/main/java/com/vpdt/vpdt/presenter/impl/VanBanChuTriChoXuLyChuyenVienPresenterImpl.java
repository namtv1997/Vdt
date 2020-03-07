package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyChuyenVien;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanChuTriChoXuLyChuyenVienPresenter;
import com.vpdt.vpdt.presenter.VanBanChuTriChoXuLyChuyenVienView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanChuTriChoXuLyChuyenVienPresenterImpl extends BasePresenterImpl<VanBanChuTriChoXuLyChuyenVienView> implements VanBanChuTriChoXuLyChuyenVienPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanChuTriChoXuLyChuyenVien> vanBanChuTriChoXuLyChuyenVienArrayList = new ArrayList<>();

    public VanBanChuTriChoXuLyChuyenVienPresenterImpl(VanBanChuTriChoXuLyChuyenVienView view) {
        super(view);
    }

    @Override
    public void getAllChuTriChoXuLyCV(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanChuTriChoXuLyChuyenVienArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllChuTriChoXuLyCV(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanChuTriChoXuLyChuyenVien>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanChuTriChoXuLyChuyenVien>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanChuTriChoXuLyChuyenVienArrayList.addAll(arrayListResponse.getData());
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
    public void countAllChuTriChoXuLyCV(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllChuTriChoXuLyCV(token, nam)
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
    public ArrayList<VanBanChuTriChoXuLyChuyenVien> VAN_BAN_CHU_TRI_CHO_XU_LY_CHUYEN_VIEN_ARRAY_LIST() {
        return vanBanChuTriChoXuLyChuyenVienArrayList;
    }
}
