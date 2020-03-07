package com.vpdt.vpdt.ui.activity.VanBanDi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vpdt.vpdt.R;
import com.vpdt.vpdt.base.BaseActivity;
import com.vpdt.vpdt.model.DeatailDauSoCuaSo;
import com.vpdt.vpdt.model.Noinhan;
import com.vpdt.vpdt.presenter.NDVBVanBanDaTrinhKyPresenter;
import com.vpdt.vpdt.presenter.NDVBVanBanDaTrinhKyView;
import com.vpdt.vpdt.presenter.impl.NDVBVanBanDaTrinhKyPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterNoiNhanCuaSo;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVBDSVBChoSoCuaSoActivity extends BaseActivity<NDVBVanBanDaTrinhKyPresenter> implements NDVBVanBanDaTrinhKyView {
    @BindView(R.id.tvNgay)
    TextView tvNgay;
    @BindView(R.id.tvSKH)
    TextView tvSoKyHieu;
    @BindView(R.id.tvSoDen)
    TextView tvSoDen;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvNguoiKy)
    TextView tvNguoiKy;
    @BindView(R.id.tvXem)
    TextView tvXemFilePDF;

    @BindView(R.id.lnSuaXoa)
    LinearLayout lnSuaXoa;

    int id;
    boolean click = false;
    @BindView(R.id.rcvNoiNhan)
    RecyclerView rcvNoiNhan;
    AdapterNoiNhanCuaSo adapterNoiNhanCuaSo;


    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvbdsvbcho_so_cua_so;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);
        DeatailDauSoCuaSo deatailDauSoCuaSo = getIntent().getParcelableExtra("ID_VANBAN_CHOSOCUASO");
        if (deatailDauSoCuaSo != null) {
            if (deatailDauSoCuaSo.getSuaANDXoa() == 1) {
                lnSuaXoa.setVisibility(View.VISIBLE);
            }
            RecyclerviewNoiNhanCuaSo((ArrayList<Noinhan>) deatailDauSoCuaSo.getNoinhan());
            id = deatailDauSoCuaSo.getMavb();
            String shortDate = deatailDauSoCuaSo.getTrichyeu().getNgaynhap();
            tvNgay.setText(shortDate.substring(0, 5));
            tvSoKyHieu.setText(String.valueOf(deatailDauSoCuaSo.getKyhieu()));
            tvSoDen.setText(String.valueOf(deatailDauSoCuaSo.getTrichyeu().getSoden()));
            tvLoaiVanban.setText(String.valueOf(deatailDauSoCuaSo.getLoaiVB()));
            tvTrichYeu.setText(String.valueOf(deatailDauSoCuaSo.getTrichyeu().getMota()));
            tvNguoiKy.setText(deatailDauSoCuaSo.getTrichyeu().getNguoiky());
            tvXemFilePDF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(deatailDauSoCuaSo.getDuongdan()));
                        startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(NDVBDSVBChoSoCuaSoActivity.this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.tvXemChiTiet, R.id.btnBack, R.id.btnXoa, R.id.btnSua})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvXemChiTiet:
                if (!click) {
                    Intent intent = new Intent(this, TTVBDSVBChoSoCuaSoActivity.class);
                    intent.putExtra("ID_VANBAN_CHOSOCUASO", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnSua:
                Intent intent1 = new Intent(this, SuaVanBanChoSoCuaSoActivity.class);
                intent1.putExtra("idvb", id);
                startActivity(intent1);
                break;
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnXoa:
                getPresenter().xoavb_trinhky(id);
                break;
        }
    }

    void RecyclerviewNoiNhanCuaSo(ArrayList<Noinhan> noinhanArrayList) {
        adapterNoiNhanCuaSo = new AdapterNoiNhanCuaSo(this, (ArrayList<Noinhan>) noinhanArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvNoiNhan.setLayoutManager(linearLayoutManager);
        rcvNoiNhan.setAdapter(adapterNoiNhanCuaSo);
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
