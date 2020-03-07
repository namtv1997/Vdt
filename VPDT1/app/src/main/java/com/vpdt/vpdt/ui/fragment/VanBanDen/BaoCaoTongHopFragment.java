package com.vpdt.vpdt.ui.fragment.VanBanDen;


import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.BaoCaoTongHop;
import com.vpdt.vpdt.model.PhongBaoCaoTongHop;
import com.vpdt.vpdt.presenter.BaoCaoTongHopPresenter;
import com.vpdt.vpdt.presenter.BaoCaoTongHopView;
import com.vpdt.vpdt.presenter.impl.BaoCaoTongHopPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterBaoCaoTongHop1;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhongBaoCaoTongHop;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BaoCaoTongHopFragment extends BaseFragment<BaoCaoTongHopPresenter> implements BaoCaoTongHopView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec, AdapterTenPhongBaoCaoTongHop.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.tvChonPhongBan)
    TextView tvChonPhongBan;
    @BindView(R.id.tvTuNgay)
    TextView tvTuNgay;
    @BindView(R.id.tvDenNgay)
    TextView tvDenNgay;

    @BindView(R.id.cbVanBanThongThuong)
    CheckBox cbVanBanThongThuong;
    @BindView(R.id.cbVanBanSTCChuTri)
    CheckBox cbVanBanSTCChuTri;
    int level;

    RecyclerView rcTenPhong;
    RecyclerView rvSelectNam;

    AdapterBaoCaoTongHop1 adapterBaoCaoTongHop1;
    AdapterTenPhongBaoCaoTongHop adapterTenPhongBaoCaoTongHop;
    AdapterNamLamViec adapterNamLamViec;

    ArrayList<Integer> integerArrayList = new ArrayList<>();
    String NamLamViec;
    int year;
    int idphong = 0;
    int vbtt = 0;
    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    AlertDialog dialog3;
    AlertDialog dialog;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_bao_cao_tong_hop;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
//        getPresenter().thongke(NamLamViec, tvNgayNhap.getText().toString(), tvDenNgay.getText().toString());
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        level = PrefUtil.getInt(getContext(), Key.LEVEL, 0);
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getphongBcaoTongHop();
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
    public void onGetDaDaSuccess(ArrayList<BaoCaoTongHop> baoCaoTongHopArrayList) {
        adapterBaoCaoTongHop1 = new AdapterBaoCaoTongHop1(getContext(), baoCaoTongHopArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterBaoCaoTongHop1);
        adapterBaoCaoTongHop1.notifyDataSetChanged();
    }

    @Override
    public void onGetPhongBaoCaoTongHopSuccess(ArrayList<PhongBaoCaoTongHop> phongBaoCaoTongHops) {
        adapterTenPhongBaoCaoTongHop = new AdapterTenPhongBaoCaoTongHop(phongBaoCaoTongHops, this);
    }


    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.vDSVBTheoPhong, R.id.tvTuNgay, R.id.tvDenNgay,
            R.id.tvChonPhongBan, R.id.btnSearch, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViec:
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
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.tvChonPhongBan:
                builder = new AlertDialog.Builder(getContext());
                LayoutInflater inflaterphong = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewphong = inflaterphong.inflate(R.layout.dialog_chon_phong, null);
                builder.setView(viewphong);
                dialog3 = builder.create();
                Objects.requireNonNull(dialog3.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerphong = new LinearLayoutManager(getContext());
                layoutManagerphong.setOrientation(LinearLayoutManager.VERTICAL);
                rcTenPhong = viewphong.findViewById(R.id.rcTenPhong);
                rcTenPhong.setLayoutManager(layoutManagerphong);
                rcTenPhong.setAdapter(adapterTenPhongBaoCaoTongHop);
                adapterTenPhongBaoCaoTongHop.notifyDataSetChanged();
                TextView tvChonPhong = viewphong.findViewById(R.id.tvChonPhong);
                tvChonPhong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        idphong = 0;
                        tvChonPhongBan.setText("");
                        dialog3.dismiss();
                    }
                });
                dialog3.show();
                break;
            case R.id.tvTuNgay:
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
                                tvTuNgay.setText(date);

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
                                tvDenNgay.setText(date);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.btnSearch:
                if (cbVanBanThongThuong.isChecked()) {
                    vbtt = 1;
                }
                if (cbVanBanSTCChuTri.isChecked()) {
                    vbtt = 2;
                    if (cbVanBanThongThuong.isChecked()) {
                        vbtt = 0;
                    }
                }

                String ngaybd = (String) tvTuNgay.getText();
                String ngaykt = (String) tvDenNgay.getText();

                if (level == 4 || level == 5) {
                    if (tvTuNgay.getText().toString().isEmpty() || tvDenNgay.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Chưa chọn ngày", Toast.LENGTH_SHORT).show();
                    } else
                        getPresenter().getBaoCaoTongHop(NamLamViec, ngaybd, ngaykt, idphong, vbtt);
                } else {
                    if (tvTuNgay.getText().toString().isEmpty() || tvDenNgay.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Chưa chọn ngày", Toast.LENGTH_SHORT).show();
                    } else if (idphong == 0) {
                        Toast.makeText(getContext(), "Chưa chọn phòng", Toast.LENGTH_SHORT).show();
                    } else {
                        getPresenter().getBaoCaoTongHop(NamLamViec, ngaybd, ngaykt, idphong, vbtt);
                    }
                }

                break;

        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClick(PhongBaoCaoTongHop phongBaoCaoTongHop) {
        tvChonPhongBan.setText(String.valueOf(phongBaoCaoTongHop.getTenpb()));
        getPresenter().getphongBcaoTongHop();
        idphong = phongBaoCaoTongHop.getMapb();
        dialog3.dismiss();
    }

    @Override
    public BaoCaoTongHopPresenter createPresenter() {
        return new BaoCaoTongHopPresenterImpl(this);
    }
}

