package com.vpdt.vpdt.util;

import android.support.annotation.NonNull;

import androidx.work.Worker;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.Token;
import com.vpdt.vpdt.network.NetworkModule;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MyRequestTokenWorker extends Worker {
    @NonNull
    @Override
    public Result doWork() {
        String token = PrefUtil.getString(getApplicationContext(), Key.Refresh_token, "");
        NetworkModule.getService().refreshToken(token, "refresh_token")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Token token) {
                        Util.getIns().hideLoadding();
                        PrefUtil.saveToken(token, getApplicationContext());
                        PrefUtil.saveInt(getApplicationContext(), Key.LEVEL, token.getLevel());
                        PrefUtil.saveString(getApplicationContext(), Key.Refresh_token, token.getRefreshToken());

                    }

                });

        return Result.RETRY;
    }
}
