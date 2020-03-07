package com.vpdt.vpdt.ui.fragment.VanBanDi;


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
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanDaTrinhKy;
import com.vpdt.vpdt.presenter.VanBanDaTrinhKyPresenter;
import com.vpdt.vpdt.presenter.VanBanDaTrinhKyView;
import com.vpdt.vpdt.presenter.impl.VanBanDaTrinhKyPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.TTVBVanBanTrinhKyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterVanBanDaTrinhKy;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VanBanDaTrinhKyFragment extends BaseFragment<VanBanDaTrinhKyPresenter> implements VanBanDaTrinhKyView,
        AdapterVanBanDaTrinhKy.OnItemClickListener,
        AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewGiayMoiLanhDaoDaChiDao)
    RecyclerView recyclerviewGiayMoiLanhDaoDaChiDao;
    @BindView(R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao)
    Button btnNamLamViecGiayMoiLanhDaoDaChiDao;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;
    AdapterVanBanDaTrinhKy listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_van_ban_da_trinh_ky;
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
        btnNamLamViecGiayMoiLanhDaoDaChiDao.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getVBtrinhky(NamLamViec, true);
        listAdapter = new AdapterVanBanDaTrinhKy(getPresenter().VAN_BAN_DA_TRINH_KY_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewGiayMoiLanhDaoDaChiDao.setLayoutManager(layoutManager);
        recyclerviewGiayMoiLanhDaoDaChiDao.setAdapter(listAdapter);
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getVBtrinhky(NamLamViec, false);

            }
        };
        recyclerviewGiayMoiLanhDaoDaChiDao.addOnScrollListener(scrollListener);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getVBtrinhky(NamLamViec, true);
            }
        });
    }

    @OnClick({R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao, R.id.btnBackGiayMoiLanhDaoDaChiDao, R.id.vvbtk, R.id.lnvbbtk, R.id.vbtk, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecGiayMoiLanhDaoDaChiDao:
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
            case R.id.btnBackGiayMoiLanhDaoDaChiDao:
                Objects.requireNonNull(getActivity()).onBackPressed();

                break;

        }
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countVBtrinhky(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerviewGiayMoiLanhDaoDaChiDao.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewGiayMoiLanhDaoDaChiDao.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public VanBanDaTrinhKyPresenter createPresenter() {
        return new VanBanDaTrinhKyPresenterImpl(this);
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecGiayMoiLanhDaoDaChiDao.setText("Năm làm việc: " + integer + " ");
        getPresenter().getVBtrinhky(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(VanBanDaTrinhKy vanBanDaTrinhKy) {
        if (vanBanDaTrinhKy.getDuongdan().isEmpty() || vanBanDaTrinhKy.getDuongdan() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDaTrinhKy.getDuongdan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(VanBanDaTrinhKy vanBanDaTrinhKy) {


    }

    @Override
    public void onItemClickXemChiTiet(VanBanDaTrinhKy vanBanDaTrinhKy) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBVanBanTrinhKyActivity.class);
            intent.putExtra("ID_VANBAN_DI", vanBanDaTrinhKy);
            startActivity(intent);
            click = true;
        }
    }
}
