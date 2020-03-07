package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemDauViec;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachDauViecPhongPhoiHopActivity extends AppCompatActivity {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvNoiDungChiDaoCuaDC)
    TextView tvNoiDungChiDaoCuaDC;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvHanXuLy)
    TextView tvHanXuLy;
    @BindView(R.id.rcvTrinhTuTruyenNhan)
    RecyclerView rcvTrinhTuTruyenNhan;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    int id;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbdanh_sach_dau_viec_phong_phoi_hop);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        ItemDauViec itemDauViec = getIntent().getParcelableExtra("itemDauViecPhoiHop");
        if (itemDauViec != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) itemDauViec.getTrinhTuChuyenNhans());
            id = itemDauViec.getId();
            String shortDate = itemDauViec.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            String hvb = itemDauViec.getHanVanBan();
            if (hvb.equals("01/01/0001")) {
                tvHanVanBan.setText(String.valueOf(""));
            } else {
                tvHanVanBan.setText(String.valueOf(itemDauViec.getHanVanBan()));
            }
            tvNguoiNhap.setText(String.valueOf(itemDauViec.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDauViec.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDauViec.getNgayNhap()));
            tvNoiDungChiDaoCuaDC.setText(String.valueOf("Nội dung chỉ đạo của đ/c " + itemDauViec.getCanBoChiDao() + ":"));
            tvNoiDungChiDao.setText(String.valueOf(itemDauViec.getNoiDungChiDao()));
            String hxl = itemDauViec.getHanXuLy();
            if (hxl.equals("01/01/0001")) {
                tvHanXuLy.setText(String.valueOf(""));
            } else {
                tvHanXuLy.setText(String.valueOf(itemDauViec.getHanXuLy()));
            }
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
                    Intent intent = new Intent(this, TTVBDauViecChoXuLyActivity.class);
                    intent.putExtra("DauViecChoXuLy", id);
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
        rcvTrinhTuTruyenNhan.setLayoutManager(linearLayoutManager);
        rcvTrinhTuTruyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
