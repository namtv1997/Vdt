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
import com.vpdt.vpdt.presenter.GDSoTuNhanXetDanhGiaKetQuaThangPresenter;
import com.vpdt.vpdt.presenter.GDSoTuNhanXetDanhGiaKetQuaThangView;
import com.vpdt.vpdt.presenter.impl.GDSoTuNhanXetDanhGiaKetQuaThangPresenterImpl;
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

public class GDSoTuNhanXetDanhGiaKetQuaThangFragment extends BaseFragment<GDSoTuNhanXetDanhGiaKetQuaThangPresenter> implements GDSoTuNhanXetDanhGiaKetQuaThangView {
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    String NamLamViec;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_gd_so_tu_nhan_xet_danh_gia_ket_qua_thang;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initializeComponents(View view) {
        Util.checkConnection(getActivity());
        ButterKnife.bind(this, view);
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");

        DateFormat df = new SimpleDateFormat("MM");
        int thang = Integer.parseInt(df.format(new Date())) - 1;
        String uid = PrefUtil.getToken(getActivity()).getUid();
        String link = BuildConfig.BASEURL + "/KeHoachCongTacDanhGiaW/XemKeHoachCongTacGD?id_tk=" + uid + "&thang=" + thang + "&nam=" + NamLamViec;
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

    @Override
    public GDSoTuNhanXetDanhGiaKetQuaThangPresenter createPresenter() {
        return new GDSoTuNhanXetDanhGiaKetQuaThangPresenterImpl(this);
    }

    @OnClick({R.id.btnBack, R.id.btnHome, R.id.rlgd})
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
}