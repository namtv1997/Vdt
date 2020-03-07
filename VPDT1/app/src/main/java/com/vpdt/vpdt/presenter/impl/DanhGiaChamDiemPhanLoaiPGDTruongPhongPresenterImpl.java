package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailDanhGiaKeHoach;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenter;
import com.vpdt.vpdt.presenter.DanhGiaChamDiemPhanLoaiPGDTruongPhongView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenterImpl extends BasePresenterImpl<DanhGiaChamDiemPhanLoaiPGDTruongPhongView> implements DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenter {
    public DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenterImpl(DanhGiaChamDiemPhanLoaiPGDTruongPhongView view) {
        super(view);
    }

//    @Override
//    public void gettkdanhgiakehoach(int thang) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().gettkdanhgiakehoach(token, uid, thang, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<DetailDanhGiaKeHoach>>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Util.getIns().hideLoadding();
//                    }
//
//                    @Override
//                    public void onNext(Response<ArrayList<DetailDanhGiaKeHoach>> arrayListResponsePhongBan) {
//                        Util.getIns().hideLoadding();
//                        if (arrayListResponsePhongBan.getData() != null) {
//
//                            if (arrayListResponsePhongBan.getStatus() == 1) {
//
//                                getView().onGetDataSuccess(arrayListResponsePhongBan.getData());
//
//                            } else {
//                                getView().onGetDatafail();
//                            }
//                        }
//
//                    }
//                });
//    }
}
