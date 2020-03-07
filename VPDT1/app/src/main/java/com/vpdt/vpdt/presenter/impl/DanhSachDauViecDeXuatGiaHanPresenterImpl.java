package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DauViecDeXuat;
import com.vpdt.vpdt.model.DeXuatGiaHanChoDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachDauViecDeXuatGiaHanPresenter;
import com.vpdt.vpdt.presenter.DanhSachDauViecDeXuatGiaHanView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachDauViecDeXuatGiaHanPresenterImpl extends BasePresenterImpl<DanhSachDauViecDeXuatGiaHanView> implements DanhSachDauViecDeXuatGiaHanPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DauViecDeXuat> dauViecDeXuatArrayList = new ArrayList<>();
    ArrayList<DeXuatGiaHanChoDuyet> deXuatGiaHanChoDuyetArrayList = new ArrayList<>();

    public DanhSachDauViecDeXuatGiaHanPresenterImpl(DanhSachDauViecDeXuatGiaHanView view) {
        super(view);
    }

    @Override
    public void getalldauviecdexuatgiahan(String nam, int trang_thai, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            dauViecDeXuatArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getalldauviecdexuatgiahan(token, nam, uid, trang_thai, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DauViecDeXuat>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DauViecDeXuat>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                dauViecDeXuatArrayList.addAll(arrayListResponse.getData());
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
    public void coutalldauviecdexuatgiahan(String nam, int trang_thai) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().coutalldauviecdexuatgiahan(token, nam, uid, trang_thai)
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
    public void getAllDauViecDeXuatGiaHanChoDuyetCV(String nam, int trang_thai, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            deXuatGiaHanChoDuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecDeXuatGiaHanChoDuyetCV(token, nam, trang_thai, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DeXuatGiaHanChoDuyet>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DeXuatGiaHanChoDuyet>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                deXuatGiaHanChoDuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countAllDauViecDeXuatGiaHanChoDuyetCV(String nam, int trang_thai) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().countAllDauViecDeXuatGiaHanChoDuyetCV(token, nam, trang_thai)
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
    public ArrayList<DeXuatGiaHanChoDuyet> deXuatGiaHanChoDuyetArrayList() {
        return deXuatGiaHanChoDuyetArrayList;
    }


    @Override
    public ArrayList<DauViecDeXuat> dauviecdexuatArraylist() {
        return dauViecDeXuatArrayList;
    }
}
