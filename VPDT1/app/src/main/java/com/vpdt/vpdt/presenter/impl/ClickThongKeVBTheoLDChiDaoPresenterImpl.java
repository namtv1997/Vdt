package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.ThongKeVanBan;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.ClickThongKeVBTheoLDChiDaoPresenter;
import com.vpdt.vpdt.presenter.ClickThongKeVBTheoLDChiDaoView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ClickThongKeVBTheoLDChiDaoPresenterImpl extends BasePresenterImpl<ClickThongKeVBTheoLDChiDaoView> implements ClickThongKeVBTheoLDChiDaoPresenter {
    public ClickThongKeVBTheoLDChiDaoPresenterImpl(ClickThongKeVBTheoLDChiDaoView view) {
        super(view);
    }

    @Override
    public void thongke_vbLDdetail(String nam, int idPgd, int idphongban) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().thongke_vbLDdetail(token, uid, nam, idPgd, idphongban).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ThongKeVanBan>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ThongKeVanBan> dsvb_daChiDaoResponse) {
                        Util.getIns().hideLoadding();
                        if (dsvb_daChiDaoResponse.getData() != null) {

                            if (dsvb_daChiDaoResponse.getStatus() == 1) {

                                getView().clickThongKeVBTheoLDChiDaoSuccess(dsvb_daChiDaoResponse.getData());

                            }
                        }
                    }
                });
    }
}
