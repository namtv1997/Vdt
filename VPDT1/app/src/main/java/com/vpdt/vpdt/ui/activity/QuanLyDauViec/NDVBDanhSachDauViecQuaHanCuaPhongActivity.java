package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemDanhSachDauViecQuaHanCuaPhong;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachDauViecQuaHanCuaPhongActivity extends AppCompatActivity {
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
    @BindView(R.id.tvCanBoChiDao)
    TextView tvCanBoChiDao;
    @BindView(R.id.tvHanXuLy)
    TextView tvHanXuLy;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;

    @BindView(R.id.rcvTrinhTuTruyenNhan)
    RecyclerView rcvTrinhTuTruyenNhan;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    int id;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndvbdanh_sach_dau_viec_qua_han_cua_phong);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        ItemDanhSachDauViecQuaHanCuaPhong itemDanhSachDauViecQuaHanCuaPhong = getIntent().getParcelableExtra("itemDanhSachDauViecQuaHanCuaPhong");
        if (itemDanhSachDauViecQuaHanCuaPhong != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) itemDanhSachDauViecQuaHanCuaPhong.getTrinhTuChuyenNhans());
            String shortDate = itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap();
            id = itemDanhSachDauViecQuaHanCuaPhong.getId();
            tvNgay.setText(shortDate.substring(0, 5));
            tvHanVanBan.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanVanBan()));
            tvNguoiNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNguoiNhap()));
            tvTrichYeu.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getMoTa()));
            tvNgayNhap.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getCanBoChiDao()));
            tvHanXuLy.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getHanXuLy()));
            tvNoiDungChiDao.setText(String.valueOf(itemDanhSachDauViecQuaHanCuaPhong.getNoiDungChiDao()));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack,
            R.id.tvXemChiTiet, R.id.lnNoiDungVB})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();

                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDauViecChoXuLyActivity.class);
                    intent.putExtra("DauViecChoXuLy", id);
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
        rcvTrinhTuTruyenNhan.setLayoutManager(linearLayoutManager);
        rcvTrinhTuTruyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
