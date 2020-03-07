package com.vpdt.vpdt.ui.fragment.TraoDoiThongTinNoiBo;

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
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.TraoDoiThongTinNoiBo;
import com.vpdt.vpdt.presenter.ThongTinMoiPresenter;
import com.vpdt.vpdt.presenter.ThongTinMoiView;
import com.vpdt.vpdt.presenter.impl.ThongTinMoiPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.TraoDoiThongTinNoiBo.TTVBThongTinDaXemActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterThongTinMoi;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThongTinDaXemFragment extends BaseFragment<ThongTinMoiPresenter> implements ThongTinMoiView,
        AdapterThongTinMoi.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
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

    private AdapterThongTinMoi adapterThongTinMoi;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_thong_tin_da_xem;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);


        adapterThongTinMoi = new AdapterThongTinMoi(getActivity(), getPresenter().traoDoiThongTinNoiBoArrayList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterThongTinMoi);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallvanbanThongTinNoiBo(NamLamViec, 0, false);

            }
        };
        recyclerview.addOnScrollListener(scrollListener);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallvanbanThongTinNoiBo(NamLamViec, 0, true);

            }
        });
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
        getPresenter().getallvanbanThongTinNoiBo(NamLamViec, 0, true);
    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.vttdx, R.id.lnttdx, R.id.rlttdx, R.id.btnHome})
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
        adapterThongTinMoi.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countvanbanThongTinNoiBo(NamLamViec, 0);

    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallvanbanThongTinNoiBo(String.valueOf(integer), 0, true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
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
    public ThongTinMoiPresenter createPresenter() {
        return new ThongTinMoiPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(TraoDoiThongTinNoiBo traoDoiThongTinNoiBo) {

    }

    @Override
    public void onItemClickXuLy(TraoDoiThongTinNoiBo traoDoiThongTinNoiBo) {

    }

    @Override
    public void onItemClickXemChiTiet(TraoDoiThongTinNoiBo traoDoiThongTinNoiBo) {
        if (!click) {
            Intent intent1 = new Intent(getActivity(), TTVBThongTinDaXemActivity.class);
            intent1.putExtra("TTVBThongTinDaXem", traoDoiThongTinNoiBo.getId());
            startActivity(intent1);
            click = true;
        }

    }
}