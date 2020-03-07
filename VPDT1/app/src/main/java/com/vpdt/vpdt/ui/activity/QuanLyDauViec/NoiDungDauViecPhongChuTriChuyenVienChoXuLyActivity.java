package com.vpdt.vpdt.ui.activity.QuanLyDauViec;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.ItemPhongChuTriChuyenVienChoXuLy;
import com.vpdt.vpdt.presenter.NoiDungDauViecPhongChuTriChuyenVienChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NoiDungDauViecPhongChuTriChuyenVienChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NoiDungDauViecPhongChuTriChuyenVienChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungDauViecPhongChuTriChuyenVienChoXuLyActivity extends BaseActivity<NoiDungDauViecPhongChuTriChuyenVienChoXuLyPresenter> implements
        NoiDungDauViecPhongChuTriChuyenVienChoXuLyView, DatePickerDialog.OnDateSetListener {
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

    @BindView(R.id.btnDeXuat)
    Button btnDeXuat;

    @BindView(R.id.rvTrinhTuChuyenNhan)
    RecyclerView rvTrinhTuChuyenNhan;
    int id, level;
    TextView tvNgayThangNam;
    EditText edtThemYKien;

    boolean click = false;
    AlertDialog dialog;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_dau_viec_phong_chu_tri_chuyen_vien_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        ItemPhongChuTriChuyenVienChoXuLy itemPhongChuTriChuyenVienChoXuLy = getIntent().getParcelableExtra("itemPhongChuTriChuyenVienChoXuLy");
        if (itemPhongChuTriChuyenVienChoXuLy != null) {
            id = itemPhongChuTriChuyenVienChoXuLy.getId();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) itemPhongChuTriChuyenVienChoXuLy.getTrinhTuChuyenNhan());
            String shortDate = itemPhongChuTriChuyenVienChoXuLy.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgay.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getNgayNhap()));
            tvCanBoChiDao.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getCanBoChiDao()));
            tvNoiDungChiDao.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getNoiDungChiDao()));
            tvTrichYeu.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getMoTa()));
            tvNguoiNhap.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getNguoiNhap()));
            tvHanVanBan.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getHanVanBan()));
            tvHanXuLy.setText(String.valueOf(itemPhongChuTriChuyenVienChoXuLy.getHanXuLy()));
        }

        ItemPhongChuTriChuyenVienChoXuLy itemPhongChuTriChuyenVienChoXuLy1 = getIntent().getParcelableExtra("itemPhongChuTriChuyenVien");
        if (itemPhongChuTriChuyenVienChoXuLy1 != null) {
            id = itemPhongChuTriChuyenVienChoXuLy1.getId();
            btnDeXuat.setVisibility(View.GONE);
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

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack, R.id.btnDeXuat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    if (level == 8) {
                        Intent intent = new Intent(this, ChiTietDauViecChoXuLyActivity.class);
                        intent.putExtra("idvb", id);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(this, TTVBDauViecChoXuLyActivity.class);
                        intent.putExtra("DauViecChoXuLy", id);
                        startActivity(intent);
                    }
                    click = true;
                }
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnDeXuat:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_dexuatgiahandongy, null);
                builderDongYChiDao.setView(viewDongYChiDao);
                dialog = builderDongYChiDao.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                TextView tvLyDo = viewDongYChiDao.findViewById(R.id.tvLyDo);
                tvLyDo.setText("Lý do đề xuất:");
                tvNgayThangNam = viewDongYChiDao.findViewById(R.id.tvNgayThangNam);
                edtThemYKien = viewDongYChiDao.findViewById(R.id.edtThemYKien);
                Button btnDong = viewDongYChiDao.findViewById(R.id.btnDong);
                Button btnDongy = viewDongYChiDao.findViewById(R.id.btnDongy);
                btnDong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                tvNgayThangNam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDatePickerDialog();
                    }
                });
                btnDongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().deXuatGiaHanDauViecPhongChuTriChoXuLyCV(id, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
                    }
                });
                dialog.show();
                break;
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void deXuatGiaHanDauViecPhongChuTriChoXuLyCVSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NoiDungDauViecPhongChuTriChuyenVienChoXuLyPresenter createPresenter() {
        return new NoiDungDauViecPhongChuTriChuyenVienChoXuLyPresenterImpl(this);
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuChuyenNhan.setLayoutManager(linearLayoutManager);
        rvTrinhTuChuyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year,
                          int monthOfYear, int dayOfMonth) {
        String date;
        if (monthOfYear + 1 < 10) {
            if (dayOfMonth < 10) {
                date = "0" + dayOfMonth + "/" + "0" + (monthOfYear + 1) + "/" + year;
            } else {
                date = dayOfMonth + "/" + "0" + (monthOfYear + 1) + "/" + year;
            }
        } else {
            if (dayOfMonth < 10) {
                date = "0" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            } else {
                date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
            }
        }
        tvNgayThangNam.setText(date);
    }
}
