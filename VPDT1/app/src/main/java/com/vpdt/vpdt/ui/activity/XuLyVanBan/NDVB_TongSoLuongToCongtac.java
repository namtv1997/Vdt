package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import com.vpdt.vpdt.model.NDVB_ToCongTac;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVB_ToCongTacView;
import com.vpdt.vpdt.presenter.NDVB_ToCongTac_Presenter;
import com.vpdt.vpdt.presenter.impl.NDVB_ToCongTacPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVB_TongSoLuongToCongtac extends BaseActivity<NDVB_ToCongTac_Presenter> implements NDVB_ToCongTacView, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {
    @BindView(R.id.tvSKH)
    TextView skh;
    @BindView(R.id.tvNoiGui)
    TextView noigui;
    @BindView(R.id.tvNgay)
    TextView ngay;
    @BindView(R.id.tvSoDen)
    TextView soden;
    @BindView(R.id.tvTrichYeu)
    TextView tvTrichYeu;
    @BindView(R.id.tvLoaiVanban)
    TextView tvLoaiVanban;
    @BindView(R.id.tvXemChiTietNDVB_TongSoLuongDonThu)
    TextView tvXemChiTiet;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;
    @BindView(R.id.rcvFileDinhKem)
    RecyclerView rvFileDinhKem;
    boolean click = false;
    int id;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb__tong_so_luong_to_cong_tac;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBANTOCONGTAC")) {
                id = intent.getIntExtra("ID_VANBANTOCONGTAC", 0);
                tvPhongChuTri.setText(getIntent().getStringExtra("PHONGCHUTRI"));
                tvNguoiNhap.setText(getIntent().getStringExtra("NGUOINHAP"));
                getPresenter().getbyidtocongtac(id);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess(NDVB_ToCongTac ndvb_toCongTac) {
        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) ndvb_toCongTac.getTepDinhKems());
        String shortdate = ndvb_toCongTac.getNgayNhan();
        ngay.setText(shortdate.substring(0, 5));
        soden.setText(String.valueOf(ndvb_toCongTac.getSoDen()));
        skh.setText(String.valueOf(ndvb_toCongTac.getSoKyHieu()));
        noigui.setText(String.valueOf(ndvb_toCongTac.getNoiGuiDen()));
        tvTrichYeu.setText(String.valueOf(ndvb_toCongTac.getTrichYeu()));
        tvLoaiVanban.setText(ndvb_toCongTac.getLoaiVanBan());
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @OnClick({R.id.btnBack, R.id.tvXemChiTietNDVB_TongSoLuongDonThu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVB_TongSoLuongDonThu:
                Intent intent = new Intent(NDVB_TongSoLuongToCongtac.this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", id);
                startActivity(intent);
                break;
        }
    }


    @Override
    public NDVB_ToCongTac_Presenter createPresenter() {
        return new NDVB_ToCongTacPresenterImpl(this);
    }

    @Override
    public void onItemClickFileDinhKem(TepDinhKem dinhKem) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dinhKem.getDuongDan()));
            startActivity(browserIntent);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi hệ thống!!!", Toast.LENGTH_SHORT).show();
        }
    }

    void recyclerviewFileDinhKem(ArrayList<TepDinhKem> tepDinhKems) {
        adapterFileDinhKemChoLanhDaoXuLy = new AdapterFileDinhKemChoLanhDaoXuLy(this, tepDinhKems, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFileDinhKem.setLayoutManager(layoutManager);
        rvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }
}
