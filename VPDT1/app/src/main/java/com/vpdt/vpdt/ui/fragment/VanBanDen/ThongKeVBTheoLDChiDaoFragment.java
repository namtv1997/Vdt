package com.vpdt.vpdt.ui.fragment.VanBanDen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseFragment;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDao;
import com.vpdt.vpdt.model.ThongKeLanhDaoChiDaoTheoPhong;
import com.vpdt.vpdt.presenter.ThongKeVBTheoLDChiDaoPresenter;
import com.vpdt.vpdt.presenter.ThongKeVBTheoLDChiDaoView;
import com.vpdt.vpdt.presenter.impl.ThongKeVBTheoLDChiDaoPresenterImpl;
import com.vpdt.vpdt.ui.activity.MainActivity;
import com.vpdt.vpdt.ui.activity.VanBanDen.ClickThongKeVBTheoLDChiDaoActivity;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaTenPhoGiamDoc;
import com.vpdt.vpdt.ui.adapter.AdapterKetQuaTenPhongBan;
import com.vpdt.vpdt.ui.adapter.AdapterNamLamViec;
import com.vpdt.vpdt.ui.adapter.AdapterTenPhoGiamDoc;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThongKeVBTheoLDChiDaoFragment extends BaseFragment<ThongKeVBTheoLDChiDaoPresenter> implements ThongKeVBTheoLDChiDaoView,
        AdapterTenPhoGiamDoc.OnItemClickListenerTenPhoGiamDoc,
        AdapterKetQuaTenPhoGiamDoc.OnItemClickListenerKetQuaTenPhoGiamDoc,
        AdapterKetQuaTenPhongBan.OnItemClickListenerKetQuaTenPhongBan, AdapterNamLamViec.OnItemClickListenerNamLamViec {

    @BindView(R.id.btnNamLamViec)
    Button btnNamLamViec;

    @BindView(R.id.TenVB)
    TextView TenVB;

    @BindView(R.id.rvPhongBan)
    RecyclerView rvPhongBan;
    @BindView(R.id.rvGiamDoc)
    RecyclerView rvGiamDoc;

    @BindView(R.id.lnPhoGiamDoc)
    LinearLayout lnPhoGiamDoc;
    int idPhoGiamDoc;
    boolean isClick = false;

    RecyclerView rvSelectPgD;
    TextView tvPhoGiamDoc;
    String NamLamViec;
    AlertDialog dialog;
    AlertDialog dialog1;
    AdapterTenPhoGiamDoc adapterTenPhoGiamDoc;
    AdapterKetQuaTenPhoGiamDoc adapterKetQuaTenPhoGiamDoc;
    AdapterKetQuaTenPhongBan adapterKetQuaTenPhongBan;

    RecyclerView rvSelectNam;
    AdapterNamLamViec adapterNamLamViec;
    ArrayList<Integer> integerArrayList = new ArrayList<>();
    int year;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_thong_ke_vb_theo_ld_chi_dao;
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
        NamLamViec = PrefUtil.getString(getContext(), Key.NAM_LAM_VIEC, "");
        btnNamLamViec.setText("Năm làm việc: " + NamLamViec + " ");
        year = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2017; i <= year; i++) {
            integerArrayList.add(i);
            adapterNamLamViec = new AdapterNamLamViec(getActivity(), integerArrayList, this);
        }
        getPresenter().getsoluongvb_Theo_PGD(NamLamViec);
        getPresenter().getsoluongvb_Theo_Phongban(NamLamViec);
    }

    @OnClick({R.id.btnBack, R.id.btnSearch, R.id.TenVB, R.id.rlThongke, R.id.btnNamLamViec, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                startActivity(MainActivity.getCallingIntent(getActivity()));
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btnSearch:
                if (isClick) {
                    if (TenVB.getText() == "--Chọn phó giám đốc -- ") {
                        getPresenter().getsoluongvb_Theo_PGD(NamLamViec);
                        lnPhoGiamDoc.setVisibility(View.VISIBLE);
                    } else {
                        getPresenter().getsoluongvb_Theo_PGD_select(String.valueOf(idPhoGiamDoc), NamLamViec);
                        lnPhoGiamDoc.setVisibility(View.GONE);
                    }
                } else {
                    lnPhoGiamDoc.setVisibility(View.VISIBLE);
                    getPresenter().getsoluongvb_Theo_PGD(NamLamViec);
                }
                break;
            case R.id.TenVB:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view1 = inflater.inflate(R.layout.recyclerview_pho_giam_doc_selected, null);
                builder.setView(view1);
                dialog = builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvSelectPgD = view1.findViewById(R.id.rvSelectPgD);
                rvSelectPgD.setLayoutManager(layoutManager);
                rvSelectPgD.setAdapter(adapterTenPhoGiamDoc);
                adapterTenPhoGiamDoc.notifyDataSetChanged();

                tvPhoGiamDoc = view1.findViewById(R.id.tvPhoGiamDoc);
                tvPhoGiamDoc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TenVB.setText("-- Chọn phó giám đốc --");
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.btnNamLamViec:
                android.support.v7.app.AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater1 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewNamLamViec = inflater1.inflate(R.layout.recyclerview_nam_selected, null);
                builder1.setView(viewNamLamViec);
                dialog1 = builder1.create();
                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
                layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvSelectNam = viewNamLamViec.findViewById(R.id.rvSelectNam);
                rvSelectNam.setLayoutManager(layoutManager1);
                rvSelectNam.setAdapter(adapterNamLamViec);
                adapterNamLamViec.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        integerArrayList.clear();
    }

    @Override
    public void onItemClickNamLamViec(Integer integer) {
        btnNamLamViec.setText("Năm làm việc: " + integer + " ");
        PrefUtil.saveString(getActivity(), Key.NAM_LAM_VIEC, String.valueOf(integer));
        NamLamViec = String.valueOf(integer);
        dialog1.dismiss();
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void getsoluongvb_Theo_PGDSuccess(ArrayList<ThongKeLanhDaoChiDao> thongKeLanhDaoChiDaos) {
        adapterTenPhoGiamDoc = new AdapterTenPhoGiamDoc(getContext(), thongKeLanhDaoChiDaos, this);
        adapterKetQuaTenPhoGiamDoc = new AdapterKetQuaTenPhoGiamDoc(getContext(), thongKeLanhDaoChiDaos, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGiamDoc.setLayoutManager(layoutManager);
        rvGiamDoc.setAdapter(adapterKetQuaTenPhoGiamDoc);
        adapterKetQuaTenPhoGiamDoc.notifyDataSetChanged();
    }

    @Override
    public void getsoluongvb_Theo_PGDSelectSuccess(ArrayList<ThongKeLanhDaoChiDao> thongKeLanhDaoChiDaos) {
        adapterKetQuaTenPhoGiamDoc = new AdapterKetQuaTenPhoGiamDoc(getContext(), thongKeLanhDaoChiDaos, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGiamDoc.setLayoutManager(layoutManager);
        rvGiamDoc.setAdapter(adapterKetQuaTenPhoGiamDoc);
        adapterKetQuaTenPhoGiamDoc.notifyDataSetChanged();
    }

    @Override
    public void getsoluongvb_Theo_PhongbanSuccess(ArrayList<ThongKeLanhDaoChiDaoTheoPhong> thongKeLanhDaoChiDaoTheoPhongs) {
        adapterKetQuaTenPhongBan = new AdapterKetQuaTenPhongBan(getContext(), thongKeLanhDaoChiDaoTheoPhongs, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPhongBan.setLayoutManager(layoutManager);
        rvPhongBan.setAdapter(adapterKetQuaTenPhongBan);
        adapterKetQuaTenPhongBan.notifyDataSetChanged();
    }

    @Override
    public ThongKeVBTheoLDChiDaoPresenter createPresenter() {
        return new ThongKeVBTheoLDChiDaoPresenterImpl(this);
    }

    @Override
    public void onItemClickTenPhoGiamDoc(ThongKeLanhDaoChiDao thongKeLanhDaoChiDao) {
        isClick = true;
        idPhoGiamDoc = thongKeLanhDaoChiDao.getMaPhoGD();
        TenVB.setText(String.valueOf(thongKeLanhDaoChiDao.getPhoGD()));
        dialog.dismiss();
    }

    @Override
    public void onItemClickKetQuaTenPhoGiamDoc(ThongKeLanhDaoChiDao thongKeLanhDaoChiDao) {
        Intent i = new Intent(getContext(), ClickThongKeVBTheoLDChiDaoActivity.class);
        i.putExtra("ThongKeLanhDaoChiDao", thongKeLanhDaoChiDao.getMaPhoGD());
        startActivity(i);
    }

    @Override
    public void onItemClickKetQuaTenPhongBan(ThongKeLanhDaoChiDaoTheoPhong thongKeLanhDaoChiDao) {
        Intent i = new Intent(getContext(), ClickThongKeVBTheoLDChiDaoActivity.class);
        i.putExtra("ThongKeLanhDaoChiDaoTheoPhong", thongKeLanhDaoChiDao.getMaPb());
        startActivity(i);
    }
}