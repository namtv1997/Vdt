package com.vpdt.vpdt.ui.activity.QuanLyDauViec;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.DauViecDeXuat;
import com.vpdt.vpdt.model.DeXuatGiaHanChoDuyet;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDeXuatGiaHanDaXuLyActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvHanCu)
    TextView tvHanCu;
    @BindView(R.id.tvHanDeXuat)
    TextView tvHanDeXuat;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvYKienDeXuatHan)
    TextView tvYKienDeXuatHan;
    @BindView(R.id.tvCanBoDeXuat)
    TextView tvCanBoDeXuat;

    int idvb;
    boolean click = false;
    @BindView(R.id.rvTrinhTuChuyenNhan)
    RecyclerView rvTrinhTuChuyenNhan;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbde_xuat_gia_han_da_xu_ly);

        ButterKnife.bind(this);
        Util.checkConnection(this);

        DeXuatGiaHanChoDuyet deXuatGiaHanChoDuyet = getIntent().getParcelableExtra("deXuatGiaHanChoDuyet");
        if (deXuatGiaHanChoDuyet != null) {
            idvb = deXuatGiaHanChoDuyet.getId();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) deXuatGiaHanChoDuyet.getTrinhTuChuyen());
            String shortDate = deXuatGiaHanChoDuyet.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgayNhap.setText(String.valueOf(deXuatGiaHanChoDuyet.getNgayNhap()));
            tvHanCu.setText(String.valueOf(deXuatGiaHanChoDuyet.getHanCu()));
            tvHanDeXuat.setText(String.valueOf(deXuatGiaHanChoDuyet.getHanDeXuat()));
            tvTrichYeu.setText(String.valueOf(deXuatGiaHanChoDuyet.getMoTa()));
            tvNguoiNhap.setText(String.valueOf(deXuatGiaHanChoDuyet.getNguoiNhap()));
            tvHanVanBan.setText(String.valueOf(deXuatGiaHanChoDuyet.getHanVanBan()));
            tvCanBoDeXuat.setText(String.valueOf(deXuatGiaHanChoDuyet.getTenCanBoDeXuat()));
            tvYKienDeXuatHan.setText(String.valueOf(deXuatGiaHanChoDuyet.getLyDoChuyen()));
        }
        DauViecDeXuat dauViecDeXuat = getIntent().getParcelableExtra("dauViecDeXuat");
        if (dauViecDeXuat != null) {
            idvb = dauViecDeXuat.getIdVb();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) dauViecDeXuat.getTrinhtuChuyens());
            String shortDate = dauViecDeXuat.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgayNhap.setText(String.valueOf(dauViecDeXuat.getNgayNhap()));
            tvHanCu.setText(String.valueOf(dauViecDeXuat.getHanCu()));
            tvHanDeXuat.setText(String.valueOf(dauViecDeXuat.getHanDexuat()));
            tvTrichYeu.setText(String.valueOf(dauViecDeXuat.getTenDauviec()));
            tvNguoiNhap.setText(String.valueOf(dauViecDeXuat.getNguoiNhap()));
            tvHanVanBan.setText(String.valueOf(dauViecDeXuat.getHanVanban()));
            tvCanBoDeXuat.setText(String.valueOf(dauViecDeXuat.getCbDexuat()));
            tvYKienDeXuatHan.setText(String.valueOf(dauViecDeXuat.getLyDo()));
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
                    Intent intent = new Intent(this, TTVBDeXuatGiaHanChoXuLyActivity.class);
                    intent.putExtra("idvb", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;
            case R.id.btnBack:
                finish();

                break;

        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuChuyenNhan.setLayoutManager(linearLayoutManager);
        rvTrinhTuChuyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
