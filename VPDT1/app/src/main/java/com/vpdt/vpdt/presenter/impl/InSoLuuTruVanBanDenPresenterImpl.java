package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.InSoLuuTruVanBanDen;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDenPresenter;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDenView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InSoLuuTruVanBanDenPresenterImpl extends BasePresenterImpl<InSoLuuTruVanBanDenView> implements InSoLuuTruVanBanDenPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<InSoLuuTruVanBanDen> inSoLuuTruVanBanDenArrayList = new ArrayList<>();

    public InSoLuuTruVanBanDenPresenterImpl(InSoLuuTruVanBanDenView view) {
        super(view);
    }

    @Override
    public void getInSoLuuTru_den(String nam, String sodentu, String sodenden, String ngaynhaptu, String ngaynhapden, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            inSoLuuTruVanBanDenArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getInSoLuuTru_den(token, uid, nam, sodentu, sodenden, ngaynhaptu, ngaynhapden, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<InSoLuuTruVanBanDen>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<InSoLuuTruVanBanDen>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                inSoLuuTruVanBanDenArrayList.addAll(arrayListResponse.getData());
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
    public void countInSoLuuTru_den(String nam, String sodentu, String sodenden, String ngaynhaptu, String ngaynhapden) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countInSoLuuTru_den(token, uid, nam, sodentu, sodenden, ngaynhaptu, ngaynhapden)
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
                    public void onNext(Response<Integer> integerResponse) {
                        Util.getIns().hideLoadding();
                        getView().onGetCountVBSuccess(integerResponse);
                    }
                });
    }

    @Override
    public ArrayList<InSoLuuTruVanBanDen> inSoLuuTruVanBanDenArrayList() {
        return inSoLuuTruVanBanDenArrayList;
    }
}
