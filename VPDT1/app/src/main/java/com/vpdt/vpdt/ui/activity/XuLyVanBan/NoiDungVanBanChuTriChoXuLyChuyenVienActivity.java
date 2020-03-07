package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.VanBanChuTriChoXuLyChuyenVien;
import com.vpdt.vpdt.presenter.NoiDungVanBanChuTriChoXuLyChuyenVienPresenter;
import com.vpdt.vpdt.presenter.NoiDungVanBanChuTriChoXuLyChuyenVienView;
import com.vpdt.vpdt.presenter.impl.NoiDungVanBanChuTriChoXuLyChuyenVienPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoiDungVanBanChuTriChoXuLyChuyenVienActivity extends BaseActivity<NoiDungVanBanChuTriChoXuLyChuyenVienPresenter> implements
        NoiDungVanBanChuTriChoXuLyChuyenVienView, DatePickerDialog.OnDateSetListener {

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
    @BindView(R.id.tvVanBanDauRa)
    TextView tvVanBanDauRa;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;

    @BindView(R.id.rcvTTXL)
    RecyclerView rcvTTXL;

    @BindView(R.id.btnDeXuatThemHanGiaiQuyet)
    Button btnDeXuatThemHanGiaiQuyet;
    int id;
    String filedinhkem;
    EditText edtNoiDungTuChoi;
    int idCanBoChuyen;

    AlertDialog dialog;
    TextView tvNgayThangNam;
    EditText edtThemYKien;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_van_ban_chu_tri_cho_xu_ly_chuyen_vien;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanChuTriChoXuLyChuyenVien vanBanChuTriChoXuLyChuyenVien = getIntent().getParcelableExtra("vanBanChuTriChoXuLyChuyenVien");
        if (vanBanChuTriChoXuLyChuyenVien != null) {
            if (vanBanChuTriChoXuLyChuyenVien.getVBDauRaTP() == 1) {
                tvVanBanDauRa.setVisibility(View.VISIBLE);
            }
            if (vanBanChuTriChoXuLyChuyenVien.getAllowThemHan()) {
                btnDeXuatThemHanGiaiQuyet.setVisibility(View.VISIBLE);
            }

            if (vanBanChuTriChoXuLyChuyenVien.getISTCChuTri() == 1) {
                tvLoaiVanban.setText("STC chủ trì");
            }
            if (vanBanChuTriChoXuLyChuyenVien.getIVanBanTBKL() == 1) {
                tvLoaiVanban.setText("Thông báo kết luận");
            }
            if (vanBanChuTriChoXuLyChuyenVien.getIToCongTac() == 1) {
                tvLoaiVanban.setText("Tổ công tác");
            }
            if (vanBanChuTriChoXuLyChuyenVien.getISTCPhoiHop() == 1) {
                tvLoaiVanban.setText("STC phối hợp");
            }
            if (vanBanChuTriChoXuLyChuyenVien.getIVanBanQPPL() == 1) {
                tvLoaiVanban.setText("VB QPPL");
            }
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanChuTriChoXuLyChuyenVien.getTrinhTuXuLy());

            id = vanBanChuTriChoXuLyChuyenVien.getId();
            idCanBoChuyen = vanBanChuTriChoXuLyChuyenVien.getIdCanBoChuyen();
            filedinhkem = vanBanChuTriChoXuLyChuyenVien.getUrlFile();
            tvNgay.setText(String.valueOf(vanBanChuTriChoXuLyChuyenVien.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanChuTriChoXuLyChuyenVien.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanChuTriChoXuLyChuyenVien.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanChuTriChoXuLyChuyenVien.getNoiGui()));
            tvVanBanDauRa.setText(String.valueOf(vanBanChuTriChoXuLyChuyenVien.getVBDauRaTPText()));
            tvTrichYeu.setText(vanBanChuTriChoXuLyChuyenVien.getMoTa() + "." + vanBanChuTriChoXuLyChuyenVien.getNoiDung());
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.btnDeXuatThemHanGiaiQuyet, R.id.lnNoiDungVB, R.id.btnTuChoi, R.id.tvFileDinhKem, R.id.tvXemChiTietNDVBDSVBDenChoLDXL})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanChuTriChoXuLyActivity.class);
                    intent.putExtra("idvBChuTriChoXuLy", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnChuyenChanhVanBan.setText("Gửi lãnh đạo");
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiVBChuTriChoXuLyCV(id, edtNoiDungTuChoi.getText().toString(), idCanBoChuyen);
                    }
                });
                dialog.show();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.tvFileDinhKem:
                try {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filedinhkem));
                    startActivity(browserIntent);
                } catch (Exception e) {
                    Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnDeXuatThemHanGiaiQuyet:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_dexuatgiahan, null);
                builderDongYChiDao.setView(viewDongYChiDao);
                builderDongYChiDao.setCancelable(false);
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
                        getPresenter().themHanVBChuTriChoXuLy(id, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
                    }
                });

                dialog.show();
                break;
        }
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

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void tuChoiVBChuTriChoXuLyCVSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void themHanVBChuTriChoXuLySuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NoiDungVanBanChuTriChoXuLyChuyenVienPresenter createPresenter() {
        return new NoiDungVanBanChuTriChoXuLyChuyenVienPresenterImpl(this);
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTXL.setLayoutManager(linearLayoutManager);
        rcvTTXL.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }
}
