package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachVanBanDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachVanBanDiPresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanDiView;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongThePresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongTheView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachVanBanDiPresenterImpl extends BasePresenterImpl<DanhSachVanBanDiView> implements DanhSachVanBanDiPresenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DanhSachVanBanDi> deXuatCongViecPhoiHopChoDuyetArrayList = new ArrayList<>();

    public DanhSachVanBanDiPresenterImpl(DanhSachVanBanDiView view) {
        super(view);
    }

    @Override
    public void getAllVBDiDonViCapHai(String nam, int trangthai, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            deXuatCongViecPhoiHopChoDuyetArrayList.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllVBDiDonViCapHai(token, nam, trangthai, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachVanBanDi>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachVanBanDi>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                deXuatCongViecPhoiHopChoDuyetArrayList.addAll(arrayListResponse.getData());
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
    public void countAllVBDiDonViCapHai(String nam, int trangthai) {
        // Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBDiDonViCapHai(token, nam, trangthai)
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
    public ArrayList<DanhSachVanBanDi> DANH_SACH_VAN_BAN_DI_ARRAY_LIST() {
        return deXuatCongViecPhoiHopChoDuyetArrayList;
    }
}
