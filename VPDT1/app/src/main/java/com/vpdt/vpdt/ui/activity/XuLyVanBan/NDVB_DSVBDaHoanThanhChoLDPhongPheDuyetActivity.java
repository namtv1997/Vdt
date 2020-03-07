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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.Key;
import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.VanBanHoanThanhChoLanhDaoPhongPheDuyet;
import com.vpdt.vpdt.presenter.NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter;
import com.vpdt.vpdt.presenter.NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetView;
import com.vpdt.vpdt.presenter.impl.NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterDeXuatGiaHanChoXuLy;
import com.vpdt.vpdt.util.PrefUtil;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity extends BaseActivity<NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter> implements NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetView {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSKH;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvNoigui)
    TextView tvNoigui;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvHanGiaiQuyet)
    TextView tvHanGiaiQuyet;
    @BindView(R.id.tvTenNguoiHoanThanh)
    TextView tvTenNguoiHoanThanh;
    @BindView(R.id.tvmoTaHoanThanh)
    TextView tvmoTaHoanThanh;
    @BindView(R.id.tvVanBan)
    TextView tvVanBan;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvCanBoPheduyet)
    TextView tvCanBoPheduyet;

    @BindView(R.id.cbCoSangTao)
    CheckBox cbCoSangTao;
    @BindView(R.id.cbVBCoVanBanTraLoi)
    CheckBox cbVBCoVanBanTraLoi;
    @BindView(R.id.cbVanBanChiDeLuuKho)
    CheckBox cbVanBanChiDeLuuKho;

    @BindView(R.id.rvYkien)
    RecyclerView rvYkien;
    boolean vBCoDauRa;
    int idvb, level;
    String idNguoiHoanThanh;
    EditText edtNoiDungTuChoi;
    AlertDialog dialog;
    boolean click = false;
    AdapterDeXuatGiaHanChoXuLy adapterDeXuatGiaHanChoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb_dsvbda_hoan_thanh_cho_ldphong_phe_duyet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        level = PrefUtil.getInt(this, Key.LEVEL, 0);
        if (level == 7) {
            cbVBCoVanBanTraLoi.setText("VB chỉ để lưu kho");
        }
        VanBanHoanThanhChoLanhDaoPhongPheDuyet vanBanHoanThanhChoLanhDaoPhongPheDuyet = getIntent().getParcelableExtra("vanBanHoanThanhChoLanhDaoPhongPheDuyet");
        if (vanBanHoanThanhChoLanhDaoPhongPheDuyet != null) {
            recyclerviewTrinhTuChuyenNhan((ArrayList<String>) vanBanHoanThanhChoLanhDaoPhongPheDuyet.getTrinhTuXuLy());
            vBCoDauRa = vanBanHoanThanhChoLanhDaoPhongPheDuyet.getVBCoDauRa();
            if (vanBanHoanThanhChoLanhDaoPhongPheDuyet.getVBCoDauRa()) {
                cbVBCoVanBanTraLoi.setChecked(true);
            }
            if (vanBanHoanThanhChoLanhDaoPhongPheDuyet.getLuuVaoKho()) {
                cbVanBanChiDeLuuKho.setChecked(true);
            }
            if (vanBanHoanThanhChoLanhDaoPhongPheDuyet.getCoSangTao()) {
                cbCoSangTao.setChecked(true);
            }
            idvb = vanBanHoanThanhChoLanhDaoPhongPheDuyet.getId();
            idNguoiHoanThanh = vanBanHoanThanhChoLanhDaoPhongPheDuyet.getIdNguoiHoanThanh();
            tvNgay.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getNgayNhap()));
            tvCanBoPheduyet.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getCanBoPheDuyet()));
            tvSKH.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getSoKyHieu()));
            tvSoDen.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getSoDen()));
            tvNoigui.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getNoiGui()));
            tvTrichYeu.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getMoTa()));
            tvTenNguoiHoanThanh.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getTenNguoiHoanThanh()));
            tvmoTaHoanThanh.setText(String.valueOf(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getMoTaHoanThanh()));
            if (vanBanHoanThanhChoLanhDaoPhongPheDuyet.getVBCoDauRa()) {
                tvVanBan.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanHoanThanhChoLanhDaoPhongPheDuyet.getUrlFile()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack, R.id.btnTuChoi, R.id.btnDuyet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVB_DSVBDaHoanThanhChoLDPhongPheDuyetActivity.class);
                    intent.putExtra("id_vb", idvb);
                    startActivity(intent);
                    click = true;
                }

                break;
            case R.id.btnBack:
                finish();

                break;
            case R.id.btnTuChoi:
                AlertDialog.Builder buildertuchoi = new AlertDialog.Builder(this);
                LayoutInflater inflatertuchoi = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View viewtuchoi = inflatertuchoi.inflate(R.layout.dialog_tuchoi_ketquahoanthanh_cho_phe_duyet, null);
                buildertuchoi.setView(viewtuchoi);
                dialog = buildertuchoi.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                edtNoiDungTuChoi = viewtuchoi.findViewById(R.id.edtNoiDungTuChoi);
                Button btnDong1 = viewtuchoi.findViewById(R.id.btnDong);
                Button btnChuyenChanhVanBan = viewtuchoi.findViewById(R.id.btnChuyenChanhVanBan);
                btnDong1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                btnChuyenChanhVanBan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().tuChoiKetQuaHoanThanhChoLDPheDuyet(idvb, edtNoiDungTuChoi.getText().toString(), idNguoiHoanThanh);
                    }
                });
                dialog.show();
                break;
            case R.id.btnDuyet:

                if (cbCoSangTao.isChecked() && cbVBCoVanBanTraLoi.isChecked()) {
                    getPresenter().duyetVBDaHoanThanhChoLDPheDuyet(idvb, vBCoDauRa, true);
                } else if (cbVBCoVanBanTraLoi.isChecked()) {
                    getPresenter().duyetVBDaHoanThanhChoLDPheDuyet(idvb, vBCoDauRa, true);
                } else if (cbCoSangTao.isChecked()) {
                    getPresenter().duyetVBDaHoanThanhChoLDPheDuyet(idvb, vBCoDauRa, true);
                } else {
                    getPresenter().duyetVBDaHoanThanhChoLDPheDuyet(idvb, vBCoDauRa, false);
                }
                break;

        }
    }

    void recyclerviewTrinhTuChuyenNhan(ArrayList<String> stringArrayList) {
        adapterDeXuatGiaHanChoXuLy = new AdapterDeXuatGiaHanChoXuLy(stringArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvYkien.setLayoutManager(linearLayoutManager);
        rvYkien.setAdapter(adapterDeXuatGiaHanChoXuLy);
        adapterDeXuatGiaHanChoXuLy.notifyDataSetChanged();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void duyetVanBanSuccess() {
        Toast.makeText(this, "xong", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void tuChoiVBDaHoanThanhChoLDPhongPheDuyetSuccess() {
        Toast.makeText(this, "xong", Toast.LENGTH_SHORT).show();
        finish();
    }


    @Override
    public NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenter createPresenter() {
        return new NDVB_DSVBDaHoanThanhChoLDPhongPheDuyetPresenterImpl(this);
    }
}
