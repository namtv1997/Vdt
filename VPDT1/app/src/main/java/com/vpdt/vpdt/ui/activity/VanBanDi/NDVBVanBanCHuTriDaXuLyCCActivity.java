package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanChuTriDaXuLyCC;
import com.vpdt.vpdt.presenter.VanBanChuTriDaXuLyCCPresenter;
import com.vpdt.vpdt.presenter.VanBanChuTriDaXuLyCCView;
import com.vpdt.vpdt.presenter.impl.VanBanChuTriDaXuLyCCPresenterImpl;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanCHuTriDaXuLyCCActivity extends BaseActivity<VanBanChuTriDaXuLyCCPresenter> implements VanBanChuTriDaXuLyCCView {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvKyHieu)
    TextView tvKyHieu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvSodi)
    TextView tvSodi;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvChuaCapSo)
    TextView tvChuaCapSo;
    @BindView(R.id.tvDaCapSo)
    TextView tvDaCapSo;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;

    @BindView(R.id.btnXoaDuLieu)
    Button btnXoaDuLieu;

    int id;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_chu_tri_da_xu_ly_cc;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanChuTriDaXuLyCC vanBanDiDaXuly = getIntent().getParcelableExtra("vanBanChuTriChoXuLyCC");
        if (vanBanDiDaXuly != null) {
            id = vanBanDiDaXuly.getId();
            String shortDate = vanBanDiDaXuly.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgayNhap.setText(String.valueOf(vanBanDiDaXuly.getNgayNhap()));
            tvKyHieu.setText(String.valueOf(vanBanDiDaXuly.getSoKyHieu()));
            tvTrichYeu.setText(String.valueOf(vanBanDiDaXuly.getMoTa()));
            tvSodi.setText(String.valueOf(vanBanDiDaXuly.getNoiNhan()));
            tvNguoiNhap.setText(String.valueOf(vanBanDiDaXuly.getNguoiNhap()));
            if (vanBanDiDaXuly.getAllowDelete().equals("true")) {
                btnXoaDuLieu.setVisibility(View.VISIBLE);
            } else {
                btnXoaDuLieu.setVisibility(View.GONE);
            }
            if (vanBanDiDaXuly.getSoVBDi() > 0) {
                tvDaCapSo.setVisibility(View.VISIBLE);
            } else {
                tvChuaCapSo.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDiDaXuly.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanCHuTriDaXuLyCCActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess() {

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {

    }

    @Override
    public void onGetDeleteSuccess() {
        Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.btnXoaDuLieu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanTrinhKyActivity.class);
                    intent.putExtra("ID_VANBAN_DI", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnXoaDuLieu:
                getPresenter().DeleteVBChuTriDaXuLyCC(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id);
                break;
        }
    }

    @Override
    public VanBanChuTriDaXuLyCCPresenter createPresenter() {
        return new VanBanChuTriDaXuLyCCPresenterImpl(this);
    }
}