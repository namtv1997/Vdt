package com.vpdt.vpdt.ui.activity.XuLyGiayMoi;

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
import com.vpdt.vpdt.model.GiayMoiPhoiHopDaXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NDVBGiayMoiPhoiHopDaXuLyTPCCActivity extends AppCompatActivity {

    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;

    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    boolean click = false;
    int idvb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbgiay_moi_phoi_hop_da_xu_ly_tpcc);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        GiayMoiPhoiHopDaXuLy gmPhoiHopChoXL = getIntent().getParcelableExtra("giayMoiPhoiHopDaXuLy");
        if (gmPhoiHopChoXL != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) gmPhoiHopChoXL.getTrinhTuXuLy());
            idvb = gmPhoiHopChoXL.getId();
            String shortdate = gmPhoiHopChoXL.getNgayNhap();
            tvNgay.setText(shortdate.substring(0, 5));
            tvSKH.setText(String.valueOf(gmPhoiHopChoXL.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(gmPhoiHopChoXL.getSoDen()));
            tvNoigui.setText(String.valueOf(gmPhoiHopChoXL.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(gmPhoiHopChoXL.getMoTa()));
            if (gmPhoiHopChoXL.getGiayMoiGio().isEmpty() || gmPhoiHopChoXL.getGiayMoiGio() == null) {
                tvDiaDiem.setVisibility(View.GONE);
            } else {
                tvDiaDiem.setText(String.valueOf("(Vào hồi: "
                        + gmPhoiHopChoXL.getGiayMoiGio() + " ngày " + gmPhoiHopChoXL.getGiayMoiNgay() + ", tại "
                        + gmPhoiHopChoXL.getGiayMoiDiaDiem() + ")"));
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gmPhoiHopChoXL.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBGiayMoiPhoiHopDaXuLyTPCCActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuXuLy.setLayoutManager(linearLayoutManager);
        rvTrinhTuXuLy.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
