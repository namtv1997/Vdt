package com.vpdt.vpdt.ui.activity.VanBanDen;

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
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.ThongKeTheoPhong;
import com.vpdt.vpdt.presenter.BaoCaoDauCongViecCaNhanPresenter;
import com.vpdt.vpdt.presenter.BaoCaoDauCongViecCaNhanView;
import com.vpdt.vpdt.presenter.impl.BaoCaoDauCongViecCaNhanPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterThongKeVanBanTheoCanBo;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaoCaoDauCongViecCaNhanActivity extends BaseActivity<BaoCaoDauCongViecCaNhanPresenter> implements BaoCaoDauCongViecCaNhanView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec, AdapterThongKeVanBanTheoCanBo.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.tvTieuDe)
    TextView tvTieuDe;
    @BindView(R.id.btnNamLamViecDSVBTheoPhong)
    Button btnNamLamViecDSVBTheoPhong;
    @BindView(R.id.btnBackDSVBTheoPhong)
    Button btnBackDSVBTheoPhong;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvDenNgay)
    TextView tvDenNgay;
    String NamLamViec, tuNgay, denNgay;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year, idphong;
    String check = "";

    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;

    private AdapterThongKeVanBanTheoCanBo adapterThongKeVanBanTheoCanBo;

    @Override
    public int getContentViewId() {
        return R.layout.activity_bao_cao_dau_cong_viec_ca_nhan;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("THONG_KE_VB_THEO_PHONG")) {
                check = intent.getStringExtra("THONG_KE_VB_THEO_PHONG");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (check.equals("THONG_KE_VB_THEO_PHONG")) {
            tvTieuDe.setText("VĂN BẢN ĐẾN");
        }
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("idphong")) {
                idphong = intent.getIntExtra("idphong", 0);
            }
        }

        NamLamViec = PrefUtil.getString(this, Key.NAM_LAM_VIEC, "");
        tuNgay = PrefUtil.getString(this, Key.TU_NGAY, "");
        denNgay = PrefUtil.getString(this, Key.DEN_NGAY, "");
        tvNgayNhap.setText(String.valueOf(tuNgay));
        tvDenNgay.setText(String.valueOf(denNgay));
        btnNamLamViecDSVBTheoPhong.setText("Năm làm việc: " + NamLamViec + " ");
        getPresenter().getThongKeTheoPhongDetail(NamLamViec, idphong, String.valueOf(0), tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(this, integerArrayList, this);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @OnClick({R.id.btnNamLamViecDSVBTheoPhong, R.id.btnBackDSVBTheoPhong, R.id.tvNgayNhap, R.id.tvDenNgay, R.id.btnSearch,
            R.id.vDSVBTheoPhong, R.id.lntp, R.id.rltp, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(this));
                Objects.requireNonNull(this).onBackPressed();
                break;
            case R.id.btnNamLamViecDSVBTheoPhong:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectNam = view1.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();

                break;
            case R.id.btnBackDSVBTheoPhong:
                if (check.equals("THONG_KE_VB_THEO_PHONG")) {
                    startActivity(MainActivity.getCallingIntent(this));
                    Objects.requireNonNull(this).onBackPressed();
                } else {
                    finish();
                }
                break;

            case R.id.tvNgayNhap:
                final Calendar c1 = Calendar.getInstance();
                mYear = c1.get(Calendar.YEAR);
                mMonth = c1.get(Calendar.MONTH);
                mDay = c1.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

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
                                tvNgayNhap.setText(date);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

                break;

            case R.id.tvDenNgay:
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
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


                                tvDenNgay.setText(date);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.btnSearch:
                getPresenter().getThongKeTheoPhongDetail(NamLamViec, idphong, String.valueOf(0), tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
                break;

        }
    }

    @Override
    public void onGetDaDaSuccess(ArrayList<ThongKeTheoPhong> thongKeTheoPhongArrayList) {
        adapterThongKeVanBanTheoCanBo = new AdapterThongKeVanBanTheoCanBo(thongKeTheoPhongArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterThongKeVanBanTheoCanBo);
        adapterThongKeVanBanTheoCanBo.notifyDataSetChanged();
    }

    @Override
    public BaoCaoDauCongViecCaNhanPresenter createPresenter() {
        return new BaoCaoDauCongViecCaNhanPresenterImpl(this);
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecDSVBTheoPhong.setText("Năm làm việc: " + integer + " ");
        PrefUtil.saveString(this, Key.NAM_LAM_VIEC, String.valueOf(integer));
        getPresenter().getThongKeTheoPhongDetail(String.valueOf(integer)
                , idphong, String.valueOf(0), tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onSoViecDuocGiaoClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("SoViecDuocGiao", thongKeTheoPhong.getId());
        intent.putExtra("SoViecDuocGiaoTong", thongKeTheoPhong.getTongSV());
        startActivity(intent);
    }

    @Override
    public void onTongSoViecDaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("TongSoViecDaGiaiQuyet", thongKeTheoPhong.getId());
        intent.putExtra("TongSoViecDaGiaiQuyetTong", thongKeTheoPhong.getCgqTong());
        startActivity(intent);
    }

    @Override
    public void onDungHanDaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("DungHanDaGiaiQuyet", thongKeTheoPhong.getId());
        intent.putExtra("DungHanDaGiaiQuyet1", thongKeTheoPhong.getDgqDunghan());
        startActivity(intent);
    }

    @Override
    public void onQuaHanDaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("QuaHanDaGiaiQuyet", thongKeTheoPhong.getId());
        intent.putExtra("QuaHanDaGiaiQuyet1", thongKeTheoPhong.getDgqQuahan());
        startActivity(intent);
    }

    @Override
    public void onCoSangTaoClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("CoSangTao", thongKeTheoPhong.getId());
        intent.putExtra("CoSangTao1", thongKeTheoPhong.getDgqSangtao());
        startActivity(intent);
    }

    @Override
    public void onTongSoViecChuaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("TongSoViecChuaGiaiQuyet", thongKeTheoPhong.getId());
        intent.putExtra("TongSoViecChuaGiaiQuyet1", thongKeTheoPhong.getCgqTong());
        startActivity(intent);
    }

    @Override
    public void onDungHanChuaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("DungHanChuaGiaiQuyet", thongKeTheoPhong.getId());
        intent.putExtra("DungHanChuaGiaiQuyet1", thongKeTheoPhong.getCgqTronghan());
        startActivity(intent);
    }

    @Override
    public void onQuaHanChuaGiaiQuyetClick(ThongKeTheoPhong thongKeTheoPhong) {
        Intent intent = new Intent(this, ThongKeVanBanActivity.class);
        intent.putExtra("QuaHanChuaGiaiQuyet", thongKeTheoPhong.getId());
        intent.putExtra("QuaHanChuaGiaiQuyet", thongKeTheoPhong.getCgqQuahan());
        startActivity(intent);
    }
}
