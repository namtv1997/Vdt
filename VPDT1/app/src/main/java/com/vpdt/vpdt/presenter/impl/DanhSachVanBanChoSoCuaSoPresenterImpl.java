package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DeatailDauSoCuaSo;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachVanBanChoSoCuaSoPresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanChoSoCuaSoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachVanBanChoSoCuaSoPresenterImpl extends BasePresenterImpl<DanhSachVanBanChoSoCuaSoView> implements DanhSachVanBanChoSoCuaSoPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DeatailDauSoCuaSo> deatailDauSoCuaSos = new ArrayList<>();

    public DanhSachVanBanChoSoCuaSoPresenterImpl(DanhSachVanBanChoSoCuaSoView view) {
        super(view);
    }

    @Override
    public void getDSVB_ChoSo_CuaSo(String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            deatailDauSoCuaSos.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDSVB_ChoSo_CuaSo(token, uid, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DeatailDauSoCuaSo>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DeatailDauSoCuaSo>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                deatailDauSoCuaSos.addAll(arrayListResponse.getData());
                                getView().ongetDSVB_ChoSo_CuaSoSuccess();
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
    public void countVBdi_ChoSo(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countVBdi_ChoSo(token, uid, nam)
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
    public ArrayList<DeatailDauSoCuaSo> deatailDauSoCuaSos() {
        return deatailDauSoCuaSos;
    }
}
