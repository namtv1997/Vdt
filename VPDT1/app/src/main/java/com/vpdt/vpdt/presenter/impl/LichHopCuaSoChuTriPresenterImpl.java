package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailLichHop;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.LichHopCuaSoChuTriPresenter;
import com.vpdt.vpdt.presenter.LichHopCuaSoChuTriView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;


import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LichHopCuaSoChuTriPresenterImpl extends BasePresenterImpl<LichHopCuaSoChuTriView> implements LichHopCuaSoChuTriPresenter {
    public LichHopCuaSoChuTriPresenterImpl(LichHopCuaSoChuTriView view) {
        super(view);
    }

    @Override
    public void getlichhoplanhdao() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getlichhoplanhdao(token, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailLichHop>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailLichHop> detailLichHopResponse) {
                        Util.getIns().hideLoadding();
                        if (detailLichHopResponse.getData() != null) {

                            if (detailLichHopResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(detailLichHopResponse.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void getAllTuan(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getAllTuan(token, nam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<String>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<String>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        getView().onGetTuanSuccess(arrayListResponse.getData());
                    }
                });
    }
}
