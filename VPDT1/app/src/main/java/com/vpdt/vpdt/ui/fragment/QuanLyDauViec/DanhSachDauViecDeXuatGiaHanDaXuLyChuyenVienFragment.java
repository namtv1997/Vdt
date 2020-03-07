package com.vpdt.vpdt.ui.fragment.QuanLyDauViec;


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
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DeXuatGiaHanChoDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DanhSachDauViecDeXuatGiaHanPresenter;
import com.vpdt.vpdt.presenter.DanhSachDauViecDeXuatGiaHanView;
import com.vpdt.vpdt.presenter.impl.DanhSachDauViecDeXuatGiaHanPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.NDVBDeXuatGiaHanDaXuLyActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.TTVBDeXuatGiaHanChoXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDauViecDeXuat1;
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

public class DanhSachDauViecDeXuatGiaHanDaXuLyChuyenVienFragment extends BaseFragment<DanhSachDauViecDeXuatGiaHanPresenter> implements DanhSachDauViecDeXuatGiaHanView,
        AdapterNamLamViec.OnItemClickListenerNamLamViec, AdapterDauViecDeXuat1.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    private EndlessRecyclerViewScrollListener scrollListener;
    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    AdapterDauViecDeXuat1 adapterDauViecDeXuat1;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_dau_viec_de_xuat_gia_han_da_xu_ly;
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
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getAllDauViecDeXuatGiaHanChoDuyetCV(NamLamViec, 1, true);

        adapterDauViecDeXuat1 = new AdapterDauViecDeXuat1(getPresenter().deXuatGiaHanChoDuyetArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDauViecDeXuat1);
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllDauViecDeXuatGiaHanChoDuyetCV(NamLamViec, 1, false);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllDauViecDeXuatGiaHanChoDuyetCV(NamLamViec, 1, true);
            }
        });
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.vttm, R.id.lnttm, R.id.rlttm, R.id.btnHome})
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
        adapterDauViecDeXuat1.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countAllDauViecDeXuatGiaHanChoDuyetCV(NamLamViec, 1);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public DanhSachDauViecDeXuatGiaHanPresenter createPresenter() {
        return new DanhSachDauViecDeXuatGiaHanPresenterImpl(this);
    }


    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllDauViecDeXuatGiaHanChoDuyetCV(String.valueOf(integer), 1, true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DeXuatGiaHanChoDuyet deXuatGiaHanChoDuyet) {

    }

    @Override
    public void onItemClickXuLy(DeXuatGiaHanChoDuyet deXuatGiaHanChoDuyet) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBDeXuatGiaHanDaXuLyActivity.class);
            intent.putExtra("deXuatGiaHanChoDuyet", deXuatGiaHanChoDuyet);
            startActivity(intent);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DeXuatGiaHanChoDuyet deXuatGiaHanChoDuyet) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBDeXuatGiaHanChoXuLyActivity.class);
            intent.putExtra("idvb", deXuatGiaHanChoDuyet.getId());
            startActivity(intent);
            click = true;
        }

    }
}
