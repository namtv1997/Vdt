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
import com.vpdt.vpdt.model.DeatailDauSoCuaSo;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DanhSachVanBanChoSoCuaSoPresenter;
import com.vpdt.vpdt.presenter.DanhSachVanBanChoSoCuaSoView;
import com.vpdt.vpdt.presenter.impl.DanhSachVanBanChoSoCuaSoPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.NDVBDSVBChoSoCuaSoActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.TTVBDSVBChoSoCuaSoActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachVanBanChoSoCuaSo;
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

public class DanhSachVanBanChoSoCuaSoFragment extends BaseFragment<DanhSachVanBanChoSoCuaSoPresenter> implements DanhSachVanBanChoSoCuaSoView,
        AdapterDanhSachVanBanChoSoCuaSo.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.tvTSVB)
    TextView tvTSVB;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    boolean click = false;

    String NamLamViec;
    AdapterDanhSachVanBanChoSoCuaSo adapterDanhSachVanBanChoSoCuaSo;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_van_ban_cho_so_cua_so;
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
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getDSVB_ChoSo_CuaSo(NamLamViec, true);

        adapterDanhSachVanBanChoSoCuaSo = new AdapterDanhSachVanBanChoSoCuaSo(getPresenter().deatailDauSoCuaSos(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachVanBanChoSoCuaSo);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getDSVB_ChoSo_CuaSo(NamLamViec, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getDSVB_ChoSo_CuaSo(NamLamViec, false);
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
        return getActivity();
    }

    @Override
    public void ongetDSVB_ChoSo_CuaSoSuccess() {
        swipeLayout.setRefreshing(false);
        adapterDanhSachVanBanChoSoCuaSo.notifyDataSetChanged();
        getPresenter().countVBdi_ChoSo(NamLamViec);

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {
        if (response.getData() == 0) {
            recyclerview.setVisibility(View.GONE);
            Util.showMessenger("Không có văn bản nào", getActivity());
        } else {
            recyclerview.setVisibility(View.VISIBLE);
        }
        tvTSVB.setText(String.valueOf(response.getData()));
    }

    @Override
    public DanhSachVanBanChoSoCuaSoPresenter createPresenter() {
        return new DanhSachVanBanChoSoCuaSoPresenterImpl(this);
    }


    @OnClick({R.id.btnBack, R.id.vdsgmcs, R.id.lndsgmcs, R.id.rldsgmcs, R.id.btnNamLamViec, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
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

        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getDSVB_ChoSo_CuaSo(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClickXemFile(DeatailDauSoCuaSo deatailDauSoCuaSo) {
        if (deatailDauSoCuaSo.getDuongdan().isEmpty() || deatailDauSoCuaSo.getDuongdan() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deatailDauSoCuaSo.getDuongdan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DeatailDauSoCuaSo deatailDauSoCuaSo) {
        if (!click) {
            Intent intent = new Intent(getActivity(), NDVBDSVBChoSoCuaSoActivity.class);
            intent.putExtra("ID_VANBAN_CHOSOCUASO", deatailDauSoCuaSo);
            startActivity(intent);
            click = true;
        }
    }

    @Override
    public void onItemClickXemChiTiet(DeatailDauSoCuaSo deatailDauSoCuaSo) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVBDSVBChoSoCuaSoActivity.class);
            intent.putExtra("ID_VANBAN_CHOSOCUASO", deatailDauSoCuaSo.getMavb());
            startActivity(intent);
            click = true;
        }

    }
}