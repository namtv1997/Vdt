package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachvanBanPhongChuTriLV3;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachVanBanPhongChuTriLV3Presenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanPhongChuTriLV3View;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongThePresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanTongTheView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachVanBanPhongChuTriLV3PresenterImpl extends BasePresenterImpl<DanhSachVanBanPhongChuTriLV3View> implements DanhSachVanBanPhongChuTriLV3Presenter {

    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DanhSachvanBanPhongChuTriLV3> deXuatCongViecPhoiHopChoDuyetArrayList = new ArrayList<>();

    public DanhSachVanBanPhongChuTriLV3PresenterImpl(DanhSachVanBanPhongChuTriLV3View view) {
        super(view);
    }

    @Override
    public void getAllVBDonViCapHai(String nam, int type, boolean isRefresh) {
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
        NetworkModule.getService().getAllVBDonViCapHai(token, nam, type, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachvanBanPhongChuTriLV3>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachvanBanPhongChuTriLV3>> arrayListResponse) {
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
    public ArrayList<DanhSachvanBanPhongChuTriLV3> DANH_SACHVAN_BAN_PHONG_CHU_TRI_LV_3_ARRAY_LIST() {
        return deXuatCongViecPhoiHopChoDuyetArrayList;
    }

    @Override
    public void countAllVBDonViCapHai(String nam, int type) {
        // Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countAllVBDonViCapHai(token, nam, type)
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
}
