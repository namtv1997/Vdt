package com.vpdt.vpdt.ui.activity.VanBanDiDonViCapHai;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DanhSachVanBanDi;
import com.vpdt.vpdt.model.VanBanTongTheDonViCapHai;
import com.vpdt.vpdt.presenter.NDVBDanhSachVanBanDiPresenter;
import com.vpdt.vpdt.presenter.NDVBDanhSachVanBanDiView;
import com.vpdt.vpdt.presenter.impl.NDVBDanhSachVanBanDiPresenterImpl;
import com.vpdt.vpdt.ui.activity.VanBanDonViCapHai.NDVBDanhSachVanBanTongTheActivity;
import com.vpdt.vpdt.ui.activity.VanBanDonViCapHai.TTVBDetailVanBanChoXuLyGQActivity;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDanhSachVanBanDiActivity extends BaseActivity<NDVBDanhSachVanBanDiPresenter> implements NDVBDanhSachVanBanDiView,
        DatePickerDialog.OnDateSetListener {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDi)
    TextView tvSoDi;
    @BindView(R.id.tvNoiNhan)
    TextView tvNoiNhan;
    @BindView(R.id.tvSoKyHieu)
    TextView tvSoKyHieu;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvXemFileDinhKem)
    TextView tvXemFileDinhKem;
    @BindView(R.id.tvVBTL)
    TextView tvVBTL;
    @BindView(R.id.tvNgayThangNam)
    TextView tvNgayThangNam;

    @BindView(R.id.btnXoa)
    Button btnXoa;
    @BindView(R.id.btnDuyet)
    Button btnDuyet;

    int id;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdanh_sach_van_ban_di;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DanhSachVanBanDi detailVanBanDiTongThe = getIntent().getParcelableExtra("danhSachVanBanDi");
        if (detailVanBanDiTongThe != null) {
            id = detailVanBanDiTongThe.getId();
            String shortDate = detailVanBanDiTongThe.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoDi.setText(String.valueOf(detailVanBanDiTongThe.getSoVBDi()));
            tvNoiNhan.setText(String.valueOf(detailVanBanDiTongThe.getNoiNhan()));
            tvSoKyHieu.setText(String.valueOf(detailVanBanDiTongThe.getSoKyHieu()));
            tvSoDen.setText(String.valueOf("Trả lời cho văn bản đến số: " + detailVanBanDiTongThe.getSoDen()));
            if (detailVanBanDiTongThe.getLoaiVanBan() == null || detailVanBanDiTongThe.getLoaiVanBan().isEmpty()) {
                tvLoaiVanban.setVisibility(View.GONE);
                tvVBTL.setVisibility(View.GONE);
            } else {
                tvLoaiVanban.setText(String.valueOf(detailVanBanDiTongThe.getLoaiVanBan()));
            }
            tvTrichYeu.setText(String.valueOf(detailVanBanDiTongThe.getMoTa()));
            if (detailVanBanDiTongThe.getNguoiKy() == null || detailVanBanDiTongThe.getNguoiKy().isEmpty()) {
                tvNguoiKy.setVisibility(View.GONE);
            } else {
                tvNguoiKy.setText(String.valueOf("Người ký: " + detailVanBanDiTongThe.getNguoiKy()));
            }
            if (detailVanBanDiTongThe.getNgayVanBanDi() != null) {
                if (!detailVanBanDiTongThe.getNgayVanBanDi().isEmpty())
                    tvNgayThangNam.setText(String.valueOf(detailVanBanDiTongThe.getNgayVanBanDi()));
            }
            tvXemFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(detailVanBanDiTongThe.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDanhSachVanBanDiActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            if (detailVanBanDiTongThe.getAllowDelete()) {
                btnXoa.setVisibility(View.VISIBLE);
            } else {
                btnXoa.setVisibility(View.GONE);
            }
            if (detailVanBanDiTongThe.getAllowDuyet()) {
                btnDuyet.setVisibility(View.VISIBLE);
                tvNgayThangNam.setEnabled(true);
            } else {
                btnDuyet.setVisibility(View.GONE);
                tvNgayThangNam.setEnabled(false);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack, R.id.btnXoa, R.id.btnDuyet, R.id.tvNgayThangNam})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDetailVanBanChoXuLyGQActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnXoa:
                getPresenter().deleteVBDiDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id);
                break;
            case R.id.btnDuyet:
                getPresenter().duyetVBDiDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id, tvNgayThangNam.getText().toString());
                break;
            case R.id.tvNgayThangNam:
                showDatePickerDialog();
                break;
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDuyetSuccess() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onGetXoaSuccess() {
        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public NDVBDanhSachVanBanDiPresenter createPresenter() {
        return new NDVBDanhSachVanBanDiPresenterImpl(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
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

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
