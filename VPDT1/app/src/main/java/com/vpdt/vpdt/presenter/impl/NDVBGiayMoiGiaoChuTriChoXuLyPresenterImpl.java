package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.NDVBGiayMoiGiaoChuTriChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBGiayMoiGiaoChuTriChoXuLyView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NDVBGiayMoiGiaoChuTriChoXuLyPresenterImpl extends BasePresenterImpl<NDVBGiayMoiGiaoChuTriChoXuLyView> implements NDVBGiayMoiGiaoChuTriChoXuLyPresenter {
    public NDVBGiayMoiGiaoChuTriChoXuLyPresenterImpl(NDVBGiayMoiGiaoChuTriChoXuLyView view) {
        super(view);
    }

    @Override
    public void tuChoiGMChuTriChoXuLyCV(int id, String noiDungTuChoi, int idCanBoChuyen) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().tuChoiGMChuTriChoXuLyCV(token, id, noiDungTuChoi, idCanBoChuyen, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
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
                            getView().tuChoiGMChuTriChoXuLyCVSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }
}
