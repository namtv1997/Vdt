package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.DetailVanBanGuiDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.TTVBThongTinDaGuiPresenter;
import com.vpdt.vpdt.presenter.TTVBThongTinDaGuiView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TTVBThongTinDaGuiPresenterImpl extends BasePresenterImpl<TTVBThongTinDaGuiView> implements TTVBThongTinDaGuiPresenter {
    public TTVBThongTinDaGuiPresenterImpl(TTVBThongTinDaGuiView view) {
        super(view);
    }

    @Override
    public void getvanbanguidibyid(int id_vb) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getvanbanguidibyid(token, id_vb, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, "")).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<DetailVanBanGuiDi>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<DetailVanBanGuiDi> dsvb_daChiDaoResponse) {
                        Util.getIns().hideLoadding();
                        if (dsvb_daChiDaoResponse.getData() != null) {

                            if (dsvb_daChiDaoResponse.getStatus() == 1) {

                                getView().onGetDataSuccess(dsvb_daChiDaoResponse.getData());

                            }
                        }
                    }
                });
    }
}
