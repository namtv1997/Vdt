package com.vpdt.vpdt.ui.fragment.QuanLyCanBo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.network.BuildConfig;
import com.vpdt.vpdt.presenter.XemKeHoachKetQuaCongTacThangCuaCacPhongPresenter;
import com.vpdt.vpdt.presenter.XemKeHoachKetQuaCongTacThangCuaCacPhongView;
import com.vpdt.vpdt.presenter.impl.XemKeHoachKetQuaCongTacThangCuaCacPhongPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XemKeHoachKetQuaCongTacThangCuaCacPhongFragment extends BaseFragment<XemKeHoachKetQuaCongTacThangCuaCacPhongPresenter> implements XemKeHoachKetQuaCongTacThangCuaCacPhongView {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.webview)
    WebView webview;

    String NamLamViec;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_xem_ke_hoach_ket_qua_cong_tac_thang_cua_phong;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");

        String uid = PrefUtil.getToken(getActivity()).getUid();
        String link = BuildConfig.BASEURL + "/KeHoachCongTacDanhGiaW/DskeHoachCongTacThangLD?id_tk=" + uid + "&nam=" + NamLamViec;
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Util.getIns().showLoadding(getActivity());
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Util.getIns().hideLoadding();
            }
        });
        webview.loadUrl(link);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    @Override
    public Context gContext() {
        return getActivity();
    }

    @OnClick({R.id.btnBack, R.id.vKHKQCCT, R.id.rlKHKQCCT, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
        }
    }

    @Override
    public XemKeHoachKetQuaCongTacThangCuaCacPhongPresenter createPresenter() {
        return new XemKeHoachKetQuaCongTacThangCuaCacPhongPresenterImpl(this);
    }
}