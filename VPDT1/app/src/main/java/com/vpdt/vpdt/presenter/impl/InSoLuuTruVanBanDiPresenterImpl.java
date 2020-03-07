package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.InSoLuuTruVanbanDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDiPresenter;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDiView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InSoLuuTruVanBanDiPresenterImpl extends BasePresenterImpl<InSoLuuTruVanBanDiView> implements InSoLuuTruVanBanDiPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<InSoLuuTruVanbanDi> inSoLuuTruVanbanDiArrayList = new ArrayList<>();

    public InSoLuuTruVanBanDiPresenterImpl(InSoLuuTruVanBanDiView view) {
        super(view);
    }

    @Override
    public void getVBdi_InSoLuuTru(String nam, String soditu, String sodiden, String tungay, String denngay, int loaiso, String ngaymoitu, String ngaymoiden, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            inSoLuuTruVanbanDiArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getVBdi_InSoLuuTru(token, uid, nam, soditu, sodiden, tungay, denngay, loaiso, ngaymoitu, ngaymoiden, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<InSoLuuTruVanbanDi>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<InSoLuuTruVanbanDi>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                inSoLuuTruVanbanDiArrayList.addAll(arrayListResponse.getData());
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
    public void countVBdi_Insoluutru(String nam, String soditu, String sodiden, String tungay, String denngay, int loaiso, String ngaymoitu, String ngaymoiden) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countVBdi_Insoluutru(token, uid, nam, soditu, sodiden, tungay, denngay, loaiso, ngaymoitu, ngaymoiden)
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
    public ArrayList<InSoLuuTruVanbanDi> inSoLuuTruVanbanDiArrayList() {
        return inSoLuuTruVanbanDiArrayList;
    }
}
