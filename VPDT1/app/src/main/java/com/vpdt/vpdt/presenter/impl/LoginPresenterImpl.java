package com.vpdt.vpdt.presenter.impl;


import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.Token;
import com.vpdt.vpdt.base.BasePresenterImpl;
import com.vpdt.vpdt.network.NetworkModule;
import com.vpdt.vpdt.presenter.LoginPresenter;
import com.vpdt.vpdt.presenter.LoginView;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter {
    private static final String TAG = "LoginActivity";
    private FirebaseAuth mAuth;
    int level;

    public LoginPresenterImpl(LoginView view) {
        super(view);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String username, String password, String nam) {
        Util.getIns().showLoadding(getView().gContext());
        String token_fire = PrefUtil.getString(getView().gContext(), Key.TOKEN_FIRE, "");

        if (token_fire.isEmpty()) {
            token_fire = FirebaseInstanceId.getInstance().getToken();
        } else {
            token_fire = PrefUtil.getString(getView().gContext(), Key.TOKEN_FIRE, "");
        }
        if (token_fire == null || token_fire.isEmpty()) {
            token_fire = "null123456";
        }
        PrefUtil.saveString(getView().gContext(), Key.TOKEN_FIRE, token_fire);
        NetworkModule.getService().login(username, password, token_fire, "password", nam)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onFailure(getView().gContext().getString(R.string.username_or_password_incorrect));
                    }

                    @Override
                    public void onNext(Token token) {
                        Util.getIns().hideLoadding();
                        PrefUtil.saveToken(token, getView().gContext());
                        PrefUtil.saveInt(getView().gContext(), Key.LEVEL, token.getLevel());
                        PrefUtil.saveString(getView().gContext(), Key.Refresh_token, token.getRefreshToken());
                        getView().onLoginSuccess();
                    }

                });
    }

}
