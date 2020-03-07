package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongChuTri;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongChuTriPresenter;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongChuTriView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SoLuongVanBanGiaoPhongChuTriPresenterImpl extends BasePresenterImpl<SoLuongVanBanGiaoPhongChuTriView> implements SoLuongVanBanGiaoPhongChuTriPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<SoLuongVanBanGiaoPhongChuTri> soLuongVanBanGiaoPhongChuTriArrayList = new ArrayList<>();

    public SoLuongVanBanGiaoPhongChuTriPresenterImpl(SoLuongVanBanGiaoPhongChuTriView view) {
        super(view);
    }

    @Override
    public void getAllVBGiaoPhongChuTri(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            soLuongVanBanGiaoPhongChuTriArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBGiaoPhongChuTri(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<SoLuongVanBanGiaoPhongChuTri>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<SoLuongVanBanGiaoPhongChuTri>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                soLuongVanBanGiaoPhongChuTriArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBGiaoPhongChuTri(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBGiaoPhongChuTri(token, nam)
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
    public ArrayList<SoLuongVanBanGiaoPhongChuTri> SO_LUONG_VAN_BAN_GIAO_PHONG_CHU_TRI_ARRAY_LIST() {
        return soLuongVanBanGiaoPhongChuTriArrayList;
    }
}
