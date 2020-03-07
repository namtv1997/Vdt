package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailGiayMoi;
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHopView;
import com.vpdt.vpdt.presenter.NDVBBaoCaoKetQuaCuocHop_Presenter;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVB_BaoCaoKetQuaCuocHopPresenterImpl extends BasePresenterImpl<NDVBBaoCaoKetQuaCuocHopView> implements NDVBBaoCaoKetQuaCuocHop_Presenter {
    public NDVB_BaoCaoKetQuaCuocHopPresenterImpl(NDVBBaoCaoKetQuaCuocHopView view) {
        super(view);
    }

    @Override
    public void getgiaymoibyid(int id_vb) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getgiaymoibyid(token, id_vb, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailGiayMoi>>() {
                    @Override
                    public void onCompleted() {
                        // Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailGiayMoi> detailGiayMoiResponse) {
                        Util.getIns().hideLoadding();
                        if (detailGiayMoiResponse.getData() != null) {

                            if (detailGiayMoiResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(detailGiayMoiResponse.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllCanBoPhong() {
        //Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllCanBoPhong(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<GiamdocVaPhoGiamdoc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<GiamdocVaPhoGiamdoc>> arrayListResponseGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponseGiamDoc.getData() != null) {

                            if (arrayListResponseGiamDoc.getStatus() == 1) {

                                getView().onGetNguoiKySuccess(arrayListResponseGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void duyettuchoibaocaokequacuochop(int id, int id_noidung, int id_vb, String ykien, int type) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().duyettuchoibaocaokequacuochop(token, id, id_noidung, id_vb, ykien, type,
                PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().duyettuchoibaocaokequacuochopSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void chuyenTiepKeQuaBaoCaoCuocHop(int id, int id_noidung, int id_vb, String idCanBoNhans, String noiDungChuyen) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().chuyenTiepKeQuaBaoCaoCuocHop(token, id, id_noidung, id_vb, idCanBoNhans, noiDungChuyen, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            getView().duyettuchoibaocaokequacuochopSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
