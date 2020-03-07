package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.CanBoByidPhongBan;
import com.vpdt.vpdt.model.PhongBanKeHoachDanhGia;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.ThongKeKetQuaCongTacTuan;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ThongKeKetQuaCongTacTuanView;
import com.vpdt.vpdt.presenter.ThongKeKetQuaCongTacTuan_Presenter;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ThongKeKetQuaCongTacTuanPresenterImpl extends BasePresenterImpl<ThongKeKetQuaCongTacTuanView> implements ThongKeKetQuaCongTacTuan_Presenter {
    public ThongKeKetQuaCongTacTuanPresenterImpl(ThongKeKetQuaCongTacTuanView view) {
        super(view);
    }

//    @Override
//    public void gettkdanhgiakequanhiemvu(String nam, int thang_start, int thang_end, int idphong, int id_canbo) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().gettkdanhgiakequanhiemvu(token, uid, nam, thang_start, thang_end, idphong, id_canbo).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<ThongKeKetQuaCongTacTuan>>>() {
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
//                    public void onNext(Response<ArrayList<ThongKeKetQuaCongTacTuan>> arrayListResponse) {
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
//    public void getphongKeHoachDanhGia() {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        NetworkModule.getService().getphongKeHoachDanhGia(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<PhongBanKeHoachDanhGia>>>() {
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
//                    public void onNext(Response<ArrayList<PhongBanKeHoachDanhGia>> arrayListResponsePhongBan) {
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
//    public void getCanBoKeHoachDanhGia(int id) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        NetworkModule.getService().getCanBoKeHoachDanhGia(token, id, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
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
//    public void getAllTuan(String nam) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().getAllTuan(token, nam)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<String>>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Response<ArrayList<String>> arrayListResponse) {
//                        Util.getIns().hideLoadding();
//                        getView().onGetTuanSuccess(arrayListResponse.getData());
//                    }
//                });
//    }
}
