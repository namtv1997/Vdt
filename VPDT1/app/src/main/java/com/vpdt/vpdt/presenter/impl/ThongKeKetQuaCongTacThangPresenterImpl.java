package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.MucDanhGia;
import com.vpdt.vpdt.model.PhongBan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.ThongKeKetQuaCongTacThang;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ThongKeKetQuaCongTacThangView;
import com.vpdt.vpdt.presenter.ThongKeKetQuaCongTacThang_Presenter;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThongKeKetQuaCongTacThangPresenterImpl extends BasePresenterImpl<ThongKeKetQuaCongTacThangView> implements ThongKeKetQuaCongTacThang_Presenter {
    public ThongKeKetQuaCongTacThangPresenterImpl(ThongKeKetQuaCongTacThangView view) {
        super(view);
    }

//    @Override
//    public void gettkdanhgiakequanhiemvuthang(String nam, int thang_start, int thang_end, int idphong, int id_canbo, int mucdanhgia) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().gettkdanhgiakequanhiemvuthang(token, uid, nam, thang_start, thang_end, idphong, id_canbo, mucdanhgia).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<ThongKeKetQuaCongTacThang>>>() {
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
//                    public void onNext(Response<ArrayList<ThongKeKetQuaCongTacThang>> arrayListResponse) {
//                        Util.getIns().hideLoadding();
//                        if (arrayListResponse.getData() != null) {
//
//                            if (arrayListResponse.getStatus() == 1) {
//
//                                getView().onGetDataSuccess(arrayListResponse.getData());
//
//                            }
//                        }
//                    }
//
//                });
//    }
//
//    @Override
//    public void getAllPhongBan() {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        NetworkModule.getService().getAllPhongBan(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<PhongBan>>>() {
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
//                    public void onNext(Response<ArrayList<PhongBan>> arrayListResponsePhongBan) {
//                        Util.getIns().hideLoadding();
//                        if (arrayListResponsePhongBan.getData() != null) {
//
//                            if (arrayListResponsePhongBan.getStatus() == 1) {
//
//                                getView().onGetPhongBanSuccess(arrayListResponsePhongBan.getData());
//
//                            }
//                        }
//
//                    }
//                });
//    }
//
//    @Override
//    public void getAllCanBoByIdPhongBan(int id) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        NetworkModule.getService().getAllCanBoByIdPhongBan(token, id, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<CanBoByidPhongBan>>>() {
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
//                    public void onNext(Response<ArrayList<CanBoByidPhongBan>> arrayListResponsePhongBan) {
//                        Util.getIns().hideLoadding();
//                        if (arrayListResponsePhongBan.getData() != null) {
//
//                            if (arrayListResponsePhongBan.getStatus() == 1) {
//
//                                getView().onGetCanBoSuccess(arrayListResponsePhongBan.getData());
//
//                            }
//                        }
//
//                    }
//                });
//    }
//
//    @Override
//    public void getAllMucDanhGia() {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        NetworkModule.getService().getAllMucDanhGia(token).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<MucDanhGia>>>() {
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
//                    public void onNext(Response<ArrayList<MucDanhGia>> arrayListResponsePhongBan) {
//                        Util.getIns().hideLoadding();
//                        if (arrayListResponsePhongBan.getData() != null) {
//
//                            if (arrayListResponsePhongBan.getStatus() == 1) {
//
//                                getView().onGetMucDanhGiaSuccess(arrayListResponsePhongBan.getData());
//
//                            }
//                        }
//
//                    }
//                });
//    }
}
