package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DataVanBanDi;
import com.vpdt.vpdt.presenter.NDVBVanBanTrinhKyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanTrinhKyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanTrinhKyPresenterImpl;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanTrinhKyActivity extends BaseActivity<NDVBVanBanTrinhKyPresenter> implements NDVBVanBanTrinhKyView {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvKyHieu)
    TextView tvKyHieu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvYKien)
    TextView tvYKien;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvChuaCapSo)
    TextView tvChuaCapSo;
    @BindView(R.id.tvDaCapSo)
    TextView tvDaCapSo;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;

    @BindView(R.id.edtYKienGuiDi)
    EditText edtYKienGuiDi;

    @BindView(R.id.llButton)
    LinearLayout llButton;
    int id;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_trinh_ky;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_DI")) {
                id = intent.getIntExtra("ID_VANBAN_DI", 0);
                getPresenter().getvanbanbyid(id);
            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(DataVanBanDi dataVanBanDi) {
        String shortDate = dataVanBanDi.getThoiGianGui();
        tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
        tvKyHieu.setText(String.valueOf(dataVanBanDi.getKyHieu()));
        tvTrichYeu.setText(String.valueOf(dataVanBanDi.getMota()));
        tvYKien.setText(String.valueOf(dataVanBanDi.getYkien()));
        tvNguoiNhap.setText(String.valueOf(dataVanBanDi.getNguoiNhap()));
        if (dataVanBanDi.getTrangThaiCapSo() == 1) {
            tvDaCapSo.setVisibility(View.VISIBLE);
        } else {
            tvChuaCapSo.setVisibility(View.VISIBLE);
            llButton.setVisibility(View.VISIBLE);
        }
        tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataVanBanDi.getDuongDanFile()));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(NDVBVanBanTrinhKyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void tralaivanbanSucess() {
        Toast.makeText(this, "Đã trả lại", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void dongyvanbanSucess() {
        Toast.makeText(this, "Đã đồng ý", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.btnTraLai, R.id.btnDongy})
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
            case R.id.btnTraLai:
                if (edtYKienGuiDi.getText().toString().trim().isEmpty()) {
                    Toast.makeText(this, "Chưa nhập ý kiến gửi đi", Toast.LENGTH_SHORT).show();
                } else {
                    getPresenter().tralaivanban(id, edtYKienGuiDi.getText().toString());
                }
                break;
            case R.id.btnDongy:
                getPresenter().dongyvanban(id);
                break;
        }
    }

    @Override
    public NDVBVanBanTrinhKyPresenter createPresenter() {
        return new NDVBVanBanTrinhKyPresenterImpl(this);
    }
}
