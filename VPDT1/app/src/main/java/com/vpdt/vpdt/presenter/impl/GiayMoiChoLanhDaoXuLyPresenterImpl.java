package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.GiayMoiChoLanhDaoXuLyPresenter;
import com.vpdt.vpdt.presenter.GiayMoiChoLanhDaoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GiayMoiChoLanhDaoXuLyPresenterImpl extends BasePresenterImpl<GiayMoiChoLanhDaoXuLyView> implements GiayMoiChoLanhDaoXuLyPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<GiayMoiChoLanhDaoXuLy> giayMoiChoLanhDaoXuLyArrayList = new ArrayList<>();

    public GiayMoiChoLanhDaoXuLyPresenterImpl(GiayMoiChoLanhDaoXuLyView view) {
        super(view);
    }

    @Override
    public void getallgiaymoicholanhdaoxuly(String nam, boolean isRefresh, String loaivanban, String sokyhieu,
                                            String donvi, String ngayky, String ngaynhap, String ngayden,
                                            String trichyeu, String nguoiky, String soden, String chucvu, String nguoinhap) {

        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            giayMoiChoLanhDaoXuLyArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallgiaymoicholanhdaoxuly(token, nam, uid, page, size, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiayMoiChoLanhDaoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiayMoiChoLanhDaoXuLy>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                giayMoiChoLanhDaoXuLyArrayList.addAll(arrayListResponse.getData());
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
    public void countgiaymoicholanhdaoxuly(String nam, String loaivanban, String sokyhieu,
                                           String donvi, String ngayky, String ngaynhap, String ngayden,
                                           String trichyeu, String nguoiky, String soden, String chucvu, String nguoinhap) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countgiaymoicholanhdaoxuly(token, nam, uid, loaivanban, sokyhieu, donvi, ngayky, ngaynhap, ngayden, trichyeu, nguoiky, soden, chucvu, nguoinhap)
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
    public ArrayList<GiayMoiChoLanhDaoXuLy> giayMoiChoLanhDaoXuLyArrayList() {
        return giayMoiChoLanhDaoXuLyArrayList;
    }
}
