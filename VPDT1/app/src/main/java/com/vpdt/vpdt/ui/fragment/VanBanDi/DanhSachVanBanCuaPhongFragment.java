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
import com.vpdt.vpdt.model.DSVBCuaPhong;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.presenter.DSVB_CuaPhongView;
import com.vpdt.vpdt.presenter.DSVB_CuaPhong_Presenter;
import com.vpdt.vpdt.presenter.impl.DSVB_CuaPhong_PresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.NDVB_DanhSachVanBanCuaPhongActivity;
import com.vpdt.vpdt.ui.activity.VanBanDi.TTVB_DanhSachVanBanCuaPhongActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachVanBanCuaPhong;
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

public class DanhSachVanBanCuaPhongFragment extends BaseFragment<DSVB_CuaPhong_Presenter> implements DSVB_CuaPhongView,
        AdapterDanhSachVanBanCuaPhong.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipe_layout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView(R.id.btnBack)
    Button btnBack;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvTSVB)
    TextView tvTSVB;

    String NamLamViec;
    AdapterDanhSachVanBanCuaPhong adapterDanhSachVanBanCuaPhong;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog1;
    int year;
    boolean click = false;

    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_van_ban_cua_phong;
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
        getPresenter().getDSVB_cuaPhong(NamLamViec, true);

        adapterDanhSachVanBanCuaPhong = new AdapterDanhSachVanBanCuaPhong(getPresenter().dsvbCuaPhongs(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachVanBanCuaPhong);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getDSVB_cuaPhong(NamLamViec, false);
            }
        };
        recyclerview.addOnScrollListener(scrollListener);
        swipe_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getDSVB_cuaPhong(NamLamViec, true);
            }
        });
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
        adapterDanhSachVanBanCuaPhong.notifyDataSetChanged();
        swipe_layout.setRefreshing(false);
        getPresenter().countDSVB_cuaPhong(NamLamViec);

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
                AlertDialog.Builder builderNamLamViec = new AlertDialog.Builder(getContext());
                LayoutInflater inflaterNamLamViec = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNamLamViec = inflaterNamLamViec.inflate(R.layout.recyclerview_nam_selected, null);
                builderNamLamViec.setView(viewNamLamViec);
                dialog1 = builderNamLamViec.create();
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                rvSelectNam = viewNamLamViec.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        PrefUtil.saveString(getContext(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        getPresenter().getDSVB_cuaPhong(String.valueOf(integer), true);
        NamLamViec = String.valueOf(integer);
        dialog1.dismiss();
    }


    @Override
    public DSVB_CuaPhong_Presenter createPresenter() {
        return new DSVB_CuaPhong_PresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(DSVBCuaPhong dsvbCuaPhong) {
        if (dsvbCuaPhong.getDuongdan().isEmpty() || dsvbCuaPhong.getDuongdan() == null) {
            Toast.makeText(getActivity(), "Không có tệp tin đính kèm", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dsvbCuaPhong.getDuongdan()));
                startActivity(browserIntent);
            } catch (Exception e) {
                Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onItemClickXuLy(DSVBCuaPhong dsvbCuaPhong) {
        if (!click) {
            Intent i = new Intent(getContext(), NDVB_DanhSachVanBanCuaPhongActivity.class);
            i.putExtra("dsvbCuaPhong", dsvbCuaPhong);
            startActivity(i);
            click = true;
        }

    }

    @Override
    public void onItemClickXemChiTiet(DSVBCuaPhong dsvbCuaPhong) {
        if (!click) {
            Intent intent = new Intent(getActivity(), TTVB_DanhSachVanBanCuaPhongActivity.class);
            intent.putExtra("dsvbCuaPhong", dsvbCuaPhong.getMavb());
            startActivity(intent);
            click = true;
        }

    }
}