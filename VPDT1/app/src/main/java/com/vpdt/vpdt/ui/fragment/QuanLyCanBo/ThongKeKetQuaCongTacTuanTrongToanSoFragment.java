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
import com.vpdt.vpdt.presenter.ThongKeKetQuaCongTacTuanView;
import com.vpdt.vpdt.presenter.ThongKeKetQuaCongTacTuan_Presenter;
import com.vpdt.vpdt.presenter.impl.ThongKeKetQuaCongTacTuanPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThongKeKetQuaCongTacTuanTrongToanSoFragment extends BaseFragment<ThongKeKetQuaCongTacTuan_Presenter> implements ThongKeKetQuaCongTacTuanView{

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.webview)
    WebView webview;

    String NamLamViec;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_thong_ke_ket_qua_cong_tac_tuan_trong_toan_so;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");

        String uid = PrefUtil.getToken(getActivity()).getUid();
        String link = BuildConfig.BASEURL + "/KeHoachCongTacDanhGiaW/ThongKeBaoCao?id_tk=" + uid + "&nam=" + NamLamViec;
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
        return getContext();
    }

    @OnClick({R.id.btnBack, R.id.rlTKKQCTT, R.id.btnHome, R.id.vTKKQCTT})
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
    public ThongKeKetQuaCongTacTuan_Presenter createPresenter() {
        return new ThongKeKetQuaCongTacTuanPresenterImpl(this);
    }

}