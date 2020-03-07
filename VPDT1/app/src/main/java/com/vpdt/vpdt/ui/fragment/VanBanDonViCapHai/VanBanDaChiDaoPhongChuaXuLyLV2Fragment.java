package com.vpdt.vpdt.ui.fragment.VanBanDonViCapHai;

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
import com.vpdt.vpdt.model.VanBanChoChiDaoLV2;
import com.vpdt.vpdt.presenter.VanBanChoChiDaoLV2Presenter;
import com.vpdt.vpdt.presenter.VanBanChoChiDaoLV2View;
import com.vpdt.vpdt.presenter.impl.VanBanChoChiDaoLV2PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDonViCapHai.NDVBVanBanDaChiDaoPhongChuaXuLyLV2Activity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterVanBanChoChiDaoLV2;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VanBanDaChiDaoPhongChuaXuLyLV2Fragment extends BaseFragment<VanBanChoChiDaoLV2Presenter> implements VanBanChoChiDaoLV2View,
        AdapterVanBanChoChiDaoLV2.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewChoXuLy)
    RecyclerView recyclerviewChoXuLy;

    @BindView(R.id.btnNamLamViecChoXuLy)
    Button btnNamLamViecChoXuLy;
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
    private AdapterVanBanChoChiDaoLV2 listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_vanbandachidaophongchuaxuly;
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
        btnNamLamViecChoXuLy.setText("Năm làm việc: " + NamLamViec + "   ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(NamLamViec, true);
        listAdapter = new AdapterVanBanChoChiDaoLV2(getPresenter().VAN_BAN_CHO_CHI_DAO_LV_2_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewChoXuLy.setLayoutManager(layoutManager);
        recyclerviewChoXuLy.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(NamLamViec, false);
            }
        };
        recyclerviewChoXuLy.addOnScrollListener(scrollListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDataSuccess() {
        listAdapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
        getPresenter().countAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(NamLamViec);
    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerviewChoXuLy.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerviewChoXuLy.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @OnClick({R.id.btnNamLamViecChoXuLy, R.id.btnBackChoXuLy,
            R.id.vcldxl, R.id.rlcldxl, R.id.lncldxl, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecChoXuLy:
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
            case R.id.btnBackChoXuLy:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViecChoXuLy.setText("Năm làm việc: " + integer + "   ");
        getPresenter().getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public VanBanChoChiDaoLV2Presenter createPresenter() {
        return new VanBanChoChiDaoLV2PresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(VanBanChoChiDaoLV2 vanBanChoChiDaoLV2) {
        if (vanBanChoChiDaoLV2.getUrlFile().isEmpty() || vanBanChoChiDaoLV2.getUrlFile() == null) {
            Toast.makeText(getActivity(), "Không có file đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanChoChiDaoLV2.getUrlFile()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(VanBanChoChiDaoLV2 vanBanChoChiDaoLV2) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBVanBanDaChiDaoPhongChuaXuLyLV2Activity.class);
            intent.putExtra("vanBanChoChiDaoLV2", vanBanChoChiDaoLV2);
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(VanBanChoChiDaoLV2 vanBanChoChiDaoLV2) {
        if (!click) {
//            Intent intent = new Intent(getActivity(), TTVBCongViecPhoiHopChoXuLyActivity.class);
//            intent.putExtra("ID_VANBAN_CONGVIECPHOIHOPCHOXULY", deXuatCongViecPhoiHopChoDuyet.getIdVB());
//            startActivity(intent);
//            click = true;
        }
    }
}
