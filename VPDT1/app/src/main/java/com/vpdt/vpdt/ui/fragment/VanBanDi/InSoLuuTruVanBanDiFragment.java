package com.vpdt.vpdt.ui.fragment.VanBanDi;


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
import com.vpdt.vpdt.model.InSoLuuTruVanbanDi;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDiPresenter;
import com.vpdt.vpdt.presenter.InSoLuuTruVanBanDiView;
import com.vpdt.vpdt.presenter.impl.InSoLuuTruVanBanDiPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.ChiTietInSoLuuTruVanBanActivity;
import com.vpdt.vpdt.ui.adapter.AdapterInSoLuuTru;
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

public class InSoLuuTruVanBanDiFragment extends BaseFragment<InSoLuuTruVanBanDiPresenter> implements InSoLuuTruVanBanDiView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec, AdapterInSoLuuTru.OnItemClickListenerSoLuuTru {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;

    @BindView(R.id.tvNgayNhapTu)
    TextView tvNgayNhapTu;
    @BindView(R.id.tvNgayNhapDen)
    TextView tvNgayNhapDen;
    @BindView(R.id.tvNgayMoiTu)
    TextView tvNgayMoiTu;
    @BindView(R.id.tvNgayMoiDen)
    TextView tvNgayMoiDen;
    @BindView(R.id.tvChonSo)
    TextView tvChonSo;

    @BindView(R.id.edtSoDiTu)
    EditText edtSoDiTu;
    @BindView(R.id.edtSoDiDen)
    EditText edtSoDiDen;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    private int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    private EndlessRecyclerViewScrollListener scrollListener;
    AdapterInSoLuuTru adapterInSoLuuTru;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_in_so_luu_tru_van_ban_di;
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
//        tvChonSo.setText("Sổ thường");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }

        adapterInSoLuuTru = new AdapterInSoLuuTru(getPresenter().inSoLuuTruVanbanDiArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterInSoLuuTru);
        if (tvChonSo.getText() == "Sổ thường") {
            getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
        } else if (tvChonSo.getText() == "Sổ giấy mời") {
            getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 1, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
        } else {
            getPresenter().getVBdi_InSoLuuTru(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
        }
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (tvChonSo.getText() == "Sổ thường") {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
                } else if (tvChonSo.getText() == "Sổ giấy mời") {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 1, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
                } else {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
                }
            }
        });

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (tvChonSo.getText() == "Sổ thường") {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), false);
                } else if (tvChonSo.getText() == "Sổ giấy mời") {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 1, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), false);
                } else {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), false);
                }
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.btnTimKiem,
            R.id.tvNgayNhapTu, R.id.tvNgayNhapDen, R.id.tvNgayMoiTu, R.id.tvNgayMoiDen, R.id.tvChonSo, R.id.rlInso, R.id.lnInSoLuuTru, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViec:
                android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
            case R.id.btnTimKiem:

                if (edtSoDiTu.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Bạn hãy nhập số đi từ", Toast.LENGTH_SHORT).show();
                } else if (edtSoDiDen.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Bạn hãy nhập số đi đến", Toast.LENGTH_SHORT).show();
                }
                if (tvChonSo.getText() == "Sổ thường") {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
                } else {
                    getPresenter().getVBdi_InSoLuuTru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 1, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString(), true);
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
                                tvNgayNhapDen.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvNgayMoiTu:
                final Calendar c2 = Calendar.getInstance();
                mYear = c2.get(Calendar.YEAR);
                mMonth = c2.get(Calendar.MONTH);
                mDay = c2.get(Calendar.DAY_OF_MONTH);
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
                                tvNgayMoiTu.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvNgayMoiDen:
                final Calendar c3 = Calendar.getInstance();
                mYear = c3.get(Calendar.YEAR);
                mMonth = c3.get(Calendar.MONTH);
                mDay = c3.get(Calendar.DAY_OF_MONTH);
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
                                tvNgayMoiDen.setText(date);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvChonSo:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Objects.requireNonNull(getContext()));
                LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewChonSo = inflater1.inflate(R.layout.list_item, null);
                builder1.setView(viewChonSo);
                final AlertDialog dialogChonSo = builder1.create();
                Objects.requireNonNull(dialogChonSo.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogChonSo.show();
                TextView tvSoThuong = viewChonSo.findViewById(R.id.tvSoThuong);
                TextView tvSoGiayMoi = viewChonSo.findViewById(R.id.tvSoGiayMoi);
                tvSoThuong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonSo.setText("Sổ thường");
                        dialogChonSo.dismiss();
                    }
                });
                tvSoGiayMoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvChonSo.setText("Sổ giấy mời");
                        dialogChonSo.dismiss();
                    }
                });
                break;
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
    public void onGetDataSuccess() {
        adapterInSoLuuTru.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
        if (tvChonSo.getText() == "Sổ thường") {
            getPresenter().countVBdi_Insoluutru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString());
        } else if (tvChonSo.getText() == "Sổ giấy mời") {
            getPresenter().countVBdi_Insoluutru(NamLamViec, edtSoDiTu.getText().toString(), edtSoDiDen.getText().toString(), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 1, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString());
        } else {
            getPresenter().countVBdi_Insoluutru(NamLamViec, String.valueOf(0), String.valueOf(0), tvNgayNhapTu.getText().toString(), tvNgayNhapDen.getText().toString(), 0, tvNgayMoiTu.getText().toString(), tvNgayMoiDen.getText().toString());
        }
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
    public InSoLuuTruVanBanDiPresenter createPresenter() {
        return new InSoLuuTruVanBanDiPresenterImpl(this);
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(InSoLuuTruVanbanDi inSoLuuTruVanbanDi) {
    }

    @Override
    public void onItemClickXuLy(InSoLuuTruVanbanDi inSoLuuTruVanbanDi) {

    }

    @Override
    public void onItemClickXemChiTiet(InSoLuuTruVanbanDi inSoLuuTruVanbanDi) {
        if (!click) {
            Intent i = new Intent(getContext(), ChiTietInSoLuuTruVanBanActivity.class);
            i.putExtra("InSoLuuTruVanbanDi", inSoLuuTruVanbanDi);
            startActivity(i);
            click = true;
        }
    }
}
