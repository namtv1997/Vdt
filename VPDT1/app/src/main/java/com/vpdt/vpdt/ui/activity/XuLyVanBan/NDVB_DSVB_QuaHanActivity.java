package com.vpdt.vpdt.ui.activity.XuLyVanBan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DSVB_QuaHan;
import com.vpdt.vpdt.model.TrinhTuKy;
import com.vpdt.vpdt.presenter.NDVB_DSVB_QuaHanPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVB_QuaHanView;
import com.vpdt.vpdt.presenter.impl.NDVB_DSVB_QuaHanPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKem;
import com.vpdt.vpdt.ui.adapter.AdapterTrinhTuXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVB_DSVB_QuaHanActivity extends BaseActivity<NDVB_DSVB_QuaHanPresenter> implements NDVB_DSVB_QuaHanView, AdapterFileDinhKem.OnItemClickListener {

    @BindView(R.id.tvSKH)
    TextView skh;
    @BindView(R.id.tvSoDen)
    TextView sodenvang;
    @BindView(R.id.tvNoiGui)
    TextView noigui;
    @BindView(R.id.tvNgay)
    TextView ngay;
    @BindView(R.id.tvLoaiVanBan)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvHanXuLy)
    TextView tvHanXuLy;
    @BindView(R.id.tvNgayKy)
    TextView tvNgayKy;

    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;

    @BindView(R.id.rvFileDinhKem)
    RecyclerView rvFileDinhKem;
    @BindView(R.id.rvTrinhTuXuLy)
    RecyclerView rvTrinhTuXuLy;

    AdapterFileDinhKem adapterFileDinhKem;
    AdapterTrinhTuXuLy adapterTrinhTuXuLy;

    int id;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb__dsvb__qua_han;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBAN_QUAHAN")) {
                id = intent.getIntExtra("ID_VANBAN_QUAHAN", 0);
                getPresenter().getbyidvbquahandolanhdaochidao(id);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @Override
    public Context gContext() {
        return this;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onGetDataSuccess(DSVB_QuaHan dsvb_quaHan) {
        recyclerViewFileDinhKem((ArrayList<String>) dsvb_quaHan.getTaiLieus());
        recyclerTrinhTuXuLy((ArrayList<TrinhTuKy>) dsvb_quaHan.getTrinhTuKys());

        String shortdate = dsvb_quaHan.getNgayNhap();
        ngay.setText(shortdate.substring(0, 5));
        noigui.setText(dsvb_quaHan.getNoiGui());
        tvLoaiVanban.setText(dsvb_quaHan.getLoaiVanban());
        tvTrichYeu.setText(dsvb_quaHan.getTrichYeu());
        skh.setText(String.valueOf(dsvb_quaHan.getSoKyHieu()));
        sodenvang.setText(String.valueOf(dsvb_quaHan.getSoDen()));
        tvHanXuLy.setText(String.valueOf(dsvb_quaHan.getHanXuLy()));
        tvNgayKy.setText(String.valueOf(dsvb_quaHan.getNgayKy()));
    }

    @Override
    public void themHanGiaiQuyetVBQuaHan() {

    }

    @Override
    public void tuChoiHanGiaiQuyetVBQuaHan() {

    }

    @Override
    public void tuChoiTPVBQuaHan() {

    }

    @Override
    public NDVB_DSVB_QuaHanPresenter createPresenter() {
        return new NDVB_DSVB_QuaHanPresenterImpl(this);
    }

    @OnClick({R.id.imvBack, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(NDVB_DSVB_QuaHanActivity.this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                    intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", id);
                    startActivity(intent);
                    click = true;
                }
                break;
        }
    }

    @Override
    public void onItemClickFileDinhKem(String dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }

    }

    void recyclerViewFileDinhKem(ArrayList<String> strings) {
        adapterFileDinhKem = new AdapterFileDinhKem(this, strings, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKem);
        adapterFileDinhKem.notifyDataSetChanged();
    }

    void recyclerTrinhTuXuLy(ArrayList<TrinhTuKy> trinhTuKyArrayList) {
        adapterTrinhTuXuLy = new AdapterTrinhTuXuLy(this, trinhTuKyArrayList);
        LinearLayoutManager layoutManagerTrinhTuXuLy = new LinearLayoutManager(this);
        layoutManagerTrinhTuXuLy.setOrientation(LinearLayoutManager.VERTICAL);
        rvTrinhTuXuLy.setLayoutManager(layoutManagerTrinhTuXuLy);
        rvTrinhTuXuLy.setAdapter(adapterTrinhTuXuLy);
        adapterTrinhTuXuLy.notifyDataSetChanged();
    }

}
