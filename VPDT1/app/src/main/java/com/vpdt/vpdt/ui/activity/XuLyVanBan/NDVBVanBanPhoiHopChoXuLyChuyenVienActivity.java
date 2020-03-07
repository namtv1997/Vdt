package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.VanBanPhoiHopChoXuLyChuyenVien;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanPhoiHopChoXuLyChuyenVienActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeuNDVBDSVBDenChoLDXL)
    TextView tvTrichYeuNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvChiDaoCuaPhong)
    TextView tvChiDaoCuaPhong;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;

    @BindView(R.id.rcvTrinhTuXuLy1)
    RecyclerView rcvTrinhTuXuLy1;
    boolean click = false;
    int idvb;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbvan_ban_phoi_hop_cho_xu_ly_chuyen_vien);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanPhoiHopChoXuLyChuyenVien vanBanPhoiHopChoXuLy = getIntent().getParcelableExtra("vanBanPhoiHopChoXuLy");
        if (vanBanPhoiHopChoXuLy != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanPhoiHopChoXuLy.getTrinhTuXuLy());
            idvb = vanBanPhoiHopChoXuLy.getId();
            String shortdate = vanBanPhoiHopChoXuLy.getNgayNhap();
            tvNgay.setText(shortdate.substring(0, 5));
            tvSKH.setText(String.valueOf(vanBanPhoiHopChoXuLy.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopChoXuLy.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanPhoiHopChoXuLy.getNoiGui()));
            tvTrichYeuNDVBDSVBDenChoLDXL.setText(String.valueOf(vanBanPhoiHopChoXuLy.getMoTa()));
            tvHanGiaiQuyet.setText(String.valueOf(vanBanPhoiHopChoXuLy.getHanGiaiQuyet()));
            if (vanBanPhoiHopChoXuLy.getChiDaoCuaPhong() == null) {
            } else {
                tvChiDaoCuaPhong.setText(String.valueOf("Chỉ đạo của phòng: " + vanBanPhoiHopChoXuLy.getChiDaoCuaPhong()));
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopChoXuLy.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanPhoiHopChoXuLyChuyenVienActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanPhoiHopDaChiDaoActivity.class);
                    intent.putExtra("idvb", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;
        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTrinhTuXuLy1.setLayoutManager(linearLayoutManager);
        rcvTrinhTuXuLy1.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
