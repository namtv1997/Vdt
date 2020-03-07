package com.vpdt.vpdt.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.presenter.SplashPresenter;
import com.vpdt.vpdt.presenter.SplashView;
import com.vpdt.vpdt.presenter.impl.SplashPresenterImpl;
import com.vpdt.vpdt.util.NetUtil;
import com.vpdt.vpdt.util.PrefUtil;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashView {

    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);

        PrefUtil.saveBoolean(this, "Check_refresh_token", false);
        if (!NetUtil.isNetworkAvailable(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thông báo!")
                    .setMessage("Vui lòng kiểm tra lại kết nối mạng của bạn và khởi động lại app!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .create().show();
            return;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String token_fire = PrefUtil.getString(SplashActivity.this, Key.Refresh_token, "");
//                if (!token_fire.isEmpty()) {
                if (!token_fire.isEmpty()) {
                    //  getPresenter().getCanBoDetail();

                    startActivity(MainActivity.getCallingIntent(SplashActivity.this));
                    SplashActivity.this.finish();
//                    }
                } else {
                    showLogin();
                }
            }
        }, 1500);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess() {
        startActivity(MainActivity.getCallingIntent(this));
        SplashActivity.this.finish();

    }

    @Override
    public void onGetDataFail() {
        showLogin();
    }

    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenterImpl(this);
    }

    public void showLogin() {
        startActivity(LoginActivity.getCallingIntent(SplashActivity.this));
        SplashActivity.this.finish();
    }

}
