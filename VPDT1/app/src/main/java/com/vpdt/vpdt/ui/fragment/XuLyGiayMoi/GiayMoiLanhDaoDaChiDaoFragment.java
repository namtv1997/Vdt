package com.vpdt.vpdt.ui.fragment.XuLyGiayMoi;

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
import com.vpdt.vpdt.model.GiayMoiChoLanhDaoXuLy;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.GiayMoiLanhDaoDaChiDaoPresenter;
import com.vpdt.vpdt.presenter.GiayMoiLanhDaoDaChiDaoView;
import com.vpdt.vpdt.presenter.impl.GiayMoiLanhDaoDaChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.NDVBGiayMoiLanhDaoDaChiDaoActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.ThongTinGiayMoiDaXuLyActivity;
import com.vpdt.vpdt.ui.adapter.AdapterGiayMoiChoLanhDaoXuLy;
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

public class GiayMoiLanhDaoDaChiDaoFragment extends BaseFragment<GiayMoiLanhDaoDaChiDaoPresenter> implements GiayMoiLanhDaoDaChiDaoView,
        AdapterGiayMoiChoLanhDaoXuLy.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTongSoVanBan)
    TextView tvTongSoVanBan;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    AdapterGiayMoiChoLanhDaoXuLy adapterGiayMoiChoLanhDaoXuLy;

    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_giay_moi_lanh_dao_da_chi_dao;
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
        click = false;
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getallgiaymoilanhdaodaxuly(NamLamViec, true);

        adapterGiayMoiChoLanhDaoXuLy = new AdapterGiayMoiChoLanhDaoXuLy(getActivity(), getPresenter().giayMoiChoLanhDaoXuLyArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterGiayMoiChoLanhDaoXuLy);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallgiaymoilanhdaodaxuly(NamLamViec, true);
            }
        });

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallgiaymoilanhdaodaxuly(NamLamViec, false);

            }
        };
        recyclerview.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.rlgmlddcd, R.id.vgmlddcd, R.id.lngmlddcd, R.id.btnHome})
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
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallgiaymoilanhdaodaxuly(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetDataSuccess() {
        adapterGiayMoiChoLanhDaoXuLy.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countgiaymoilanhdaodaxuly(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0 || response.getMessage() == "Lỗi hệ thống") {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTongSoVanBan.setText(String.valueOf(response.getData()));
    }

    @Override
    public GiayMoiLanhDaoDaChiDaoPresenter createPresenter() {
        return new GiayMoiLanhDaoDaChiDaoPresenterImpl(this);
    }


    @Override
    public void onItemClickXemFile(GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy) {
        try {
            if (giayMoiChoLanhDaoXuLy.getTepDinhKems().size() == 0) {
                Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
            } else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(giayMoiChoLanhDaoXuLy.getTepDinhKems().get(giayMoiChoLanhDaoXuLy.getTepDinhKems().size() - 1).getDuongDan()));
                startActivity(browserIntent);
            }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClickXuLy(GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy) {
        if (!click) {
            Intent i = new Intent(getContext(), NDVBGiayMoiLanhDaoDaChiDaoActivity.class);
            i.putExtra("giayMoiLanhDaodachidao", giayMoiChoLanhDaoXuLy);
            startActivity(i);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(GiayMoiChoLanhDaoXuLy giayMoiChoLanhDaoXuLy) {
        if (!click) {
            Intent intent = new Intent(getActivity(), ThongTinGiayMoiDaXuLyActivity.class);
            intent.putExtra("idvb", giayMoiChoLanhDaoXuLy.getId());
            startActivity(intent);
            click = true;
        }

    }
}
