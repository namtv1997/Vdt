package com.vpdt.vpdt.ui.fragment.QuanLyCanBo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.vpdt.vpdt.model.NhanXetChamDiemCongViecTuanCuaCapDuoi;
import com.vpdt.vpdt.presenter.NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter;
import com.vpdt.vpdt.presenter.NhanXetChamDiemCongViecTuanCuaCapDuoiView;
import com.vpdt.vpdt.presenter.impl.NhanXetChamDiemCongViecTuanCuaCapDuoiPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi;
import com.vpdt.vpdt.ui.adapter.AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi1;
import com.vpdt.vpdt.ui.adapter.AdapterTuan;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NhanXetChamDiemCongViecTuanCuaCapDuoiFragment extends BaseFragment<NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter>
        implements NhanXetChamDiemCongViecTuanCuaCapDuoiView, AdapterTuan.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec,
        AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi.OnItemClickListener, AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi1.OnItemClickListener {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvTuan)
    TextView tvTuan;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;

    String NamLamViec;

    AlertDialog dialogTuan;

    AdapterTuan adapterTuan;
    AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi adapterNhanXetChamDiemCongViecTuanCuaCapDuoi;
    AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi1 adapterNhanXetChamDiemCongViecTuanCuaCapDuoi1;

    RecyclerView rvTuan;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year;
    int idphong = 0;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_nhan_xet_cham_diem_cong_viec_tuan_cua_cap_duoi;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());

    }

    @Override
    public void onStart() {
        super.onStart();
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        getPresenter().getAllTuan(NamLamViec);
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
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

    @OnClick({R.id.btnBack, R.id.btnNamLamViec, R.id.tvTuan, R.id.rlXKHCTT, R.id.vKHKQCTT, R.id.btnHome})
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
            case R.id.tvTuan:
                builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaterTuan = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewTuan = inflaterTuan.inflate(R.layout.dialog_tuan, null);
                builder.setView(viewTuan);
                dialogTuan = builder.create();
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                Objects.requireNonNull(dialogTuan.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                rvTuan = viewTuan.findViewById(R.id.rcTuan);
                rvTuan.setLayoutManager(layoutManager1);
                rvTuan.setAdapter(adapterTuan);
                adapterTuan.notifyDataSetChanged();

                dialogTuan.show();
                break;
        }
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllTuan(String.valueOf(integer));
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onGetTuanSuccess(ArrayList<String> stringArrayList) {
        adapterTuan = new AdapterTuan(getActivity(), stringArrayList, this);
    }

    @Override
    public void onGetKeHoachCongTacTuanSuccess(ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi> nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList) {
        adapterNhanXetChamDiemCongViecTuanCuaCapDuoi = new AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi(getActivity(), nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapterNhanXetChamDiemCongViecTuanCuaCapDuoi);
        adapterNhanXetChamDiemCongViecTuanCuaCapDuoi.notifyDataSetChanged();
    }

    @Override
    public void onGetKeHoachCongTacTuan1Success(ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi> nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList1) {
        adapterNhanXetChamDiemCongViecTuanCuaCapDuoi1 = new AdapterNhanXetChamDiemCongViecTuanCuaCapDuoi1(getActivity(), nhanXetChamDiemCongViecTuanCuaCapDuoiArrayList1, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview1.setLayoutManager(layoutManager);
        recyclerview1.setAdapter(adapterNhanXetChamDiemCongViecTuanCuaCapDuoi1);
        adapterNhanXetChamDiemCongViecTuanCuaCapDuoi1.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(String s, int position) {
        tvTuan.setText("Tuần: " + (position + 1) + " (" + s + ")");
        getPresenter().getDanhSachCB_CTtuan(NamLamViec, position + 1, idphong);
        getPresenter().getDanhSachChuyenVien_CTtuan(NamLamViec, position + 1, idphong);
        dialogTuan.dismiss();
    }

    @Override
    public NhanXetChamDiemCongViecTuanCuaCapDuoiPresenter createPresenter() {
        return new NhanXetChamDiemCongViecTuanCuaCapDuoiPresenterImpl(this);
    }

    @Override
    public void onItemClickPhongBan(NhanXetChamDiemCongViecTuanCuaCapDuoi nhanXetChamDiemCongViecTuanCuaCapDuoi) {

    }
}