package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.model.ItemPhongChuTriChuyenVienChoXuLy;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungDauViecPhongPhoiHopChoXuLyCVPHActivity extends AppCompatActivity {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvCanBoChiDao)
    TextView tvCanBoChiDao;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvHanXuLy)
    TextView tvHanXuLy;

    @BindView(R.id.rvTrinhTuChuyenNhan)
    RecyclerView rvTrinhTuChuyenNhan;
    int id, level;
    TextView tvNgayThangNam;
    EditText edtThemYKien;
    boolean click = false;

    AlertDialog dialog;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_dung_dau_viec_phong_phoi_hop_cho_xu_ly_cvph);
        ButterKnife.bind(this);
        Util.checkConnection(this);
        ItemPhongChuTriChuyenVienChoXuLy itemPhongChuTriChuyenVienChoXuLy1 = getIntent().getParcelableExtra("itemPhongChuTriChuyenVien");
        if (itemPhongChuTriChuyenVienChoXuLy1 != null) {
            id = itemPhongChuTriChuyenVienChoXuLy1.getId();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) itemPhongChuTriChuyenVienChoXuLy1.getTrinhTuChuyenNhan());
            String shortDate = itemPhongChuTriChuyenVienChoXuLy1.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgay.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getCanBoChiDao()));
            tvNoiDungChiDao.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getNoiDungChiDao()));
            tvTrichYeu.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getMoTa()));
            tvNguoiNhap.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getNguoiNhap()));
            tvHanVanBan.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getHanVanBan()));
            tvHanXuLy.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy1.getHanXuLy()));
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
                    Intent intent = new Intent(this, ChiTietDauViecPhongPhoiHopChoXuLyCVPHActivity.class);
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

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuChuyenNhan.setLayoutManager(linearLayoutManager);
        rvTrinhTuChuyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
