package com.vpdt.vpdt.presenter.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.model.CanBo;
import com.vpdt.vpdt.model.Contact;
import com.vpdt.vpdt.model.MenuLeft;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanTheoLoaiNoiDen;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.MainPresenter;
import com.vpdt.vpdt.presenter.MainView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {
    private FirebaseAuth mAuth;

    public MainPresenterImpl(MainView view) {
        super(view);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void getCanBoDetail() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getCanBo(token, uid, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<CanBo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {

                        getView().onGetDataFail();
                    }

                    @Override
                    public void onNext(Response<CanBo> userResponse) {
                        Util.getIns().hideLoadding();
                        if (userResponse.getStatus() == 1) {
                            PrefUtil.saveDataCanBo(userResponse.getData(), getView().gContext());
                            getView().onGetDataCanBoSuccess(userResponse.getData());
                        }

                    }

                });
    }

    @Override
    public void getAllTK_noiden() {
        //   Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getAllTK_noiden(token).
                observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<VanBanTheoLoaiNoiDen>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<ArrayList<VanBanTheoLoaiNoiDen>> arrayListResponseGiamDoc) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponseGiamDoc.getData() != null) {

                            if (arrayListResponseGiamDoc.getStatus() == 1) {

                                getView().ongetAllTK_noidenSuccess(arrayListResponseGiamDoc.getData());

                            }
                        }

                    }
                });
    }

    @Override
    public void countThongBao(int trangThai) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().countThongBao(token, trangThai, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
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
                    public void onNext(Response<Integer> response) {
                        Util.getIns().hideLoadding();
                        getView().onGetCountVBSuccess(response);

                    }
                });
    }

    @Override
    public void getMenu(String nam, String key, String is_right) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getMenu(token, nam, uid, key, is_right)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<ArrayList<Contact>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onGetDataFail();
                    }

                    @Override
                    public void onNext(Response<ArrayList<Contact>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1) {

                            getView().onGetDataSuccess(arrayListResponse.getData());
                        } else {
                            getView().onGetDataFail();
                        }
                    }
                });


    }

    @Override
    public void getMenuLeft(String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getMenuLeft(token, nam, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<ArrayList<MenuLeft>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onGetDataFail();
                    }

                    @Override
                    public void onNext(Response<ArrayList<MenuLeft>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1) {
                            getView().onGetMenuLeftSuccess(arrayListResponse.getData());
                        } else {
                            getView().onGetDataFail();
                        }
                    }
                });


    }

    @Override
    public void logOut() {
        Util.getIns().showLoadding(getView().gContext());
        String token_fire = PrefUtil.getString(getView().gContext(), Key.TOKEN_FIRE, "");
        if (token_fire == null || token_fire.isEmpty()) {
            token_fire = "null123456";
        }
        NetworkModule.getService().dangXuat(token_fire)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        if (booleanResponse.getData()) {
                            SharedPreferences preferences = getView().gContext().getSharedPreferences(Key.APP_PREFERENCE, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = preferences.edit();
                            editor.remove(Key.Refresh_token);
                            editor.remove(Key.DATA_USER);
                            editor.clear();
                            editor.apply();
                            getView().onLogOutSuccess();
                        } else {
                            Util.showMessenger(booleanResponse.getMessage(), getView().gContext());
                        }
                    }
                });
    }

    @Override
    public void getThongBaoHome() {
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getThongBaoHome(token, PrefUtil.getString(getView().gContext(), Key.NAM_LAM_VIEC, ""))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                    }

                    @Override
                    public void onNext(Response<String> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1) {
                            getView().onGetThongBaoSuccess(arrayListResponse.getData());
                        }
                    }
                });
    }
}
