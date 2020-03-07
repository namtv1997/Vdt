package com.vpdt.vpdt.ui.activity.VanBanDiDonViCapHai;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DanhSachVanBanDi;
import com.vpdt.vpdt.ui.activity.VanBanDonViCapHai.TTVBDetailVanBanChoXuLyGQActivity;
import com.vpdt.vpdt.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachVanBanCuaPhongLV3Activity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDi)
    TextView tvSoDi;
    @BindView(R.id.tvNoiNhan)
    TextView tvNoiNhan;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvXemFileDinhKem)
    TextView tvXemFileDinhKem;
    @BindView(R.id.tvVBTL)
    TextView tvVBTL;

    int id;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbdanh_sach_van_ban_cua_phong_lv3);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DanhSachVanBanDi detailVanBanDiTongThe = getIntent().getParcelableExtra("danhSachVanBanDi");
        if (detailVanBanDiTongThe != null) {
            id = detailVanBanDiTongThe.getId();
            String shortDate = detailVanBanDiTongThe.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoDi.setText(String.valueOf(detailVanBanDiTongThe.getSoVBDi()));
            tvNoiNhan.setText(String.valueOf(detailVanBanDiTongThe.getNoiNhan()));
            tvSoKyHieu.setText(String.valueOf(detailVanBanDiTongThe.getSoKyHieu()));
            tvSoDen.setText(String.valueOf("Trả lời cho văn bản đến số: " + detailVanBanDiTongThe.getSoDen()));
            if (detailVanBanDiTongThe.getLoaiVanBan() == null || detailVanBanDiTongThe.getLoaiVanBan().isEmpty()) {
                tvLoaiVanban.setVisibility(View.GONE);
                tvVBTL.setVisibility(View.GONE);
            } else {
                tvLoaiVanban.setText(String.valueOf(detailVanBanDiTongThe.getLoaiVanBan()));
            }
            tvTrichYeu.setText(String.valueOf(detailVanBanDiTongThe.getMoTa()));
            if (detailVanBanDiTongThe.getNguoiKy() == null || detailVanBanDiTongThe.getNguoiKy().isEmpty()) {
                tvNguoiKy.setVisibility(View.GONE);
            } else {
                tvNguoiKy.setText(String.valueOf("Người ký: " + detailVanBanDiTongThe.getNguoiKy()));
            }
            tvXemFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailVanBanDiTongThe.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDanhSachVanBanCuaPhongLV3Activity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

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
