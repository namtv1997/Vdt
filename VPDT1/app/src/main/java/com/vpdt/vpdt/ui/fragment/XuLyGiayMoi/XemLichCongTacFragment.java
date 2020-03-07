package com.vpdt.vpdt.ui.fragment.XuLyGiayMoi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.vpdt.vpdt.model.GiamdocVaPhoGiamdoc;
import com.vpdt.vpdt.model.LichCongTac;
import com.vpdt.vpdt.presenter.XemLichCongTacPresenter;
import com.vpdt.vpdt.presenter.XemLichCongTacView;
import com.vpdt.vpdt.presenter.impl.XemLichCongTacPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterTenGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterTuan;
import com.vpdt.vpdt.ui.adapter.AdapterXemLichCongTac;
import com.vpdt.vpdt.ui.fragment.VanBanDi.LichHopCuaSoChuTriFragment;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XemLichCongTacFragment extends BaseFragment<XemLichCongTacPresenter> implements XemLichCongTacView,
        AdapterTuan.OnItemClickListener, AdapterNamLamViec.OnItemClickListenerNamLamViec,
        AdapterTenGiamDoc.OnItemClickListener {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.tvTuan)
    TextView tvTuan;
    @BindView(R.id.tvTenLanhDao)
    TextView tvTenLanhDao;

    @BindView(R.id.rcvThu)
    RecyclerView rcvThu;

    AdapterTuan adapterTuan;
    RecyclerView rvTuan;
    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    AdapterXemLichCongTac adapterXemLichCongTac;
    private AdapterTenGiamDoc adapterTenGiamDoc;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    AlertDialog dialog;
    int year, week;
    String NamLamViec;
    RecyclerView rcTenGiamDoc;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_xem_lich_cong_tac;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Util.checkConnection(getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().getlistCB_lanhdao();
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        tvTuan.setText("Tuần: " + week);
        tvTenLanhDao.setText("--Chọn lãnh đạo --");
        getPresenter().getLichCongTac(week, NamLamViec, 0);
        getPresenter().getAllTuan(NamLamViec);
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
    public void ongetlistCB_lanhdaocSuccess(ArrayList<GiamdocVaPhoGiamdoc> giamdocVaPhoGiamdoc) {
        adapterTenGiamDoc = new AdapterTenGiamDoc(getActivity(), giamdocVaPhoGiamdoc, this);
    }

    @OnClick({R.id.btnBack, R.id.btnNamLamViec, R.id.tvTuan, R.id.btnLichHopCuaSoChuTri, R.id.tvTenLanhDao, R.id.rlxlct, R.id.vxlct, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.tvTenLanhDao:
                AlertDialog.Builder builderTenLanhDao = new AlertDialog.Builder(getActivity());
                LayoutInflater inflaterTenLanhDao = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewTenLanhDao = inflaterTenLanhDao.inflate(R.layout.dialog_ten_giam_doc, null);
                builderTenLanhDao.setView(viewTenLanhDao);
                dialog = builderTenLanhDao.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                LinearLayoutManager layoutManagerviewTenLanhDao = new LinearLayoutManager(getActivity());
                layoutManagerviewTenLanhDao.setOrientation(LinearLayoutManager.VERTICAL);

                rcTenGiamDoc = viewTenLanhDao.findViewById(R.id.rcTenGiamDoc);
                rcTenGiamDoc.setLayoutManager(layoutManagerviewTenLanhDao);
                rcTenGiamDoc.setAdapter(adapterTenGiamDoc);
                adapterTenGiamDoc.notifyDataSetChanged();

                dialog.show();
                TextView btnChuyenPGiamDoc = viewTenLanhDao.findViewById(R.id.btnChuyenPGiamDoc);
                btnChuyenPGiamDoc.setText("--Chọn lãnh đạo --");
                btnChuyenPGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
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
                dialog = builder.create();
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
                layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                rvTuan = viewTuan.findViewById(R.id.rcTuan);
                rvTuan.setLayoutManager(layoutManager1);
                rvTuan.setAdapter(adapterTuan);
                adapterTuan.notifyDataSetChanged();

                dialog.show();
                break;

            case R.id.btnLichHopCuaSoChuTri:
                LichHopCuaSoChuTriFragment fragment2 = new LichHopCuaSoChuTriFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (Objects.requireNonNull(this.getActivity()).getClass().getSimpleName().equals("XuLyGiayMoiActivity")) {
                    fragmentTransaction.replace(R.id.fl, fragment2);
                } else {
                    fragmentTransaction.replace(R.id.fl, fragment2);
                }
                fragmentTransaction.addToBackStack("LichHopCuaSoChuTriFragment");
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onGetTuanSuccess(ArrayList<String> stringArrayList) {
        adapterTuan = new AdapterTuan(getActivity(), stringArrayList, this);
    }

    @Override
    public void onGetLichCongTacSuccess(ArrayList<LichCongTac> lichCongTacArrayList) {
        adapterXemLichCongTac = new AdapterXemLichCongTac(getActivity(), lichCongTacArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvThu.setLayoutManager(layoutManager);
        rcvThu.setAdapter(adapterXemLichCongTac);
        adapterXemLichCongTac.notifyDataSetChanged();
    }

    @Override
    public XemLichCongTacPresenter createPresenter() {
        return new XemLichCongTacPresenterImpl(this);
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        getPresenter().getAllTuan(String.valueOf(integer));
        PrefUtil.saveString(Objects.requireNonNull(getActivity()), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog.dismiss();
    }

    @Override
    public void onItemClick(String s, int position) {
        week = (position + 1);
        tvTuan.setText("Tuần: " + (position + 1) + " ( " + s + " )");
        dialog.dismiss();
    }

    @Override
    public void onItemClick(GiamdocVaPhoGiamdoc giamdocVaPhoGiamdoc) {
        getPresenter().getLichCongTac(week, NamLamViec, giamdocVaPhoGiamdoc.getId());
        tvTenLanhDao.setText(String.valueOf(giamdocVaPhoGiamdoc.getHoTen()));
        dialog.dismiss();
    }
}
