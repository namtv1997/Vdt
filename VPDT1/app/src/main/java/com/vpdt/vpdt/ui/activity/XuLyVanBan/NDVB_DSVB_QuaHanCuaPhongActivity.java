package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DSVB_QuaHan;
import com.vpdt.vpdt.model.TrinhTuKy;
import com.vpdt.vpdt.presenter.NDVB_DSVB_QuaHanPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVB_QuaHanView;
import com.vpdt.vpdt.presenter.impl.NDVB_DSVB_QuaHanPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NDVB_DSVB_QuaHanCuaPhongActivity extends BaseActivity<NDVB_DSVB_QuaHanPresenter> implements NDVB_DSVB_QuaHanView,
        AdapterFileDinhKem.OnItemClickListener, DatePickerDialog.OnDateSetListener {

    @BindView(R.id.tvSKH)
    TextView skh;
    @BindView(R.id.tvSoDen)
    TextView sodenvang;
    @BindView(R.id.tvNoiGui)
    TextView noigui;
    @BindView(R.id.tvNgay)
    TextView ngay;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvHanXuLy)
    TextView tvHanXuLy;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;

    @BindView(R.id.btnDeXuat)
    Button btnDeXuat;
    @BindView(R.id.btnTuChoi)
    Button btnTuChoi;
    @BindView(R.id.btnTuChoiVeTP)
    Button btnTuChoiVeTP;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;
    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;

    AdapterFileDinhKem adapterFileDinhKem;
    AdapterTrinhTuXuLy adapterTrinhTuXuLy;
    boolean click = false;
    int id;
    AlertDialog dialog;
    TextView tvNgayThangNam;
    EditText edtThemYKien;
    EditText edtNoiDungTuChoi;
    EditText edtGhiChu;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb__dsvb__qua_han_cua_phong;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_QUAHAN")) {
                id = intent.getIntExtra("ID_VANBAN_QUAHAN", 0);
                getPresenter().getbyidvbquahandolanhdaochidao(id);

            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @Override
    public Context gContext() {
        return this;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onGetDataSuccess(DSVB_QuaHan dsvb_quaHan) {
        if (dsvb_quaHan.getAllowThemhan()) {
            btnDeXuat.setVisibility(View.VISIBLE);
        }
        if (dsvb_quaHan.getAllowTuchoi()) {
            btnTuChoi.setVisibility(View.VISIBLE);
        }
        if (dsvb_quaHan.getAllowTuchoitp()) {
            btnTuChoiVeTP.setVisibility(View.VISIBLE);
        }
        recyclerViewFileDinhKem((ArrayList<String>) dsvb_quaHan.getTaiLieus());
        recyclerTrinhTuXuLy((ArrayList<TrinhTuKy>) dsvb_quaHan.getTrinhTuKys());

        String shortdate = dsvb_quaHan.getNgayNhap();
        ngay.setText(shortdate.substring(0, 5));
        noigui.setText(dsvb_quaHan.getNoiGui());
        tvLoaiVanban.setText(dsvb_quaHan.getLoaiVanban());
        tvTrichYeu.setText(dsvb_quaHan.getTrichYeu());
        skh.setText(String.valueOf(dsvb_quaHan.getSoKyHieu()));
        sodenvang.setText(String.valueOf(dsvb_quaHan.getSoDen()));
        tvHanXuLy.setText(String.valueOf(dsvb_quaHan.getHanXuLy()));
        tvNgayKy.setText(String.valueOf(dsvb_quaHan.getNgayKy()));

    }

    @Override
    public void themHanGiaiQuyetVBQuaHan() {
        Toast.makeText(this, "Đã Thêm", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public void tuChoiHanGiaiQuyetVBQuaHan() {
        Toast.makeText(this, "Đã từ chối", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public void tuChoiTPVBQuaHan() {
        Toast.makeText(this, "Đã từ chối", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
        finish();
    }

    @Override
    public NDVB_DSVB_QuaHanPresenter createPresenter() {
        return new NDVB_DSVB_QuaHanPresenterImpl(this);
    }

    @OnClick({R.id.imvBack, R.id.tvXemChiTiet, R.id.btnDeXuat, R.id.btnTuChoi, R.id.btnTuChoiVeTP})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                    intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", id);
                    startActivity(intent);
                    click = true;
                }
                break;

            case R.id.btnDeXuat:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_themhangiaiquyet, null);
                builderDongYChiDao.setView(viewDongYChiDao);
                dialog = builderDongYChiDao.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tvNgayThangNam = viewDongYChiDao.findViewById(R.id.tvNgayThangNam);
                edtThemYKien = viewDongYChiDao.findViewById(R.id.edtThemYKien);
                Button btnDong = viewDongYChiDao.findViewById(R.id.btnDong);
                Button btnGuiLanhDao = viewDongYChiDao.findViewById(R.id.btnGuiLanhDao);
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
                btnGuiLanhDao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().themHanGiaiQuyetVBQuaHan(id, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
                    }
                });

                dialog.show();
                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoicuaphong, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                edtGhiChu = viewtuchoi.findViewById(R.id.edtGhiChu);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiHanGiaiQuyetVBQuaHan(id, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.btnTuChoiVeTP:
                AlertDialog.Builder buildertuchoi1 = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi1 = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi1 = inflatertuchoi1.inflate(R.layout.dialog_tuchoicuaphong, null);
                buildertuchoi1.setView(viewtuchoi1);
                dialog = buildertuchoi1.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi1.findViewById(R.id.edtNoiDungTuChoi);
                edtGhiChu = viewtuchoi1.findViewById(R.id.edtGhiChu);
                Button btnDong2 = viewtuchoi1.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan1 = viewtuchoi1.findViewById(R.id.btnChuyenChanhVanBan);
                btnChuyenChanhVanBan1.setText("CHUYỂN TRƯỞNG PHÒNG");
                btnDong2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiTPVBQuaHan(id, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                    }
                });
                dialog.show();
                break;
        }
    }


    @Override
    public void onItemClickFileDinhKem(String dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void recyclerViewFileDinhKem(ArrayList<String> strings) {
        adapterFileDinhKem = new AdapterFileDinhKem(this, strings, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKem);
        adapterFileDinhKem.notifyDataSetChanged();
    }

    void recyclerTrinhTuXuLy(ArrayList<TrinhTuKy> trinhTuKyArrayList) {
        adapterTrinhTuXuLy = new AdapterTrinhTuXuLy(this, trinhTuKyArrayList);
        LinearLayoutManager layoutManagerTrinhTuXuLy = new LinearLayoutManager(this);
        layoutManagerTrinhTuXuLy.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuXuLy.setLayoutManager(layoutManagerTrinhTuXuLy);
        rvTrinhTuXuLy.setAdapter(adapterTrinhTuXuLy);
        adapterTrinhTuXuLy.notifyDataSetChanged();
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