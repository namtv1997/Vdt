package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.presenter.GDSoTuNhanXetDanhGiaKetQuaThangPresenter;
import com.vpdt.vpdt.presenter.GDSoTuNhanXetDanhGiaKetQuaThangView;

public class GDSoTuNhanXetDanhGiaKetQuaThangPresenterImpl extends BasePresenterImpl<GDSoTuNhanXetDanhGiaKetQuaThangView> implements GDSoTuNhanXetDanhGiaKetQuaThangPresenter {
    public GDSoTuNhanXetDanhGiaKetQuaThangPresenterImpl(GDSoTuNhanXetDanhGiaKetQuaThangView view) {
        super(view);
    }

//    @Override
//    public void getdanhgiaGD(int thang) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().getdanhgiaGD(token, uid, thang)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<ArrayList<DanhGiaGiamDoc>>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Util.getIns().hideLoadding();
//
//                    }
//
//                    @Override
//                    public void onNext(Response<ArrayList<DanhGiaGiamDoc>> detailLichHopResponse) {
//                        Util.getIns().hideLoadding();
//                        if (detailLichHopResponse.getData() != null) {
//
//                            if (detailLichHopResponse.getStatus() == 1) {
//
//                                getView().onGetgetdanhgiaGDSuccess(detailLichHopResponse.getData());
//
//                            }
//                        }
//
//                    }
//                });
//    }


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

//    @Override
//    public void GD_tuchamdiem(int thang, String tucham_A, String tucham_B_1, String tucham_B_2, String tucham_B_3, String tucham_B_4,
//                              String tucham_B_5, String tucham_B_6, String tucham_C_1, String tucham_C_2,
//                              String tucham_C_3, String tucham_C_4, String tucham_C_5,
//                              String tucham_C_6, String tucham_C_7, String tucham_D,
//                              String danhgia, String tunhanxet) {
//        Util.getIns().showLoadding(getView().gContext());
//        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
//        String uid = PrefUtil.getToken(getView().gContext()).getUid();
//        NetworkModule.getService().GD_tuchamdiem(token, uid,  thang,  tucham_A,  tucham_B_1,  tucham_B_2,  tucham_B_3,  tucham_B_4,
//                 tucham_B_5,  tucham_B_6,  tucham_C_1,  tucham_C_2,
//                 tucham_C_3,  tucham_C_4,  tucham_C_5,
//                 tucham_C_6,  tucham_C_7,  tucham_D,
//                 danhgia,  tunhanxet).
//                observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Subscriber<Response<Boolean>>() {
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
//                    public void onNext(Response<Boolean> booleanResponse) {
//                        Util.getIns().hideLoadding();
//                        if (booleanResponse.getData()) {
//                            getView().onGetGD_tuchamdiemSuccess();
//                        } else {
//                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
//                        }
//                    }
//                });
//    }
}
