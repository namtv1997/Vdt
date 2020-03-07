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
import com.vpdt.vpdt.model.Response;
import com.vpdt.vpdt.model.VanBanDiDaXuly;
import com.vpdt.vpdt.presenter.VanBanChuTriDaXuLyPresenter;
import com.vpdt.vpdt.presenter.VanBanChuTriDaXuLyView;
import com.vpdt.vpdt.presenter.impl.VanBanChuTriDaXuLyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterNoiNhanCuaSo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBVanBanChuTriDaXuLyActivity extends BaseActivity<VanBanChuTriDaXuLyPresenter> implements VanBanChuTriDaXuLyView {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvKyHieu)
    TextView tvKyHieu;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.tvNgayNhap)
    TextView tvNgayNhap;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvSodi)
    TextView tvSodi;
    @BindView(R.id.tvFileDinhKem)
    TextView tvFileDinhKem;
    @BindView(R.id.tvChuaCapSo)
    TextView tvChuaCapSo;
    @BindView(R.id.tvDaCapSo)
    TextView tvDaCapSo;
    @BindView(R.id.tvXemChiTiet)
    TextView tvXemChiTiet;
    int id;

    @BindView(R.id.btnXoaDuLieu)
    Button btnXoaDuLieu;

    @BindView(R.id.rvNoiNhan)
    RecyclerView rvNoiNhan;
    AdapterNoiNhanCuaSo adapterNoiNhanCuaSo;
    boolean click = false;

    @Override
    public int getContentViewId() {
        return R.layout.activity_noi_dung_van_ban_chu_tri_da_xu_ly;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        VanBanDiDaXuly vanBanDiDaXuly = getIntent().getParcelableExtra("vanBanDiDaXuly");
        if (vanBanDiDaXuly != null) {
            id = vanBanDiDaXuly.getMavb();
            String shortDate = vanBanDiDaXuly.getNgayNhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvNgayNhap.setText(String.valueOf(vanBanDiDaXuly.getNgayNhap()));
            tvKyHieu.setText(String.valueOf(vanBanDiDaXuly.getKyhieu()));
            RecyclerviewNoiNhanCuaSo((ArrayList<Noinhan>) vanBanDiDaXuly.getNoinhan());
            tvTrichYeu.setText(String.valueOf(vanBanDiDaXuly.getTrichYeu()));
            tvSodi.setText(String.valueOf(vanBanDiDaXuly.getSodi()));
            tvNguoiNhap.setText(String.valueOf(vanBanDiDaXuly.getNguoinhap()));
            if (vanBanDiDaXuly.getHienXoa() == 1) {
                btnXoaDuLieu.setVisibility(View.VISIBLE);
            }
            if (vanBanDiDaXuly.getSodi() > 0) {
                tvDaCapSo.setVisibility(View.VISIBLE);
            } else {
                tvChuaCapSo.setVisibility(View.VISIBLE);
            }
            tvFileDinhKem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vanBanDiDaXuly.getDuongdan()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBVanBanChuTriDaXuLyActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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
    public void onXoaDuLieuSuccess() {
        Toast.makeText(this, "Đã xóa dữ liệu", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public VanBanChuTriDaXuLyPresenter createPresenter() {
        return new VanBanChuTriDaXuLyPresenterImpl(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTiet, R.id.btnXoaDuLieu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBVanBanTrinhKyActivity.class);
                    intent.putExtra("ID_VANBAN_DI", id);
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
}
