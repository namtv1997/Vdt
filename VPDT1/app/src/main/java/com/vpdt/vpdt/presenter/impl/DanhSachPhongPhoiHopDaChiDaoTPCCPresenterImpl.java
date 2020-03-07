package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachPhongPhoiHopDaChiDaoTPCC;
import com.vpdt.vpdt.model.DauViecPhongChuTriChoXuLyTPCC;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachPhongPhoiHopDaChiDaoTPCCPresenter;
import com.vpdt.vpdt.presenter.DanhSachPhongPhoiHopDaChiDaoTPCCView;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyTPCCPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriChoXuLyTPCCView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachPhongPhoiHopDaChiDaoTPCCPresenterImpl extends BasePresenterImpl<DanhSachPhongPhoiHopDaChiDaoTPCCView> implements DanhSachPhongPhoiHopDaChiDaoTPCCPresenter {
    public DanhSachPhongPhoiHopDaChiDaoTPCCPresenterImpl(DanhSachPhongPhoiHopDaChiDaoTPCCView view) {
        super(view);
    }

    @Override
    public void getAllDauViecPhongPhoHopDaXuLyTPCC(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecPhongPhoHopDaXuLyTPCC(token, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachPhongPhoiHopDaChiDaoTPCC>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachPhongPhoiHopDaChiDaoTPCC>> arrayListResponsePhoGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponsePhoGiamDoc.getData() != null) {

                            if (arrayListResponsePhoGiamDoc.getStatus() == 1) {

                                getView().onGetSuccess(arrayListResponsePhoGiamDoc.getData());

                            }
                        }

                    }
                });
    }

}
