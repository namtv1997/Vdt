package com.vpdt.vpdt.ui.fragment.VanBanDen;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.InSoLuuTruVanBanDen;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDenPresenter;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDenView;
import com.vpdt.vpdt.presenter.impl.InSoLuuTruVanBanDenPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.ChiTietInSoLuuTruVanBanDenActivity;
import com.vpdt.vpdt.ui.adapter.AdapterInSoLuuTruVanbanDen;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InSoLuuTruVanBanDenFragment extends BaseFragment<InSoLuuTruVanBanDenPresenter> implements InSoLuuTruVanBanDenView,
        AdapterInSoLuuTruVanbanDen.OnItemClickListenerSoLuuTru {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao)
    Button btnNamLamViec;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;


    @BindView(R.id.tvNgayNhapTu)
    TextView tvNgayNhapTu;
    @BindView(R.id.tvNgayNhapDen)
    TextView tvNgayNhapDen;

    @BindView(R.id.edtSoDenTu)
    EditText edtSoDenTu;
    @BindView(R.id.edtSoDenDen)
    EditText edtSoDenDen;

    String NamLamViec;
    RecyclerView rvSelectNam;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    private EndlessRecyclerViewScrollListener scrollListener;
    AdapterInSoLuuTruVanbanDen adapterInSoLuuTruVanbanDen;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_in_so_luu_tru_van_ban_den;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).checkFragment(this);
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        getPresenter().getInSoLuuTru_den(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), true);

        adapterInSoLuuTruVanbanDen = new AdapterInSoLuuTruVanbanDen(getPresenter().inSoLuuTruVanBanDenArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterInSoLuuTruVanbanDen);

        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (edtSoDenTu.getText().toString().isEmpty() && edtSoDenDen.getText().toString().isEmpty()) {
                    getPresenter().getInSoLuuTru_den(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), true);
                } else if (edtSoDenTu.getText().toString().isEmpty()) {
                    getPresenter().getInSoLuuTru_den(NamLamViec, String.valueOf(0), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), true);
                } else if (edtSoDenDen.getText().toString().isEmpty()) {
                    getPresenter().getInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), true);
                } else {
                    getPresenter().getInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), true);
                }
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (edtSoDenTu.getText().toString().isEmpty() && edtSoDenDen.getText().toString().isEmpty()) {
                    getPresenter().getInSoLuuTru_den(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), false);
                } else if (edtSoDenTu.getText().toString().isEmpty()) {
                    getPresenter().getInSoLuuTru_den(NamLamViec, String.valueOf(0), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), false);
                } else if (edtSoDenDen.getText().toString().isEmpty()) {
                    getPresenter().getInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), false);
                } else {
                    getPresenter().getInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), false);
                }
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @OnClick({R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao, R.id.btnBack, R.id.btnTimKiem,
            R.id.tvNgayNhapTu, R.id.tvNgayNhapDen, R.id.rlInso, R.id.lnInSoLuuTru, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnTimKiem:
                if (edtSoDenTu.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Bạn hãy nhập số đi từ", Toast.LENGTH_SHORT).show();
                } else if (edtSoDenDen.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Bạn hãy nhập số đi đến", Toast.LENGTH_SHORT).show();
                } else {
                    getPresenter().getInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), true);
                }
                break;
            case R.id.tvNgayNhapTu:
                final Calendar c1 = Calendar.getInstance();
                mYear = c1.get(Calendar.YEAR);
                mMonth = c1.get(Calendar.MONTH);
                mDay = c1.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
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
                                tvNgayNhapTu.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvNgayNhapDen:
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
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
                                tvNgayNhapDen.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess() {
        if (edtSoDenTu.getText().toString().isEmpty() && edtSoDenDen.getText().toString().isEmpty()) {
            getPresenter().countInSoLuuTru_den(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString());
        } else if (edtSoDenTu.getText().toString().isEmpty()) {
            getPresenter().countInSoLuuTru_den(NamLamViec, String.valueOf(0), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString());
        } else if (edtSoDenDen.getText().toString().isEmpty()) {
            getPresenter().countInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString());
        } else {
            getPresenter().countInSoLuuTru_den(NamLamViec, edtSoDenTu.getText().toString(), edtSoDenDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString());
        }
        getPresenter().countInSoLuuTru_den(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString());
        adapterInSoLuuTruVanbanDen.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống" || response.getMessage() == "The request is invalid.") {
            recyclerview.setVisibility(View.GONE);
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public InSoLuuTruVanBanDenPresenter createPresenter() {
        return new InSoLuuTruVanBanDenPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(InSoLuuTruVanBanDen inSoLuuTruVanBanDen) {

    }

    @Override
    public void onItemClickXuLy(InSoLuuTruVanBanDen inSoLuuTruVanBanDen) {

    }

    @Override
    public void onItemClickXemChiTiet(InSoLuuTruVanBanDen inSoLuuTruVanBanDen) {
        if (!click) {
            Intent i = new Intent(getContext(), ChiTietInSoLuuTruVanBanDenActivity.class);
            i.putExtra("InSoLuuTruVanBanDen", inSoLuuTruVanBanDen);
            startActivity(i);
            click = true;
        }
    }
}
