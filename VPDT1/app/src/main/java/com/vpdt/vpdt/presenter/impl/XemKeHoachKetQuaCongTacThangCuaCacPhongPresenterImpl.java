package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.presenter.XemKeHoachKetQuaCongTacThangCuaCacPhongPresenter;
import com.vpdt.vpdt.presenter.XemKeHoachKetQuaCongTacThangCuaCacPhongView;

public class XemKeHoachKetQuaCongTacThangCuaCacPhongPresenterImpl extends BasePresenterImpl<XemKeHoachKetQuaCongTacThangCuaCacPhongView> implements XemKeHoachKetQuaCongTacThangCuaCacPhongPresenter {
    public XemKeHoachKetQuaCongTacThangCuaCacPhongPresenterImpl(XemKeHoachKetQuaCongTacThangCuaCacPhongView view) {
        super(view);
    }

//    @Override
//    public void gettkkehoachcongtacthang(int thang) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().gettkkehoachcongtacthang(token, uid, thang, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<KeHoachCongTacTuan>>>() {
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
//                    public void onNext(Response<ArrayList<KeHoachCongTacTuan>> detailLichHopResponse) {
//                        Util.getIns().hideLoadding();
//                        if (detailLichHopResponse.getData() != null) {
//
//                            if (detailLichHopResponse.getStatus() == 1) {
//
//                                getView().onGetKeHoachCongTacThangSuccess(detailLichHopResponse.getData());
//
//                            }
//                        }
//
//                    }
//                });
//    }
}
