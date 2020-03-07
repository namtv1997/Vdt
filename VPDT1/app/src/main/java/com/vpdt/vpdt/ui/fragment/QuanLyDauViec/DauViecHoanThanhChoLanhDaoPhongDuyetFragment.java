package com.vpdt.vpdt.ui.fragment.QuanLyDauViec;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DauViecHoanThanhChoLanhDaoPhongDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DauViecHoanThanhChoLanhDaoPhongDuyetPresenter;
import com.vpdt.vpdt.presenter.DauViecHoanThanhChoLanhDaoPhongDuyetView;
import com.vpdt.vpdt.presenter.impl.DauViecHoanThanhChoLanhDaoPhongDuyetPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.QuanLyDauViec.NDVBDauViecHoanThanhChoLanhDaoPhongDuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDauViecHoanThanhChoLanhDaoPhongDuyet;
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

public class DauViecHoanThanhChoLanhDaoPhongDuyetFragment extends BaseFragment<DauViecHoanThanhChoLanhDaoPhongDuyetPresenter> implements DauViecHoanThanhChoLanhDaoPhongDuyetView,
        AdapterDauViecHoanThanhChoLanhDaoPhongDuyet.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

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
    @BindView(R.id.tvChonNhiemKy)
    TextView tvChonNhiemKy;
    private EndlessRecyclerViewScrollListener scrollListener;
    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    AdapterDauViecHoanThanhChoLanhDaoPhongDuyet adapterDauViecDeXuat;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dau_viec_hoan_thanh_cho_lanh_dao_phong_duyet;
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
        getPresenter().getAllDauViecHoanThanhChoLDDuyet(NamLamViec, true);

        adapterDauViecDeXuat = new AdapterDauViecHoanThanhChoLanhDaoPhongDuyet(getPresenter().DAU_VIEC_HOAN_THANH_CHO_LANH_DAO_PHONG_DUYET_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDauViecDeXuat);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllDauViecHoanThanhChoLDDuyet(NamLamViec, false);

            }
        };
        recyclerview.addOnScrollListener(scrollListener);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllDauViecHoanThanhChoLDDuyet(NamLamViec, true);

            }
        });
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.rlcldxl1, R.id.vttm, R.id.tvChonNhiemKy, R.id.tvChonKyHop,
            R.id.tvChonKhoa, R.id.tvChonLoaiVanBan, R.id.btnLocDuLieu, R.id.btnHome})
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
//            case R.id.tvChonNhiemKy:
//            case R.id.tvChonKyHop:
//            case R.id.tvChonKhoa:
//            case R.id.tvChonLoaiVanBan:
//            case R.id.btnLocDuLieu:
//                Toast.makeText(getActivity(), "Chức năng đang hoàn thiện", Toast.LENGTH_SHORT).show();
//                break;
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
        adapterDauViecDeXuat.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countDauViecHoanThanhChoLDDuyet(NamLamViec);

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
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllDauViecHoanThanhChoLDDuyet(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public DauViecHoanThanhChoLanhDaoPhongDuyetPresenter createPresenter() {
        return new DauViecHoanThanhChoLanhDaoPhongDuyetPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet) {
        if (dauViecHoanThanhChoLanhDaoPhongDuyet.getUrlFile().isEmpty() || dauViecHoanThanhChoLanhDaoPhongDuyet.getUrlFile() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dauViecHoanThanhChoLanhDaoPhongDuyet.getUrlFile()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBDauViecHoanThanhChoLanhDaoPhongDuyetActivity.class);
            intent.putExtra("dauViecHoanThanhChoLanhDaoPhongDuyet", dauViecHoanThanhChoLanhDaoPhongDuyet);
            startActivity(intent);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DauViecHoanThanhChoLanhDaoPhongDuyet dauViecHoanThanhChoLanhDaoPhongDuyet) {

    }
}
