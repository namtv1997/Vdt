package com.vpdt.vpdt.ui.fragment.XuLyVanBan;

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
import com.vpdt.vpdt.model.DSVB_QuaHan;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSVB_QuaHanDoLanhDaoChiDaoView;
import com.vpdt.vpdt.presenter.DSVB_QuaHanDoLanhDaoChiDao_Presenter;
import com.vpdt.vpdt.presenter.impl.DSVB_QuaHanDoLanhDaoChiDao_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.NDVB_DSVB_QuaHanActivity;
import com.vpdt.vpdt.ui.activity.XuLyVanBan.TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.Adapter_DSVB_QuaHan;
import com.vpdt.vpdt.util.EndlessRecyclerViewScrollListener;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DSVB_QuaHanDoLanhDaoChiDaoFragment extends BaseFragment<DSVB_QuaHanDoLanhDaoChiDao_Presenter> implements DSVB_QuaHanDoLanhDaoChiDaoView,
        Adapter_DSVB_QuaHan.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerviewXLVBQuaHan)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViecDSVBQuaHan)
    Button btnNamLamViec;
    @BindView(R.id.swipe_layoutQuaHan)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.tvTSVBQuaHan)
    TextView tvTSVB;

    String NamLamViec;

    private EndlessRecyclerViewScrollListener scrollListener;
    private Adapter_DSVB_QuaHan listAdapter;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dsvb_quahandoldchidao;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        listAdapter = new Adapter_DSVB_QuaHan(getActivity(), getPresenter().getListDSVB_QuaHan(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(listAdapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getallvbquahandolanhdaochidao(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getallvbquahandolanhdaochidao(NamLamViec, false);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
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
        getPresenter().getallvbquahandolanhdaochidao(NamLamViec, true);
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
    public void onGetListDanhBa() {
        swipeLayout.setRefreshing(false);
        listAdapter.notifyDataSetChanged();
        getPresenter().countvbquahandolanhdaochidao(NamLamViec);
    }

    @Override
    public DSVB_QuaHanDoLanhDaoChiDao_Presenter createPresenter() {
        return new DSVB_QuaHanDoLanhDaoChiDao_PresenterImpl(this);
    }

    @OnClick({R.id.btnNamLamViecDSVBQuaHan, R.id.btnBackQuaHan, R.id.rlldcd, R.id.lnldcd, R.id.vDSVBldcd, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnNamLamViecDSVBQuaHan:
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
            case R.id.btnBackQuaHan:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;


        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getallvbquahandolanhdaochidao(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DSVB_QuaHan dsvb_quaHan) {
        if (dsvb_quaHan.getTaiLieus().size() == 0 || dsvb_quaHan.getTaiLieus() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else if (dsvb_quaHan.getTaiLieus().size() == 1) {
            String dinhkem = String.valueOf(dsvb_quaHan.getTaiLieus());
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhkem.substring(1, dinhkem.length() - 1)));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        } else {
            String dinhkem = String.valueOf(dsvb_quaHan.getTaiLieus().indexOf(dsvb_quaHan.getTaiLieus().size() - 1));
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhkem.substring(1, dinhkem.length() - 1)));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DSVB_QuaHan dsvb_quaHan) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVB_DSVB_QuaHanActivity.class);
            intent.putExtra("ID_VANBAN_QUAHAN", dsvb_quaHan.getIdVanBan());
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(DSVB_QuaHan dsvb_quaHan) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
            intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", dsvb_quaHan.getIdVanBan());
            startActivity(intent);
            click = true;
        }
    }
}
