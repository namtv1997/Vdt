package com.vpdt.vpdt.ui.activity.VanBanDonViCapHai;

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
import com.vpdt.vpdt.model.VanBanChoXuLyLV5;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChoXuLyVBChuTriLV5Activity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvCanBoChiDao)
    TextView tvCanBoChiDao;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;

    @BindView(R.id.rcvChuyenNhan)
    RecyclerView rcvChuyenNhan;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    boolean click = false;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_ban_cho_xu_ly_vbchu_tri_lv5);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanChoXuLyLV5 vanBanPhoiHopDaChiDao = getIntent().getParcelableExtra("vanBanChoXuLyLV5");
        if (vanBanPhoiHopDaChiDao != null) {
            id = vanBanPhoiHopDaChiDao.getId();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanPhoiHopDaChiDao.getChuyenNhans());
            tvSKH.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoDen()));
            tvNoiGui.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiGui()));
            tvNgay.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNgayNhap()));
            tvTrichYeu.setText(String.valueOf(vanBanPhoiHopDaChiDao.getMoTa() + "\n" + vanBanPhoiHopDaChiDao.getNoiDungVanBan()));
            tvCanBoChiDao.setText(String.valueOf("Nội dung chỉ đạo của đ/c " + vanBanPhoiHopDaChiDao.getCanBoChiDao()));
            tvNoiDungChiDao.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiDungChiDao()));
            tvDiaDiem.setText(String.valueOf("(Vào hồi: "
                    + vanBanPhoiHopDaChiDao.getGiayMoiGio() + " ngày " + vanBanPhoiHopDaChiDao.getGiayMoiNgay() + ", tại "
                    + vanBanPhoiHopDaChiDao.getGiayMoiDiaDiem() + ")"));
            if (vanBanPhoiHopDaChiDao.getGiayMoiGio().isEmpty()){
                tvDiaDiem.setVisibility(View.GONE);
            }else {
                tvDiaDiem.setVisibility(View.VISIBLE);
            }

            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChoXuLyVBChuTriLV5Activity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.imvBack, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDetailVanBanChoXuLyGQActivity.class);
                    intent.putExtra("idvb", id);
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
        rcvChuyenNhan.setLayoutManager(linearLayoutManager);
        rcvChuyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
