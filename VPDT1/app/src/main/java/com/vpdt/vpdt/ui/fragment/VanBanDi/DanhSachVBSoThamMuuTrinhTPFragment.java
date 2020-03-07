package com.vpdt.vpdt.ui.fragment.VanBanDi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DetailDanhSachVanBanSoThamMuuTrinhThanhPho;
import com.vpdt.vpdt.presenter.DanhSachVBSoThamMuuTrinhTPPresenter;
import com.vpdt.vpdt.presenter.DanhSachVBSoThamMuuTrinhTPView;
import com.vpdt.vpdt.presenter.impl.DanhSachVBSoThamMuuTrinhTPPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterChonPhongBanSoTaiChinhThamMuu;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachVBSoThamMuuTrinhTP;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DanhSachVBSoThamMuuTrinhTPFragment extends BaseFragment<DanhSachVBSoThamMuuTrinhTPPresenter> implements
        DanhSachVBSoThamMuuTrinhTPView, AdapterChonPhongBanSoTaiChinhThamMuu.OnItemClickListener {

    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    @BindView(R.id.btnNamLamViec)
    TextView btnNamLamViec;
    @BindView(R.id.tvTuNgay)
    TextView tvTuNgay;
    @BindView(R.id.tvDenNgay)
    TextView tvDenNgay;
    @BindView(R.id.tvPhongDonVi)
    TextView tvPhongDonVi;

    @BindView(R.id.lnstmtp)
    LinearLayout lnstmtp;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    RecyclerView rvSelectPhongBan;
    AlertDialog dialog;
    String NamLamViec;
    int mYear, mMonth, mDay, maPhongBan;

    boolean isClick = false;

    DatePickerDialog datePickerDialog;

    AdapterChonPhongBanSoTaiChinhThamMuu adapterChonPhongBanSoTaiChinhThamMuu;
    AdapterDanhSachVBSoThamMuuTrinhTP adapterDanhSachVBSoThamMuuTrinhTP;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_vb_so_tham_muu_trinh_tp;
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
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        getPresenter().getDSPhongban_solgvb(NamLamViec, tvTuNgay.getText().toString(), tvDenNgay.getText().toString(), 0);
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @OnClick({R.id.btnBack, R.id.tvTuNgay, R.id.tvDenNgay, R.id.tvPhongDonVi,
            R.id.btnLoc, R.id.lnvDSVBSTMTTP, R.id.lntn, R.id.rlstmtp, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();

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
            case R.id.tvPhongDonVi:
                android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_nam_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectPhongBan = view1.findViewById(R.id.rvSelectNam);
                rvSelectPhongBan.setLayoutManager(layoutManager);
                rvSelectPhongBan.setAdapter(adapterChonPhongBanSoTaiChinhThamMuu);
                adapterChonPhongBanSoTaiChinhThamMuu.notifyDataSetChanged();
                break;

            case R.id.btnLoc:
                if (isClick) {
                    getPresenter().getVBdi_thammuu(NamLamViec, tvTuNgay.getText().toString(), tvDenNgay.getText().toString(), maPhongBan);
                } else {
                    getPresenter().getVBdi_thammuu(NamLamViec, tvTuNgay.getText().toString(), tvDenNgay.getText().toString(), maPhongBan);
                }
                break;

        }
    }

    @Override
    public void getDSPhongban_solgvb(ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> phongBanSoTaiChinhThamMuuTrinhThanhPhos) {
        adapterChonPhongBanSoTaiChinhThamMuu = new AdapterChonPhongBanSoTaiChinhThamMuu(getActivity(), phongBanSoTaiChinhThamMuuTrinhThanhPhos, this);
    }

    @Override
    public void ongetVBdi_thammuuSuccess(ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho> detailDanhSachVanBanSoThamMuuTrinhThanhPhos) {
        adapterDanhSachVBSoThamMuuTrinhTP = new AdapterDanhSachVBSoThamMuuTrinhTP(getActivity(), detailDanhSachVanBanSoThamMuuTrinhThanhPhos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachVBSoThamMuuTrinhTP);
        adapterDanhSachVBSoThamMuuTrinhTP.notifyDataSetChanged();
        if (isClick) {
            lnstmtp.setVisibility(View.VISIBLE);
            tvTSVB.setText(String.valueOf(detailDanhSachVanBanSoThamMuuTrinhThanhPhos.get(0).getSolg()));
        }
    }

    @Override
    public DanhSachVBSoThamMuuTrinhTPPresenter createPresenter() {
        return new DanhSachVBSoThamMuuTrinhTPPresenterImpl(this);
    }

    @Override
    public void onItemClick(DetailDanhSachVanBanSoThamMuuTrinhThanhPho detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList) {
        maPhongBan = detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.getMa();
        isClick = true;
        dialog.dismiss();
        tvPhongDonVi.setText(String.valueOf(detailDanhSachVanBanSoThamMuuTrinhThanhPhoArrayList.getTen()));
    }
}