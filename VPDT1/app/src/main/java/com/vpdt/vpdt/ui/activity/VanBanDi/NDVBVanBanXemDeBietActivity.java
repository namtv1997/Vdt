package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DataVanBanDi;
import com.vpdt.vpdt.model.DetailVanBanDi;
import com.vpdt.vpdt.presenter.NDVBVanBanXemDeBietPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanXemDeBietView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanXemDeBietPresenterImpl;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanXemDeBietActivity extends BaseActivity<NDVBVanBanXemDeBietPresenter> implements NDVBVanBanXemDeBietView {

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

    int id;

    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_xem_de_biet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DataVanBanDi dataVanBanDi = getIntent().getParcelableExtra("dataVanBanDi");
        if (dataVanBanDi != null) {

            id = dataVanBanDi.getId();
            String shortDate = dataVanBanDi.getThoiGianGui();
            tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
            tvKyHieu.setText(String.valueOf(dataVanBanDi.getKyHieu()));
            tvTrichYeu.setText(String.valueOf(dataVanBanDi.getMota()));
            tvYKien.setText(String.valueOf(dataVanBanDi.getYkien() + "\n" + dataVanBanDi.getCanBoGui() + "\n" + dataVanBanDi.getThoiGianGui()));
            tvNguoiNhap.setText(String.valueOf(dataVanBanDi.getNguoiNhap()));
            if (dataVanBanDi.getTrangThaiCapSo() == 1) {
                tvDaCapSo.setVisibility(View.VISIBLE);
            } else {
                tvChuaCapSo.setVisibility(View.VISIBLE);

            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataVanBanDi.getDuongDanFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanXemDeBietActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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
    public void onGetDataSuccess(DetailVanBanDi detailVanBanDi) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanXemDeBietActivity.class);
                    intent.putExtra("ID_VANBAN_XEM_DE_BIET", id);
                    startActivity(intent);
                    click = true;
                }
                break;
        }
    }

    @Override
    public NDVBVanBanXemDeBietPresenter createPresenter() {
        return new NDVBVanBanXemDeBietPresenterImpl(this);
    }
}
