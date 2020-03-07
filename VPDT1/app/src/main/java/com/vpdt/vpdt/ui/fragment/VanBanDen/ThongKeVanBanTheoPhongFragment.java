package com.vpdt.vpdt.ui.fragment.VanBanDen;


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
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.ThongKeTheoPhong;
import com.vpdt.vpdt.presenter.ThongKeVanBanTheoPhongPresenter;
import com.vpdt.vpdt.presenter.ThongKeVanBanTheoPhongView;
import com.vpdt.vpdt.presenter.impl.ThongKeVanBanTheoPhongPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.BaoCaoDauCongViecCaNhanActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterThongKeVanBanTheoPhong;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThongKeVanBanTheoPhongFragment extends BaseFragment<ThongKeVanBanTheoPhongPresenter> implements ThongKeVanBanTheoPhongView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec, AdapterThongKeVanBanTheoPhong.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecDSVBTheoPhong)
    Button btnNamLamViecDSVBTheoPhong;
    @BindView(R.id.btnBackDSVBTheoPhong)
    Button btnBackDSVBTheoPhong;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvDenNgay)
    TextView tvDenNgay;
    String NamLamViec;
    boolean click = false;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;

    private AdapterThongKeVanBanTheoPhong adapterThongKeVanBanTheoPhong;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_thongketheophong;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViecDSVBTheoPhong.setText("Năm làm việc: " + NamLamViec + " ");

        getPresenter().getThongKeTheoPhong(NamLamViec, String.valueOf(0), tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDaDaSuccess(ArrayList<ThongKeTheoPhong> thongKeTheoPhongArrayList) {
        adapterThongKeVanBanTheoPhong = new AdapterThongKeVanBanTheoPhong(thongKeTheoPhongArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterThongKeVanBanTheoPhong);
        recyclerview.setNestedScrollingEnabled(false);
        adapterThongKeVanBanTheoPhong.notifyDataSetChanged();
    }

    @OnClick({R.id.btnNamLamViecDSVBTheoPhong, R.id.btnBackDSVBTheoPhong, R.id.tvNgayNhap, R.id.tvDenNgay, R.id.btnSearch,
            R.id.vDSVBTheoPhong, R.id.lntp, R.id.rltp, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecDSVBTheoPhong:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectNam = view1.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();

                break;
            case R.id.btnBackDSVBTheoPhong:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;

            case R.id.tvNgayNhap:
                final Calendar c1 = Calendar.getInstance();
                mYear = c1.get(Calendar.YEAR);
                mMonth = c1.get(Calendar.MONTH);
                mDay = c1.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getActivity(),
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
                                PrefUtil.saveString(getActivity(), Key.TU_NGAY, date);
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
                datePickerDialog = new DatePickerDialog(getActivity(),
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

                                PrefUtil.saveString(getActivity(), Key.DEN_NGAY, date);
                                tvDenNgay.setText(date);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.btnSearch:
                getPresenter().getThongKeTheoPhong(NamLamViec, String.valueOf(0), tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
                break;

        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecDSVBTheoPhong.setText("Năm làm việc: " + integer + " ");
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        getPresenter().getThongKeTheoPhong(String.valueOf(integer), String.valueOf(0), tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public ThongKeVanBanTheoPhongPresenter createPresenter() {
        return new ThongKeVanBanTheoPhongPresenterImpl(this);
    }

    @Override
    public void onItemClick(ThongKeTheoPhong thongKeTheoPhong) {
        if (!click) {
            Intent intent = new Intent(getActivity(), BaoCaoDauCongViecCaNhanActivity.class);
            intent.putExtra("idphong", thongKeTheoPhong.getId());
            startActivity(intent);
            click = true;
        }
    }
}

