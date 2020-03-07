package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanTheoLanhDao;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ClickVanBanThongKeVBTheoLDCDPresenter;
import com.vpdt.vpdt.presenter.ClickVanBanThongKeVBTheoLDCDView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ClickVanBanThongKeVBTheoLDCDPresenterImpl extends BasePresenterImpl<ClickVanBanThongKeVBTheoLDCDView> implements ClickVanBanThongKeVBTheoLDCDPresenter {
    private int size = 20;
    private int page = 1;
    private boolean isLoadmore = true;
    ArrayList<DetailVanBanTheoLanhDao> detailVanBanTheoLanhDaoArraylist = new ArrayList<>();

    public ClickVanBanThongKeVBTheoLDCDPresenterImpl(ClickVanBanThongKeVBTheoLDCDView view) {
        super(view);
    }

    @Override
    public void getVB_TKVB_theoLD(String nam, int dunghan, int dalam, int idPgd, int idphongban, boolean isRefresh) {
        if (isRefresh) {
            page = 1;
            isLoadmore = true;
            detailVanBanTheoLanhDaoArraylist.clear();
            //   Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore) {
            return;
        }
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getVB_TKVB_theoLD(token, uid, nam, dunghan, dalam, idPgd, idphongban, page, size)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DetailVanBanTheoLanhDao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<DetailVanBanTheoLanhDao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getData() != null) {

                            if (arrayListResponse.getStatus() == 1) {
                                detailVanBanTheoLanhDaoArraylist.addAll(arrayListResponse.getData());
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
    public ArrayList<DetailVanBanTheoLanhDao> detailVanBanTheoLanhDaoArraylist() {
        return detailVanBanTheoLanhDaoArraylist;
    }
}
