package com.vpdt.vpdt.ui.activity.VanBanDonViCapHai;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.VanBanChoDuyetLV3;
import com.vpdt.vpdt.presenter.NDVBVanBanChoDuyetLV3Presenter;
import com.vpdt.vpdt.presenter.NDVBVanBanChoDuyetLV3View;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanChoDuyetLV3PresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChoDuyetLV3Activity extends BaseActivity<NDVBVanBanChoDuyetLV3Presenter> implements NDVBVanBanChoDuyetLV3View {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvCanBoChiDao)
    TextView tvCanBoChiDao;
    @BindView(R.id.tvNoiDungChiDao)
    TextView tvNoiDungChiDao;
    @BindView(R.id.tvDiaDiem)
    TextView tvDiaDiem;
    @BindView(R.id.tvFileDinhKemKetQua)
    TextView tvFileDinhKemKetQua;
    @BindView(R.id.tvThoiGian)
    TextView tvThoiGian;
    @BindView(R.id.tvHanVanBan)
    TextView tvHanVanBan;
    @BindView(R.id.rcvChuyenNhan)
    RecyclerView rcvChuyenNhan;

    int id;
    boolean click = false;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbvan_ban_cho_duyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanChoDuyetLV3 vanBanPhoiHopDaChiDao = getIntent().getParcelableExtra("vanBanChoDuyetLV3");
        if (vanBanPhoiHopDaChiDao != null) {
            id = vanBanPhoiHopDaChiDao.getId();
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanPhoiHopDaChiDao.getChuyenNhans());
            tvSKH.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanPhoiHopDaChiDao.getSoDen()));
            tvNoiGui.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiGui()));
            tvNgay.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNgayNhap()));
            tvTrichYeu.setText(String.valueOf(vanBanPhoiHopDaChiDao.getMoTa() + "\n" + vanBanPhoiHopDaChiDao.getNoiDungVanBan()));
            tvCanBoChiDao.setText(String.valueOf("Đ/c hoàn thành: " + vanBanPhoiHopDaChiDao.getCanBoHoanThanh()));
            tvNoiDungChiDao.setText(String.valueOf(vanBanPhoiHopDaChiDao.getNoiDungChiDao()));
            tvHanVanBan.setText(String.valueOf(vanBanPhoiHopDaChiDao.getHanVanBan()));
            if (vanBanPhoiHopDaChiDao.getGiayMoiGio() == null) {
                tvDiaDiem.setVisibility(View.GONE);
            } else {
                tvDiaDiem.setText(String.valueOf("(Vào hồi: "
                        + vanBanPhoiHopDaChiDao.getGiayMoiGio() + " ngày " + vanBanPhoiHopDaChiDao.getGiayMoiNgay() + ", tại "
                        + vanBanPhoiHopDaChiDao.getGiayMoiDiaDiem() + ")"));
            }
            tvThoiGian.setText(String.valueOf("Thời gian: " + vanBanPhoiHopDaChiDao.getThoiGianHoanThanh()));
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopDaChiDao.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChoDuyetLV3Activity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            tvFileDinhKemKetQua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanPhoiHopDaChiDao.getUrlFileKetQua()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChoDuyetLV3Activity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDuyetSuccess() {
        Toast.makeText(this, "Duyệt thành công", Toast.LENGTH_LONG).show();
        finish();
    }

    @OnClick({R.id.imvBack, R.id.btnDuyet, R.id.tvXemChiTiet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDetailVanBanChoXuLyGQActivity.class);
                    intent.putExtra("idvb", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnDuyet:
                getPresenter().duyetVBChoDuyetTPDonViCapHai(PrefUtil.getString(this, Key.NAM_LAM_VIEC, ""), id);
                break;
        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvChuyenNhan.setLayoutManager(linearLayoutManager);
        rcvChuyenNhan.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }

    @Override
    public NDVBVanBanChoDuyetLV3Presenter createPresenter() {
        return new NDVBVanBanChoDuyetLV3PresenterImpl(this);
    }
}