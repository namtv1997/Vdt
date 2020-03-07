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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongChuTri;
import com.vpdt.vpdt.presenter.NDVBSoLuongVanBanGiaoPhongChuTriPresenter;
import com.vpdt.vpdt.presenter.NDVBSoLuongVanBanGiaoPhongChuTriView;
import com.vpdt.vpdt.presenter.impl.NDVBSoLuongVanBanGiaoPhongChuTriPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBSoLuongVanBanGiaoPhongChuTriActivity extends BaseActivity<NDVBSoLuongVanBanGiaoPhongChuTriPresenter> implements NDVBSoLuongVanBanGiaoPhongChuTriView,
        DatePickerDialog.OnDateSetListener {
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
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvXemChiTietNDVBDSVBDenChoLDXL)
    TextView tvXemChiTietNDVBDSVBDenChoLDXL;

    @BindView(R.id.btnTuChoi)
    TextView btnTuChoi;
    @BindView(R.id.btnDeXuatThemHanGiaiQuyet)
    TextView btnDeXuatThemHanGiaiQuyet;

    @BindView(R.id.rcvTTXL)
    RecyclerView rcvTTXL;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    EditText edtNoiDungTuChoi;
    EditText edtGhiChu;
    boolean click = false;

    AlertDialog dialog;
    TextView tvNgayThangNam;
    EditText edtThemYKien;
    int idvb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbso_luong_van_ban_giao_phong_chu_tri;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        SoLuongVanBanGiaoPhongChuTri soLuongVanBanGiaoPhongChuTri = getIntent().getParcelableExtra("soLuongVanBanGiaoPhongChuTri");
        if (soLuongVanBanGiaoPhongChuTri != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) soLuongVanBanGiaoPhongChuTri.getTrinhTuXuLy());
            idvb = soLuongVanBanGiaoPhongChuTri.getId();
            tvNgay.setText(String.valueOf(soLuongVanBanGiaoPhongChuTri.getNgayNhap()));
            tvSKH.setText(String.valueOf(soLuongVanBanGiaoPhongChuTri.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(soLuongVanBanGiaoPhongChuTri.getSoDen()));
            tvNoigui.setText(String.valueOf(soLuongVanBanGiaoPhongChuTri.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(soLuongVanBanGiaoPhongChuTri.getMoTa()));
            if (!soLuongVanBanGiaoPhongChuTri.getGiayMoiGio().isEmpty() && !soLuongVanBanGiaoPhongChuTri.getGiayMoiNgay().isEmpty() && !soLuongVanBanGiaoPhongChuTri.getGiayMoiDiaDiem().isEmpty()) {
                tvNgayGio.setText("( Vào hồi " + soLuongVanBanGiaoPhongChuTri.getGiayMoiGio() + " ngày " + soLuongVanBanGiaoPhongChuTri.getGiayMoiNgay() + ", tại" + soLuongVanBanGiaoPhongChuTri.getGiayMoiDiaDiem() + ")");

                tvXemChiTietNDVBDSVBDenChoLDXL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!click) {
                            Intent intent = new Intent(NDVBSoLuongVanBanGiaoPhongChuTriActivity.this, TTVBSoLuongVanBanGiaoPhongChuTriActivity.class);
                            intent.putExtra("idvb", idvb);
                            startActivity(intent);
                            click = true;
                        }

                    }
                });
            } else {
                tvXemChiTietNDVBDSVBDenChoLDXL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!click) {
                            Intent intent = new Intent(NDVBSoLuongVanBanGiaoPhongChuTriActivity.this, TTVBSoLuongVanBanGiaoPhongChuTri1Activity.class);
                            intent.putExtra("idvb", idvb);
                            startActivity(intent);
                            click = true;
                        }

                    }
                });
            }
            tvNgayKy.setText(String.valueOf("Ngày ký: " + soLuongVanBanGiaoPhongChuTri.getNgayKy()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(soLuongVanBanGiaoPhongChuTri.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBSoLuongVanBanGiaoPhongChuTriActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            if (soLuongVanBanGiaoPhongChuTri.getDeXuatThemHanGiaiQuyet()) {
                btnDeXuatThemHanGiaiQuyet.setVisibility(View.VISIBLE);
            }
            if (soLuongVanBanGiaoPhongChuTri.getTypeTuChoi() == 0) {
                btnTuChoi.setVisibility(View.GONE);
            }
            btnTuChoi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(NDVBSoLuongVanBanGiaoPhongChuTriActivity.this);
                    LayoutInflater inflatertuchoi = (LayoutInflater) NDVBSoLuongVanBanGiaoPhongChuTriActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoicuaphong, null);
                    buildertuchoi.setView(viewtuchoi);
                    buildertuchoi.setCancelable(false);
                    dialog = buildertuchoi.create();
                    dialog.show();

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
                            if (soLuongVanBanGiaoPhongChuTri.getTypeTuChoi() == 1) {
                                if (edtNoiDungTuChoi.getText().toString().isEmpty()) {
                                    Toast.makeText(NDVBSoLuongVanBanGiaoPhongChuTriActivity.this, "Chưa nhập nội dung từ chối", Toast.LENGTH_SHORT).show();
                                } else {
                                    getPresenter().tuChoiVBGiaoPhongChuTri(idvb, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                                }
                            } else if (soLuongVanBanGiaoPhongChuTri.getTypeTuChoi() == 2) {
                                if (edtNoiDungTuChoi.getText().toString().isEmpty()) {
                                    Toast.makeText(NDVBSoLuongVanBanGiaoPhongChuTriActivity.this, "Chưa nhập nội dung từ chối", Toast.LENGTH_SHORT).show();
                                } else {
                                    getPresenter().tuChoiVBGiaoPhongChuTriTruongPhong(idvb, edtNoiDungTuChoi.getText().toString(), edtGhiChu.getText().toString());
                                }
                            }
                        }
                });
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.btnDeXuatThemHanGiaiQuyet, R.id.lnNoiDungVB})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
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
                        getPresenter().themHanVBPhongChuTriChoXuLy(idvb, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
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
    public Context gContext() {
        return this;
    }

    @Override
    public void tuChoiVBGiaoPhongChuTriSuccess() {
        dialog.dismiss();
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void tuChoiVBGiaoPhongChuTriTruongPhongSuccess() {
        dialog.dismiss();
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void themHanVBPhongChuTriChoXuLy() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBSoLuongVanBanGiaoPhongChuTriPresenter createPresenter() {
        return new NDVBSoLuongVanBanGiaoPhongChuTriPresenterImpl(this);
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
