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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DauViecDeXuat;
import com.vpdt.vpdt.model.DeXuatGiaHanChoDuyet;
import com.vpdt.vpdt.presenter.NDVBDSDVDeXuatGiaHanChoXuLyPresenter;
import com.vpdt.vpdt.presenter.NDVBDSDVDeXuatGiaHanChoXuLyView;
import com.vpdt.vpdt.presenter.impl.NDVBDSDVDeXuatGiaHanChoXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDSDVDeXuatGiaHanChoXuLyActivity extends BaseActivity<NDVBDSDVDeXuatGiaHanChoXuLyPresenter> implements NDVBDSDVDeXuatGiaHanChoXuLyView,
        DatePickerDialog.OnDateSetListener {

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

    @BindView(R.id.btnDongYChiDao)
    Button btnDongYChiDao;
    @BindView(R.id.btnDeXuatGiaHan)
    Button btnDeXuatGiaHan;

    @BindView(R.id.lnBTN)
    LinearLayout lnBTN;

    TextView tvNgayThangNam;
    EditText edtThemYKien;
    EditText edtTuChoi;
    int id, level;
    int idvb;

    AlertDialog dialog;
    boolean click = false;
    @BindView(R.id.rvTrinhTuChuyenNhan)
    RecyclerView rvTrinhTuChuyenNhan;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdsdvde_xuat_gia_han_cho_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level != 5) {
            btnDongYChiDao.setText("ĐỀ XUẤT GIA HẠN");
        }
        if (level == 8) {
            lnBTN.setVisibility(View.GONE);
            DeXuatGiaHanChoDuyet dauViecDeXuat = getIntent().getParcelableExtra("deXuatGiaHanChoDuyet");
            if (dauViecDeXuat != null) {
                id = dauViecDeXuat.getId();
                idvb = dauViecDeXuat.getIdDeXuat();
                if (dauViecDeXuat.getAllowDeXuatGiaHan()) {
                    btnDeXuatGiaHan.setVisibility(View.VISIBLE);
                }
                recyclerviewTrinhTuChuyenNhan((ArrayList<String>) dauViecDeXuat.getTrinhTuChuyen());
                String shortDate = dauViecDeXuat.getNgayNhap();
                tvNgay.setText(shortDate.substring(0, 5));
                tvNgayNhap.setText(String.valueOf(dauViecDeXuat.getNgayNhap()));
                tvHanCu.setText(String.valueOf(dauViecDeXuat.getHanCu()));
                tvHanDeXuat.setText(String.valueOf(dauViecDeXuat.getHanDeXuat()));
                tvTrichYeu.setText(String.valueOf(dauViecDeXuat.getMoTa()));
                tvNguoiNhap.setText(String.valueOf(dauViecDeXuat.getNguoiNhap()));
                tvHanVanBan.setText(String.valueOf(dauViecDeXuat.getHanVanBan()));
                tvCanBoDeXuat.setText(String.valueOf(dauViecDeXuat.getTenCanBoDeXuat()));
                tvYKienDeXuatHan.setText(String.valueOf(dauViecDeXuat.getLyDoChuyen()));
            }
        } else {
            DauViecDeXuat dauViecDeXuat = getIntent().getParcelableExtra("dauViecDeXuat");
            if (dauViecDeXuat != null) {
                id = dauViecDeXuat.getId();
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack, R.id.btnDongYChiDao, R.id.btnTuChoi, R.id.btnDeXuatGiaHan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDeXuatGiaHanChoXuLyActivity.class);
                    intent.putExtra("iddv", idvb);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnDongYChiDao:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_dexuatgiahandongy, null);
                builderDongYChiDao.setView(viewDongYChiDao);
                dialog = builderDongYChiDao.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
                        getPresenter().dongygiahan(id, idvb, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_dexuatgiahantuchoi, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tvNgayThangNam = viewtuchoi.findViewById(R.id.tvNgayThangNam);
                edtTuChoi = viewtuchoi.findViewById(R.id.edtTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnTuChoi = viewtuchoi.findViewById(R.id.btnTuChoi);
                btnDong1.setOnClickListener(new View.OnClickListener() {
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
                btnTuChoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuchoigiahan(id, idvb, tvNgayThangNam.getText().toString(), edtTuChoi.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.btnDeXuatGiaHan:
                AlertDialog.Builder builderdexuat = new AlertDialog.Builder(this);
                LayoutInflater inflaterdexuat = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewdexuat = inflaterdexuat.inflate(R.layout.dialog_dexuatgiahantuchoi, null);
                builderdexuat.setView(viewdexuat);
                builderdexuat.setCancelable(false);
                dialog = builderdexuat.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tvNgayThangNam = viewdexuat.findViewById(R.id.tvNgayThangNam);
                edtTuChoi = viewdexuat.findViewById(R.id.edtTuChoi);
                TextView tvlydo = viewdexuat.findViewById(R.id.tvlydo);
                tvlydo.setText("Lý do đề xuất");
                Button btnDong2 = viewdexuat.findViewById(R.id.btnDong);
                Button btndexuat = viewdexuat.findViewById(R.id.btnTuChoi);
                btnDong2.setOnClickListener(new View.OnClickListener() {
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
                btndexuat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().deXuatGiaHanDauViecChoDuyetCV(id, tvNgayThangNam.getText().toString(), edtTuChoi.getText().toString(), idvb);
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
    public void tuchoigiahan() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public void dongygiahan() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public void deXuatGiaHan() {
        Toast.makeText(this, "Đã đề xuất", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public NDVBDSDVDeXuatGiaHanChoXuLyPresenter createPresenter() {
        return new NDVBDSDVDeXuatGiaHanChoXuLyPresenterImpl(this);
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
