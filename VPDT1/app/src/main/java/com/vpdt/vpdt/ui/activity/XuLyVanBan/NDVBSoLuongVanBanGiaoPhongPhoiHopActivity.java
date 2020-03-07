package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.SoLuongVanBanGiaoPhongPhoiHop;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongPhoiHopPresenter;
import com.vpdt.vpdt.presenter.SoLuongVanBanGiaoPhongPhoiHopView;
import com.vpdt.vpdt.presenter.impl.SoLuongVanBanGiaoPhongPhoiHopPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBSoLuongVanBanGiaoPhongPhoiHopActivity extends BaseActivity<SoLuongVanBanGiaoPhongPhoiHopPresenter> implements SoLuongVanBanGiaoPhongPhoiHopView {

    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoiGui)
    TextView tvNoiGui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNgayGio)
    TextView tvNgayGio;
    @BindView(R.id.tvSoTrang)
    TextView tvSoTrang;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvXemChiTietNDVBDSVBDenChoLDXL)
    TextView tvXemChiTietNDVBDSVBDenChoLDXL;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;

    @BindView(R.id.btnBack)
    ImageView btnBack;

    @BindView(R.id.btnTuChoiVeTP)
    Button btnTuChoiVeTP;

    @BindView(R.id.rcvTTXL)
    RecyclerView rcvTTXL;
    AlertDialog dialog;
    EditText edtNoiDungTuChoi;
    boolean click = false;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;
    int idvb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbso_luong_van_ban_giao_phong_phoi_hop;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);

        SoLuongVanBanGiaoPhongPhoiHop soLuongVanBanGiaoPhongPhoiHop = getIntent().getParcelableExtra("soLuongVanBanGiaoPhongPhoiHop");
        if (soLuongVanBanGiaoPhongPhoiHop != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) soLuongVanBanGiaoPhongPhoiHop.getTrinhTuXuLy());
            idvb = soLuongVanBanGiaoPhongPhoiHop.getId();
            tvNgay.setText(String.valueOf(soLuongVanBanGiaoPhongPhoiHop.getNgayNhap()));
            tvSKH.setText(String.valueOf(soLuongVanBanGiaoPhongPhoiHop.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(soLuongVanBanGiaoPhongPhoiHop.getSoDen()));
            tvNoiGui.setText(String.valueOf(soLuongVanBanGiaoPhongPhoiHop.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(soLuongVanBanGiaoPhongPhoiHop.getMoTa()));
            tvLoaiVanban.setText(String.valueOf(soLuongVanBanGiaoPhongPhoiHop.getLoaiVanBan()));
            if (soLuongVanBanGiaoPhongPhoiHop.getAllowTuChoi() == true) {
                btnTuChoiVeTP.setVisibility(View.VISIBLE);
            }
            if (!soLuongVanBanGiaoPhongPhoiHop.getGiayMoiGio().isEmpty() && !soLuongVanBanGiaoPhongPhoiHop.getGiayMoiNgay().isEmpty() && !soLuongVanBanGiaoPhongPhoiHop.getGiayMoiDiaDiem().isEmpty()) {
                tvNgayGio.setText("( Vào hồi " + soLuongVanBanGiaoPhongPhoiHop.getGiayMoiGio() + " ngày " + soLuongVanBanGiaoPhongPhoiHop.getGiayMoiNgay() + ", tại" + soLuongVanBanGiaoPhongPhoiHop.getGiayMoiDiaDiem() + ")");
                tvXemChiTietNDVBDSVBDenChoLDXL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(NDVBSoLuongVanBanGiaoPhongPhoiHopActivity.this, TTVBSoLuongVanBanGiaoPhongPhoiHop1Activity.class);
                        intent.putExtra("idvb", idvb);
                        startActivity(intent);
                    }
                });
            } else {
                tvXemChiTietNDVBDSVBDenChoLDXL.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!click) {
                            Intent intent = new Intent(NDVBSoLuongVanBanGiaoPhongPhoiHopActivity.this, TTVBVanBanPhoiHopDaChiDaoActivity.class);
                            intent.putExtra("idvb", idvb);
                            startActivity(intent);
                            click = true;
                        }

                    }
                });
            }
            tvSoTrang.setText("( Số trang :" + soLuongVanBanGiaoPhongPhoiHop.getSoTrang() + ")" + soLuongVanBanGiaoPhongPhoiHop.getTenLanhDao());
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(soLuongVanBanGiaoPhongPhoiHop.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBSoLuongVanBanGiaoPhongPhoiHopActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnTuChoiVeTP})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnTuChoiVeTP:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                buildertuchoi.setCancelable(false);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnChuyenChanhVanBan.setText("Chuyển về trưởng phòng");
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiVBPhongPhoiHop(idvb, edtNoiDungTuChoi.getText().toString());
                    }
                });
                dialog.show();
                break;
        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvTTXL.setLayoutManager(linearLayoutManager);
        rcvTTXL.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess() {

    }

    @Override
    public void onGetCountVBSuccess(Response<Integer> response) {

    }

    @Override
    public void onTuChoiSuccess() {
        Toast.makeText(this, "Đã từ chối", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public SoLuongVanBanGiaoPhongPhoiHopPresenter createPresenter() {
        return new SoLuongVanBanGiaoPhongPhoiHopPresenterImpl(this);
    }
}
