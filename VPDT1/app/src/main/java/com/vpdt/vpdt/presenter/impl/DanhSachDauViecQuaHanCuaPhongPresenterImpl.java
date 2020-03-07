package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DanhSachDauViecQuaHanCuaPhong;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachDauViecQuaHanCuaPhongPresenter;
import com.vpdt.vpdt.presenter.DanhSachDauViecQuaHanCuaPhongView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachDauViecQuaHanCuaPhongPresenterImpl extends BasePresenterImpl<DanhSachDauViecQuaHanCuaPhongView> implements DanhSachDauViecQuaHanCuaPhongPresenter {
    public DanhSachDauViecQuaHanCuaPhongPresenterImpl(DanhSachDauViecQuaHanCuaPhongView view) {
        super(view);
    }

    @Override
    public void getAllDauViecQuaHanPhong(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllDauViecQuaHanPhong(token, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhSachDauViecQuaHanCuaPhong>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhSachDauViecQuaHanCuaPhong>> arrayListResponsePhoGiamDoc) {
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
