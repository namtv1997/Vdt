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
import com.vpdt.vpdt.model.BaoCaoCuocHopChoPheDuyet;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.BaoCaoCuocHopChoPheDuyetPresenter;
import com.vpdt.vpdt.presenter.BaoCaoCuocHopChoPheDuyetView;
import com.vpdt.vpdt.presenter.impl.BaoCaoCuocHopChoPheDuyetPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.NDVBBaoCaoCuocHopChoPheDuyetActivity;
import com.vpdt.vpdt.ui.activity.XuLyGiayMoi.TTVBBaoCaoCuocHopChoPheDuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterBaoCaoCuocHopChoPheDuyet;
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

public class BaoCaoCuocHopChoPheDuyetFragment extends BaseFragment<BaoCaoCuocHopChoPheDuyetPresenter> implements BaoCaoCuocHopChoPheDuyetView,
        AdapterBaoCaoCuocHopChoPheDuyet.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecBCKQCHDGD)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTongSoVanBan)
    TextView tvTSVB;
    boolean click = false;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;

    private EndlessRecyclerViewScrollListener scrollListener;
    private AdapterBaoCaoCuocHopChoPheDuyet listAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_bao_cao_cuoc_hop_cho_phe_duyet;
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
        getPresenter().getAllBaoCaoCuocHopChoDuyet(NamLamViec, true);

        listAdapter = new AdapterBaoCaoCuocHopChoPheDuyet(getPresenter().BAO_CAO_CUOC_HOP_CHO_PHE_DUYET_ARRAY_LIST(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getAllBaoCaoCuocHopChoDuyet(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getAllBaoCaoCuocHopChoDuyet(NamLamViec, false);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
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
        getPresenter().countAllBaoCaoCuocHopChoDuyet(NamLamViec);

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

    @OnClick({R.id.btnNamLamViecBCKQCHDGD, R.id.btnBack, R.id.vbckqdgd, R.id.lnbckqdgd, R.id.rlbckqdgd, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecBCKQCHDGD:
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
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllBaoCaoCuocHopChoDuyet(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }


    @Override
    public BaoCaoCuocHopChoPheDuyetPresenter createPresenter() {
        return new BaoCaoCuocHopChoPheDuyetPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(BaoCaoCuocHopChoPheDuyet baoCaoCuocHopChoPheDuyet) {
        if (baoCaoCuocHopChoPheDuyet.getFileBaoCao().isEmpty() || baoCaoCuocHopChoPheDuyet.getFileBaoCao() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(baoCaoCuocHopChoPheDuyet.getFileBaoCao()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(BaoCaoCuocHopChoPheDuyet baoCaoCuocHopChoPheDuyet) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBBaoCaoCuocHopChoPheDuyetActivity.class);
            intent.putExtra("baoCaoCuocHopChoPheDuyet", baoCaoCuocHopChoPheDuyet);
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(BaoCaoCuocHopChoPheDuyet baoCaoCuocHopChoPheDuyet) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBBaoCaoCuocHopChoPheDuyetActivity.class);
            intent.putExtra("idvb", baoCaoCuocHopChoPheDuyet.getId());
            startActivity(intent);
            click = true;
        }
    }
}
