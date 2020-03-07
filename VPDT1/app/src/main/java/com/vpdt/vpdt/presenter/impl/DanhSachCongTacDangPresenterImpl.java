package com.vpdt.vpdt.presenter.impl;

import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanDenTongThe;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.DanhSachCongTacDangPresenter;
import com.vpdt.vpdt.presenter.DanhSachCongTacDangView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DanhSachCongTacDangPresenterImpl extends BasePresenterImpl<DanhSachCongTacDangView> implements DanhSachCongTacDangPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList = new ArrayList<>();

    public DanhSachCongTacDangPresenterImpl(DanhSachCongTacDangView view) {
        super(view);
    }


    @Override
    public void getallvbdentongthe(int kieu, int loai, String nam, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            detailVanBanDenTongTheArrayList.clear();
            // Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {

            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getallvbdentongthe(token, uid, kieu, loai, nam, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DetailVanBanDenTongThe>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DetailVanBanDenTongThe>> arrayListResponse) {
                        if (arrayListResponse.getData() != null) {
                            if (arrayListResponse.getStatus() == 1) {
                                detailVanBanDenTongTheArrayList.addAll(arrayListResponse.getData());
                                getView().onGetDataSuccess();
                                page++;
                                if (arrayListResponse.getData().size() < size) {
                                    isLoadmore = false;
                                }
                            }
                        }
                        Util.getIns().hideLoadding();
                    }
                });
    }

    @Override
    public void countvbden(int kieu, int loai, String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countvbden(token, uid, kieu, loai, nam)
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
                    public void onNext(Response<Integer> arrayListResponse) {
                        if (arrayListResponse.getData() != null) {
                            if (arrayListResponse.getStatus() == 1) {
                                getView().onGetCountVBSuccess(arrayListResponse);
                            }
                        }
                        Util.getIns().hideLoadding();
                    }
                });
    }

    @Override
    public ArrayList<DetailVanBanDenTongThe> detailVanBanDenTongTheArrayList() {
        return detailVanBanDenTongTheArrayList;
    }
}
