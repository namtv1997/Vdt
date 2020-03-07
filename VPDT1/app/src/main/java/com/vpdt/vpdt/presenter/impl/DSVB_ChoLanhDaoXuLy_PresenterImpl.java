package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanDenChoXuLy;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DSVB_ChoLanhDaoXuLyView;
import com.vpdt.vpdt.presenter.DSVB_ChoLanhDaoXuLy_Presenter;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DSVB_ChoLanhDaoXuLy_PresenterImpl extends BasePresenterImpl<DSVB_ChoLanhDaoXuLyView> implements DSVB_ChoLanhDaoXuLy_Presenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<VanBanDenChoXuLy> dsvb_daChiDaoArrayList = new ArrayList<>();

    public DSVB_ChoLanhDaoXuLy_PresenterImpl(DSVB_ChoLanhDaoXuLyView view) {
        super(view);
    }

    @Override
    public void getallvbdenchoxuly(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            dsvb_daChiDaoArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallvbdenchoxuly(token, nam, uid, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanDenChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanDenChoXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                dsvb_daChiDaoArrayList.addAll(arrayListResponse.getData());
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
    public void countvbvbdenchoxuly(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countvbdenchoxuly(token, nam, uid)
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
    public ArrayList<VanBanDenChoXuLy> dsvbDaChiDao() {
        return dsvb_daChiDaoArrayList;
    }
}