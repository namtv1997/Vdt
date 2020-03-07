package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailDanhSachVanBanSoThamMuuTrinhThanhPho;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachVBSoThamMuuTrinhTPPresenter;
import com.vpdt.vpdt.presenter.DanhSachVBSoThamMuuTrinhTPView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachVBSoThamMuuTrinhTPPresenterImpl extends BasePresenterImpl<DanhSachVBSoThamMuuTrinhTPView> implements DanhSachVBSoThamMuuTrinhTPPresenter {
    public DanhSachVBSoThamMuuTrinhTPPresenterImpl(DanhSachVBSoThamMuuTrinhTPView view) {
        super(view);
    }

    @Override
    public void getVBdi_thammuu(String nam, String tungay, String denngay, int mapb) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getVBdi_thammuu(token, uid, nam, tungay, denngay, mapb).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().ongetVBdi_thammuuSuccess(arrayListResponse.getData());

                            }
                        }
                    }
                });
    }

    @Override
    public void getDSPhongban_solgvb(String nam, String tungay, String denngay, int mapb) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDSPhongban_solgvb(token, uid, nam, tungay, denngay, mapb).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().getDSPhongban_solgvb(arrayListResponse.getData());

                            }
                        }
                    }
                });
    }
}
