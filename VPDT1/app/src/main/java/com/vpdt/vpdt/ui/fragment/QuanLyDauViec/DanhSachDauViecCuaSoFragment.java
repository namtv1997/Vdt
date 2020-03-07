package com.vpdt.vpdt.ui.fragment.QuanLyDauViec;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DetailDauViecCuaSo;
import com.vpdt.vpdt.model.ItemDauViecCuaSo;
import com.vpdt.vpdt.presenter.DanhSachDauViecCuaSoPresenter;
import com.vpdt.vpdt.presenter.DanhSachDauViecCuaSoView;
import com.vpdt.vpdt.presenter.impl.DanhSachDauViecCuaSoPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDauViecCuaSo;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DanhSachDauViecCuaSoFragment extends BaseFragment<DanhSachDauViecCuaSoPresenter> implements DanhSachDauViecCuaSoView {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvTongSoDauViec)
    TextView tvTongSoDauViec;
    @BindView(R.id.tvTrongHanDTH)
    TextView tvTrongHanDTH;
    @BindView(R.id.tvQuaHanDTH)
    TextView tvQuaHanDTH;
    @BindView(R.id.tvTrongHanDHT)
    TextView tvTrongHanDHT;
    @BindView(R.id.tvQuaHanDHT)
    TextView tvQuaHanDHT;
    @BindView(R.id.tvSapDenHan)
    TextView tvSapDenHan;

    String NamLamViec;
    AdapterDauViecCuaSo adapterDauViecCuaSo;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_sach_dau_viec_cua_so;
    }

    @Override
    public void initializeComponents(View view) {
        Util.checkConnection(getActivity());
        ((MainActivity) getActivity()).checkFragment(this);
        ButterKnife.bind(this, view);
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        getPresenter().gettkdauviec();
    }

    @OnClick({R.id.btnBack, R.id.rlDSDVCS, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
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
    public void onGetDataSuccess(DetailDauViecCuaSo detailDauViecCuaSo) {
        adapterDauViecCuaSo = new AdapterDauViecCuaSo(getActivity(), (ArrayList<ItemDauViecCuaSo>) detailDauViecCuaSo.getItems());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDauViecCuaSo);
        adapterDauViecCuaSo.notifyDataSetChanged();
        tvTrichYeu.setText(String.valueOf(detailDauViecCuaSo.getTsVanban()));
        tvTongSoDauViec.setText(String.valueOf(detailDauViecCuaSo.getTsDauviec()));
        tvTrongHanDTH.setText(String.valueOf(detailDauViecCuaSo.getTsDthTronghan()));
        tvQuaHanDTH.setText(String.valueOf(detailDauViecCuaSo.getTsDthQuahan()));
        tvTrongHanDHT.setText(String.valueOf(detailDauViecCuaSo.getTsDhtTronghan()));
        tvQuaHanDHT.setText(String.valueOf(detailDauViecCuaSo.getTsDhtQuahan()));
        tvSapDenHan.setText(String.valueOf(detailDauViecCuaSo.getTsSapdenHan()));
    }

    @Override
    public DanhSachDauViecCuaSoPresenter createPresenter() {
        return new DanhSachDauViecCuaSoPresenterImpl(this);
    }
}