package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriChoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DauViecPhongChuTriChoXuLyPresenterImpl extends BasePresenterImpl<DauViecPhongChuTriChoXuLyView> implements DauViecPhongChuTriChoXuLyPresenter {
    public DauViecPhongChuTriChoXuLyPresenterImpl(DauViecPhongChuTriChoXuLyView view) {
        super(view);
    }

    @Override
    public void getAllDauViecPhongChuTriChoXuLy(String nam, boolean isPhoPhongPP) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongChuTriChoXuLy(token, nam, isPhoPhongPP).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachDauViecPhongChuTriChoXuLy>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachDauViecPhongChuTriChoXuLy>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetDanhSachDauViecQuaHanCuaPhongSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }
}
