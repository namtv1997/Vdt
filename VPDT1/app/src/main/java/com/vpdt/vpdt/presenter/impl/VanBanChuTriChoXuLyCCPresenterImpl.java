package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyCC;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.VanBanChuTriChoXuLyCCPresenter;
import com.vpdt.vpdt.presenter.VanBanChuTriChoXuLyCCView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VanBanChuTriChoXuLyCCPresenterImpl extends BasePresenterImpl<VanBanChuTriChoXuLyCCView> implements VanBanChuTriChoXuLyCCPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanChuTriChoXuLyCC> vanBanDiDaXulyArrayList = new ArrayList<>();

    public VanBanChuTriChoXuLyCCPresenterImpl(VanBanChuTriChoXuLyCCView view) {
        super(view);
    }

    @Override
    public void getAllVBChuTriChoXuLyCC(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            vanBanDiDaXulyArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBChuTriChoXuLyCC(token, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanChuTriChoXuLyCC>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanChuTriChoXuLyCC>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                vanBanDiDaXulyArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBChuTriChoXuLyCC(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBChuTriChoXuLyCC(token, nam)
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
    public ArrayList<VanBanChuTriChoXuLyCC> VAN_BAN_CHU_TRI_CHO_XU_LY_CC_ARRAY_LIST() {
        return vanBanDiDaXulyArrayList;
    }

}
