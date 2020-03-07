package com.vpdt.vpdt.ui.activity.VanBanDonViCapHai;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachVanBanTongTheActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvNoiDung)
    TextView tvNoiDung;
    @BindView(R.id.tvXemFileDinhKem)
    TextView tvXemFileDinhKem;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvVBTL)
    TextView tvVBTL;

    int id;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbdanh_sach_van_ban_tong_the);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanTongTheDonViCapHai detailVanBanDiTongThe = getIntent().getParcelableExtra("vanBanTongTheDonViCapHai");
        if (detailVanBanDiTongThe != null) {
            id = detailVanBanDiTongThe.getId();
            String shortDate = detailVanBanDiTongThe.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNoiGui.setText(String.valueOf(detailVanBanDiTongThe.getNoiGuiDen()));
            tvSoKyHieu.setText(String.valueOf(detailVanBanDiTongThe.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(detailVanBanDiTongThe.getSoDen()));
            if (detailVanBanDiTongThe.getLoaiVanban() == null || detailVanBanDiTongThe.getLoaiVanban().isEmpty()) {
                tvLoaiVanban.setVisibility(View.GONE);
                tvVBTL.setVisibility(View.GONE);
            } else {
                tvLoaiVanban.setText(String.valueOf(detailVanBanDiTongThe.getLoaiVanban()));
            }
            tvTrichYeu.setText(String.valueOf(detailVanBanDiTongThe.getMoTa()));
            if (detailVanBanDiTongThe.getNoiDung() == null || detailVanBanDiTongThe.getNoiDung().isEmpty()) {
                tvNoiDung.setVisibility(View.GONE);
            } else {
                tvNoiDung.setText(String.valueOf(detailVanBanDiTongThe.getNoiDung()));
            }
            if (detailVanBanDiTongThe.getGiayMoiGio() == null || detailVanBanDiTongThe.getGiayMoiGio().isEmpty()) {
                tvNgayGio.setVisibility(View.GONE);
            } else {
                tvNgayGio.setText(String.valueOf("(Vào hồi: "
                        + detailVanBanDiTongThe.getGiayMoiGio() + " ngày " + detailVanBanDiTongThe.getGiayMoiNgay() + ", tại "
                        + detailVanBanDiTongThe.getGiayMoiDiaDiem() + ")"));
            }
            tvPhongChuTri.setText(String.valueOf(detailVanBanDiTongThe.getPhongChuTri()));
            tvXemFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailVanBanDiTongThe.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDanhSachVanBanTongTheActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDetailVanBanChoXuLyGQActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnBack:
                finish();
                break;
        }
    }
}
