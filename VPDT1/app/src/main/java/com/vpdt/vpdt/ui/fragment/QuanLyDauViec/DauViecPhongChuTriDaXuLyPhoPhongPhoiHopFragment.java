package com.vpdt.vpdt.ui.fragment.QuanLyDauViec;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.DanhSachDauViecPhongChuTriDaChiDaoChuaHT;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriDaChiDaoChuaHTPresenter;
import com.vpdt.vpdt.presenter.DauViecPhongChuTriDaChiDaoChuaHTView;
import com.vpdt.vpdt.presenter.impl.DauViecPhongChuTriDaChiDaoChuaHTPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DauViecPhongChuTriDaXuLyPhoPhongPhoiHopFragment extends BaseFragment<DauViecPhongChuTriDaChiDaoChuaHTPresenter> implements DauViecPhongChuTriDaChiDaoChuaHTView,
        AdapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT.OnItemXemFileClickListener,
        AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;
    @BindView(R.id.btnBack)
    Button btnBack;

    String NamLamViec;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;

    AdapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT adapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_dau_viec_phong_chu_tri_da_xu_ly_pho_phong_phoi_hop;
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
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getAllDauViecPhongChuTriDaChiDao(NamLamViec, true);


    }

    @OnClick({R.id.btnNamLamViec, R.id.btnBack, R.id.rlttm, R.id.btnHome})
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
    public void ongetAllDauViecPhongChuTriDaChiDaoSuccess(ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT> danhSachDauViecPhongChuTriDaChiDaoChuaHTArrayList) {
        adapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT = new AdapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT(getActivity(), danhSachDauViecPhongChuTriDaChiDaoChuaHTArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterDanhSachDauViecPhongChuTriDaChiDaoChuaHT);
        if (danhSachDauViecPhongChuTriDaChiDaoChuaHTArrayList.size() == 0) {
            Util.showMessenger("Không có văn bản nào", getActivity());
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllDauViecPhongChuTriDaChiDao(String.valueOf(integer), true);
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }


    @Override
    public DauViecPhongChuTriDaChiDaoChuaHTPresenter createPresenter() {
        return new DauViecPhongChuTriDaChiDaoChuaHTPresenterImpl(this);
    }

    @Override
    public void onItemClickXemFile(DanhSachDauViecPhongChuTriDaChiDaoChuaHT danhSachDauViecPhongChuTriDaChiDaoChuaHT) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(danhSachDauViecPhongChuTriDaChiDaoChuaHT.getUrlFile()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

}
