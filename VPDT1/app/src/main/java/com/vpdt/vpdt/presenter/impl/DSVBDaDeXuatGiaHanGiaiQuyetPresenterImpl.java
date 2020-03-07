package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanDaDeXuatGiaHanGiaiQuyet;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DSVBDaDeXuatGiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.DSVBDaDeXuatGiaHanGiaiQuyetView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DSVBDaDeXuatGiaHanGiaiQuyetPresenterImpl extends BasePresenterImpl<DSVBDaDeXuatGiaHanGiaiQuyetView> implements DSVBDaDeXuatGiaHanGiaiQuyetPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet> vanBanDaDeXuatGiaHanGiaiQuyetArrayList = new ArrayList<>();

    public DSVBDaDeXuatGiaHanGiaiQuyetPresenterImpl(DSVBDaDeXuatGiaHanGiaiQuyetView view) {
        super(view);
    }

    @Override
    public void getAllVBDaDeXuatGiaHanGiaQuyet(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanDaDeXuatGiaHanGiaiQuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBDaDeXuatGiaHanGiaQuyet(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanDaDeXuatGiaHanGiaiQuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBDaDeXuatGiaHanGiaQuyet(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBDaDeXuatGiaHanGiaQuyet(token, nam)
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
    public ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet> VAN_BAN_DA_DE_XUAT_GIA_HAN_GIAI_QUYET_ARRAY_LIST() {
        return vanBanDaDeXuatGiaHanGiaiQuyetArrayList;
    }
}
