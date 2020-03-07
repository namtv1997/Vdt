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
import com.vpdt.vpdt.presenter.DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenter;
import com.vpdt.vpdt.presenter.DanhGiaChamDiemPhanLoaiPGDTruongPhongView;
import com.vpdt.vpdt.presenter.impl.DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DanhGiaChamDiemPhanLoaiPGDTruongPhongFragment extends BaseFragment<DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenter> implements DanhGiaChamDiemPhanLoaiPGDTruongPhongView {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.webview)
    WebView webview;
    String NamLamViec;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_gia_cham_diem_phan_loai_pgd_truong_phong;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void initializeComponents(View view) {
        Util.checkConnection(getActivity());
        ButterKnife.bind(this, view);
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");

        String uid = PrefUtil.getToken(getActivity()).getUid();
        String link = BuildConfig.BASEURL + "/KeHoachCongTacDanhGiaW/DSKeHoachCongTacTP?id_tk=" + uid + "&nam=" + NamLamViec;
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
    public DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenter createPresenter() {
        return new DanhGiaChamDiemPhanLoaiPGDTruongPhongPresenterImpl(this);
    }

    @OnClick({R.id.btnBack, R.id.rlDGCD, R.id.vDGCD, R.id.btnHome})
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