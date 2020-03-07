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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.VanBanDaDeXuatGiaHanGiaiQuyet;
import com.vpdt.vpdt.presenter.NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVBDaDeXuatGiaHanGiaiQuyetView;
import com.vpdt.vpdt.presenter.impl.NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import org.sufficientlysecure.htmltextview.HtmlAssetsImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity extends BaseActivity<NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenter> implements NDVB_DSVBDaDeXuatGiaHanGiaiQuyetView,
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
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvHanDeXuat)
    TextView tvHanDeXuat;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvLyDoTuChoiHan)
    HtmlTextView tvLyDoTuChoiHan;
    @BindView(R.id.tvTenLanhDao)
    TextView tvTenLanhDao;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;

    @BindView(R.id.btnDeXuatThemHanGiaiQuyet)
    Button btnDeXuatThemHanGiaiQuyet;

    @BindView(R.id.rcvTTXL)
    RecyclerView rcvTTXL;

    @BindView(R.id.rlGiaHanThanhCong)
    RelativeLayout rlGiaHanThanhCong;
    @BindView(R.id.rlDangChoLanhDaoDuyet)
    RelativeLayout rlDangChoLanhDaoDuyet;
    @BindView(R.id.rlBiTuChoiGiaHan)
    RelativeLayout rlBiTuChoiGiaHan;
    boolean click = false;
    AlertDialog dialog;
    TextView tvNgayThangNam;
    EditText edtThemYKien;
    int idvb;

    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb__dsvbda_de_xuat_gia_han_giai_quyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanDaDeXuatGiaHanGiaiQuyet vanBanDaDeXuatGiaHanGiaiQuyet = getIntent().getParcelableExtra("vanBanDaDeXuatGiaHanGiaiQuyet");
        if (vanBanDaDeXuatGiaHanGiaiQuyet != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanDaDeXuatGiaHanGiaiQuyet.getTrinhTuXuLy());
            idvb = vanBanDaDeXuatGiaHanGiaiQuyet.getId();
            if (!vanBanDaDeXuatGiaHanGiaiQuyet.getGiayMoiGio().isEmpty() && !vanBanDaDeXuatGiaHanGiaiQuyet.getGiayMoiNgay().isEmpty() && !vanBanDaDeXuatGiaHanGiaiQuyet.getGiayMoiDiaDiem().isEmpty()) {
                tvNgayGio.setText("( Vào hồi " + vanBanDaDeXuatGiaHanGiaiQuyet.getGiayMoiGio() + " ngày " + vanBanDaDeXuatGiaHanGiaiQuyet.getGiayMoiNgay() + ", tại" + vanBanDaDeXuatGiaHanGiaiQuyet.getGiayMoiDiaDiem() + ")");
            }
            tvNgay.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getNgayNhap()));
            tvSKH.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getMoTa()));
            tvHanGiaiQuyet.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getHanGiaiQuyet()));
            tvHanDeXuat.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getHanDeXuat()));
            tvLyDoTuChoiHan.setHtml(vanBanDaDeXuatGiaHanGiaiQuyet.getLyDoTuChoiHan(), new HtmlAssetsImageGetter(tvLyDoTuChoiHan));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDaDeXuatGiaHanGiaiQuyet.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            if (vanBanDaDeXuatGiaHanGiaiQuyet.getDeXuatThemHanGiaiQuyet()) {
                btnDeXuatThemHanGiaiQuyet.setVisibility(View.VISIBLE);
            }
            if (vanBanDaDeXuatGiaHanGiaiQuyet.getTrangThaiThemHan() == 1) {
                rlDangChoLanhDaoDuyet.setVisibility(View.VISIBLE);
                tvTenLanhDao.setText(String.valueOf(vanBanDaDeXuatGiaHanGiaiQuyet.getTenLanhDao()));
            }

            if (vanBanDaDeXuatGiaHanGiaiQuyet.getTrangThaiThemHan() == 2) {
                rlGiaHanThanhCong.setVisibility(View.VISIBLE);
            }

            if (vanBanDaDeXuatGiaHanGiaiQuyet.getTrangThaiThemHan() == 3) {
                rlBiTuChoiGiaHan.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack,
            R.id.tvXemChiTietNDVBDSVBDenChoLDXL, R.id.btnDeXuatThemHanGiaiQuyet, R.id.lnNoiDungVB})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnBack:
                finish();
                break;

            case R.id.lnNoiDungVB:
                closeKeyboard();
                break;

            case R.id.tvXemChiTietNDVBDSVBDenChoLDXL:
                if (!click) {
                    Intent intent = new Intent(this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                    intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", idvb);
                    startActivity(intent);
                    click = true;
                }
                break;

            case R.id.btnDeXuatThemHanGiaiQuyet:
                AlertDialog.Builder builderDongYChiDao = new AlertDialog.Builder(this);
                LayoutInflater inflaterDongYChiDao = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewDongYChiDao = inflaterDongYChiDao.inflate(R.layout.dialog_dexuatgiahan, null);
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
                        getPresenter().themHanVBDaDeXuatGiaHanGiaQuyet(idvb, tvNgayThangNam.getText().toString(), edtThemYKien.getText().toString());
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
    public void themHanVBDaDeXuatGiaHanGiaQuyet() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenter createPresenter() {
        return new NDVB_DSVBDaDeXuatGiaHanGiaiQuyetPresenterImpl(this);
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
