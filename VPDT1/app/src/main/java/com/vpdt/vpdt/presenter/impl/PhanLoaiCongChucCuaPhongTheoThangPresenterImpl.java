package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.PhanLoaiCongChucCuaPhongTheoThang;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.PhanLoaiCongChucCuaPhongTheoThangPresenter;
import com.vpdt.vpdt.presenter.PhanLoaiCongChucCuaPhongTheoThangView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PhanLoaiCongChucCuaPhongTheoThangPresenterImpl extends BasePresenterImpl<PhanLoaiCongChucCuaPhongTheoThangView> implements PhanLoaiCongChucCuaPhongTheoThangPresenter {
    public PhanLoaiCongChucCuaPhongTheoThangPresenterImpl(PhanLoaiCongChucCuaPhongTheoThangView view) {
        super(view);
    }

    @Override
    public void gettkkehoachcongtacthang_phong(int thang, int idphong) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().gettkkehoachcongtacthang_phong(token, uid, thang, idphong, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhanLoaiCongChucCuaPhongTheoThang>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<ArrayList<PhanLoaiCongChucCuaPhongTheoThang>> detailLichHopResponse) {
                        Util.getIns().hideLoadding();
                        if (detailLichHopResponse.getData() != null) {

                            if (detailLichHopResponse.getStatus() == 1) {

                                getView().onGetPhanLoaiCongChucTeoThangSuccess(detailLichHopResponse.getData());

                            }
                        }

                    }
                });
    }
}
