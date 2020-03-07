package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDao;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDaoTheoPhong;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ThongKeVBTheoLDChiDaoPresenter;
import com.vpdt.vpdt.presenter.ThongKeVBTheoLDChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThongKeVBTheoLDChiDaoPresenterImpl extends BasePresenterImpl<ThongKeVBTheoLDChiDaoView> implements ThongKeVBTheoLDChiDaoPresenter {
    public ThongKeVBTheoLDChiDaoPresenterImpl(ThongKeVBTheoLDChiDaoView view) {
        super(view);
    }

    @Override
    public void getsoluongvb_Theo_PGD(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getsoluongvb_Theo_PGD(token, uid, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ThongKeLanhDaoChiDao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<ThongKeLanhDaoChiDao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().getsoluongvb_Theo_PGDSuccess(arrayListResponse.getData());

                            }
                        }
                    }

                });
    }

    @Override
    public void getsoluongvb_Theo_PGD_select(String idUser, String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getsoluongvb_Theo_PGD(token, idUser, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ThongKeLanhDaoChiDao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<ThongKeLanhDaoChiDao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().getsoluongvb_Theo_PGDSelectSuccess(arrayListResponse.getData());

                            }
                        }
                    }

                });
    }

    @Override
    public void getsoluongvb_Theo_Phongban(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getsoluongvb_Theo_Phongban(token, uid, nam).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ThongKeLanhDaoChiDaoTheoPhong>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<ThongKeLanhDaoChiDaoTheoPhong>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {

                                getView().getsoluongvb_Theo_PhongbanSuccess(arrayListResponse.getData());

                            }
                        }
                    }

                });
    }
}
