package com.vpdt.vpdt.ui.activity.XuLyVanBan;

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
import com.vpdt.vpdt.model.NDVB_QuanTrong;
import com.vpdt.vpdt.model.TepDinhKem;
import com.vpdt.vpdt.presenter.NDVB_QuanTrongView;
import com.vpdt.vpdt.presenter.NDVB_QuanTrong_Presenter;
import com.vpdt.vpdt.presenter.impl.NDVB_QuanTrongPresenterImpl;
import com.vpdt.vpdt.ui.adapter.AdapterFileDinhKemChoLanhDaoXuLy;
import com.vpdt.vpdt.util.Util;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NDVB_DSVB_QuanTrong extends BaseActivity<NDVB_QuanTrong_Presenter> implements NDVB_QuanTrongView, AdapterFileDinhKemChoLanhDaoXuLy.OnItemClickListenerFileDinhKem {
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
    @BindView(R.id.tvXemChiTietNDVB_DSVB_QuanTrong)
    TextView tvXemChiTiet;
    @BindView(R.id.tvPhongChuTri)
    TextView tvPhongChuTri;
    @BindView(R.id.tvNguoiNhap)
    TextView tvNguoiNhap;

    @BindView(R.id.btnBoVanBanQuanTrong)
    Button btnBoVanBanQuanTrong;
    @BindView(R.id.rcvFileDinhKem)
    RecyclerView rcvFileDinhKem;
    boolean click = false;
    int id;
    private AdapterFileDinhKemChoLanhDaoXuLy adapterFileDinhKemChoLanhDaoXuLy;

    @Override
    public int getContentViewId() {
        return R.layout.activity_ndvb__dsvb__quan_trong;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Util.checkConnection(this);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("ID_VANBANQUANTRONG")) {
                id = intent.getIntExtra("ID_VANBANQUANTRONG", 0);
                tvPhongChuTri.setText(getIntent().getStringExtra("PHONGCHUTRI"));
                tvNguoiNhap.setText(getIntent().getStringExtra("NGUOINHAP"));
                getPresenter().getbyidvbquantrong(id);

            }
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        click = false;
    }

    @Override
    public void onGetDataSuccess(NDVB_QuanTrong ndvb_quanTrong) {
        recyclerviewFileDinhKem((ArrayList<TepDinhKem>) ndvb_quanTrong.getTepDinhKems());
        String shortdate = ndvb_quanTrong.getNgayNhan();
        ngay.setText(shortdate.substring(0, 5));
        soden.setText(String.valueOf(ndvb_quanTrong.getSoDen()));
        skh.setText(String.valueOf(ndvb_quanTrong.getSoKyHieu()));
        noigui.setText(String.valueOf(ndvb_quanTrong.getNoiGuiDen()));
        tvTrichYeu.setText(String.valueOf(ndvb_quanTrong.getTrichYeu()));
        tvLoaiVanban.setText(ndvb_quanTrong.getLoaiVanBan());
    }

    @Override
    public void onGetBoQuanTrongSuccess() {
        Toast.makeText(this, "Bỏ văn bản quan trọng thành công", Toast.LENGTH_LONG).show();
        finish();

    }

    @OnClick({R.id.imvBack, R.id.tvXemChiTietNDVB_DSVB_QuanTrong, R.id.btnBoVanBanQuanTrong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imvBack:
                finish();
                break;
            case R.id.tvXemChiTietNDVB_DSVB_QuanTrong:
                if (!click) {
                    Intent intent = new Intent(NDVB_DSVB_QuanTrong.this, TTVB_DSVBDaDeXuatGiaHanGiaiQuyetActivity.class);
                    intent.putExtra("vanBanDaDeXuatGiaHanGiaiQuyet", id);
                    startActivity(intent);
                    click = true;
                }
                break;
            case R.id.btnBoVanBanQuanTrong:
                getPresenter().boquantrong(id);
                break;
        }
    }

    @Override
    public NDVB_QuanTrong_Presenter createPresenter() {
        return new NDVB_QuanTrongPresenterImpl(this);
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
        rcvFileDinhKem.setLayoutManager(layoutManager);
        rcvFileDinhKem.setAdapter(adapterFileDinhKemChoLanhDaoXuLy);
        adapterFileDinhKemChoLanhDaoXuLy.notifyDataSetChanged();
    }

}
