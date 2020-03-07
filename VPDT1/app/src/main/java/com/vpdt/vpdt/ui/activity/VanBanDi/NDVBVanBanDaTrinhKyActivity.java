package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.Noinhan;
import com.vpdt.vpdt.model.VanBanDaTrinhKy;
import com.vpdt.vpdt.presenter.NDVBVanBanDaTrinhKyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanDaTrinhKyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanDaTrinhKyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterNoiNhanCuaSo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanDaTrinhKyActivity extends BaseActivity<NDVBVanBanDaTrinhKyPresenter> implements NDVBVanBanDaTrinhKyView {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvKyHieu)
    TextView tvKyHieu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvChuaCapSo)
    TextView tvChuaCapSo;
    @BindView(R.id.tvDaCapSo)
    TextView tvDaCapSo;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;

    @BindView(R.id.btnXoaDuLieu)
    Button btnXoaDuLieu;

    @BindView(R.id.rvNoiNhan)
    RecyclerView rvNoiNhan;
    int id;
    AdapterNoiNhanCuaSo adapterNoiNhanCuaSo;

    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_da_trinh_ky;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanDaTrinhKy vanBanDaTrinhKy = getIntent().getParcelableExtra("vanBanDaTrinhKy");
        if (vanBanDaTrinhKy != null) {
            RecyclerviewNoiNhanCuaSo((ArrayList<Noinhan>) vanBanDaTrinhKy.getNoinhan());
            String shortDate = vanBanDaTrinhKy.getNgaynhap();
            id = vanBanDaTrinhKy.getMavb();
            tvNgay.setText(String.valueOf(shortDate.substring(0, 5)));
            tvKyHieu.setText(String.valueOf(vanBanDaTrinhKy.getKyhieu()));
            tvTrichYeu.setText(String.valueOf(vanBanDaTrinhKy.getTrichyeu()));
            tvNguoiNhap.setText(String.valueOf(vanBanDaTrinhKy.getNguoinhap()));
            if (vanBanDaTrinhKy.getHienXoa() == 1) {
                btnXoaDuLieu.setVisibility(View.VISIBLE);
            }
            if (vanBanDaTrinhKy.getSodi() > 0) {
                tvDaCapSo.setVisibility(View.VISIBLE);
            } else {
                tvChuaCapSo.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDaTrinhKy.getDuongdan()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanDaTrinhKyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVB_DanhSachVanBanCuaPhongActivity.class);
                    intent.putExtra("dsvbCuaPhong", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnXoaDuLieu:
                getPresenter().xoavb_trinhky(id);
                break;
        }
    }

    void RecyclerviewNoiNhanCuaSo(ArrayList<Noinhan> noinhanArrayList) {
        adapterNoiNhanCuaSo = new AdapterNoiNhanCuaSo(this, (ArrayList<Noinhan>) noinhanArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvNoiNhan.setLayoutManager(linearLayoutManager);
        rvNoiNhan.setAdapter(adapterNoiNhanCuaSo);
        adapterNoiNhanCuaSo.notifyDataSetChanged();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onXoaDuLieuSuccess() {
        Toast.makeText(this, "Xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public NDVBVanBanDaTrinhKyPresenter createPresenter() {
        return new NDVBVanBanDaTrinhKyPresenterImpl(this);
    }
}
